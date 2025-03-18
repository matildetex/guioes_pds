public class MotocicloEletrico extends Veiculo{

    String tipo = "desportivo";
    
    public MotocicloEletrico(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "MotocicloEletrico [tipo=" + tipo + "]";
    }


    public void carregar(int km) {
        System.out.println("Carregando até" + km);
    }


    
    
}
