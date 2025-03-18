import java.util.Arrays;
import java.util.Scanner;

public class Empresa {
    String nome;
    String codigoPostal;
    String email;
    private Object[] viaturas;
    Scanner sc = new Scanner(System.in);
    public Empresa(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.viaturas = new Object[100];

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addVeiculo(Object viatura){
        for(int i = 0; i < this.viaturas.length; i++){
            if(this.viaturas[i] == null){
                this.viaturas[i] = viatura;
                break; 
            }
        }
    }
    public void removeVeiculo(String viatura){
        for(int i = 0; i < this.viaturas.length; i++){
            if(getMatricula(this.viaturas[i]) == viatura){
                this.viaturas[i] = null;
                break; 
            }
        }
    }
    private String getMatricula(Object object) {
        if(object instanceof AutomovelLigeiro){
            return ((AutomovelLigeiro) object).getMatricula();
        }
        if(object instanceof Motociclo){
            return ((Motociclo) object).getMatricula();
        }
        if(object instanceof PesadoMercadorias){
            return ((PesadoMercadorias) object).getMatricula();
        }
        if(object instanceof PesadoPassageiros){
            return ((PesadoPassageiros) object).getMatricula();
        }
        return null;
    }
    public void trajeto(String viatura, int quilometros){
        for(int i = 0; i < this.viaturas.length; i++){
            if(getMatricula(this.viaturas[i]) == viatura){
                ((KmPercorridosInterface) this.viaturas[i]).trajeto(quilometros);
                break; 
            }
        }
    }
    public int distanciaTotal(String viatura){
        for(int i = 0; i < this.viaturas.length; i++){
            if(getMatricula(this.viaturas[i]) == viatura){
                return ((KmPercorridosInterface) this.viaturas[i]).distanciaTotal();
            }
        }
        return 0;
    }
    public int ultimoTrajeto(String viatura){
        for(int i = 0; i < this.viaturas.length; i++){
            if(getMatricula(this.viaturas[i]) == viatura){
                return ((KmPercorridosInterface) this.viaturas[i]).ultimoTrajeto();
            }
        }
        return 0;
    }
    public void listVeiculos(){
        for(int i = 0; i < this.viaturas.length; i++){
            if(this.viaturas[i] != null){
                System.out.println(this.viaturas[i]);
            }
        }
    }
    public void searchVeiculo(String matricula){
        for(int i = 0; i < this.viaturas.length; i++){
            if(getMatricula(this.viaturas[i]) == matricula){
                System.out.println(this.viaturas[i]);
            }
        }
    }
    public String maxKm(){
        int max = 0;
        for(int i = 0; i < this.viaturas.length; i++){
            if (this.viaturas[i] != null){
                if (((KmPercorridosInterface) this.viaturas[i]).distanciaTotal() > max){
                    max = ((KmPercorridosInterface) this.viaturas[i]).distanciaTotal();
                }
            }
        }
        String a = Integer.toString(max);
        String b  = "A distancia maxima percorrida foi de " + a + " km";
        return b;
    }
    public void driveVehicle(String matricula, int km){
        for(int i = 0; i < this.viaturas.length; i++){
            System.out.println(getMatricula(this.viaturas[i]));
            if (getMatricula(this.viaturas[i]).equals(matricula)){
                ((KmPercorridosInterface) this.viaturas[i]).trajeto(km);
                System.out.println("Adicionado!");
                break; 
            }
        }
    }
    public void chargeVehicle(String matricula, int km){
        for(int i = 0; i < this.viaturas.length; i++){
            if (getMatricula(this.viaturas[i]).equals(matricula)){
                if (this.viaturas[i] instanceof MotocicloEletrico) ((MotocicloEletrico) this.viaturas[i]).carregar(km);
                System.out.println("Carregado!");
                break; 
            }
        }System.out.println("Car not found!");
        sc.close();;
    }
    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", codigoPostal=" + codigoPostal + ", email=" + email + ", viaturas="
                + Arrays.toString(viaturas) + ", sc=" + sc + "]";
    }

    

    
}
