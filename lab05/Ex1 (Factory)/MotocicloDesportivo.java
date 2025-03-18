public class MotocicloDesportivo extends Veiculo{

    String tipo = "desportivo";
    
    public MotocicloDesportivo(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Motociclo: \n Tipo:" + tipo + "]";
    }
    
}
