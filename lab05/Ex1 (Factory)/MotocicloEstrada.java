public class MotocicloEstrada extends Veiculo{
 
    String tipo = "estrada";

    public MotocicloEstrada(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motociclo: \n Tipo:" + tipo + "]";
    }
}
