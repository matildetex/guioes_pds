public class PesadoMercadorias extends Veiculo {
    String numeroSerie;
    int capacidadeCarga;
    int nlitros;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, String numeroSerie, int capacidadeCarga, int nlitros) {
        super(matricula, marca, modelo, potencia);
        this.numeroSerie = numeroSerie;
        this.capacidadeCarga = capacidadeCarga;
        this.nlitros=nlitros;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
    public int getNlitros() {
        return nlitros;
    }

    public void setNlitros(int nlitros) {
        this.nlitros = nlitros;
    }

    @Override
    public String toString() {
        return "PesadoMercadorias{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", capacidadeCarga=" + capacidadeCarga +
                ", nlitros=" + nlitros +
                '}';
    }

}
