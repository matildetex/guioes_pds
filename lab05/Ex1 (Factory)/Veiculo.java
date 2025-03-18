public class Veiculo implements KmPercorridosInterface {
    
    String matricula;
    String marca;
    String modelo;
    int potencia;
    int ultimotrajeto;
    int distanciaTotal;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }
   
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void trajeto(int quilometros){
       ultimotrajeto = quilometros;
       distanciaTotal += quilometros;
    }

    public int ultimoTrajeto(){
        return ultimotrajeto;
    }
    public int distanciaTotal(){
        return distanciaTotal;
    }
}