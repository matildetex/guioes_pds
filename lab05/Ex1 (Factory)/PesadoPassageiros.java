public class PesadoPassageiros extends Veiculo{
    int cargaMaxima;
    String numeroSerie;
    int numeroMaxPassageiros;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, int cargaMaxima,
            String numeroSerie, int numeroMaxPassageiros) {
        super(matricula, marca, modelo, potencia);
        this.cargaMaxima = cargaMaxima;
        this.numeroSerie = numeroSerie;
        this.numeroMaxPassageiros = numeroMaxPassageiros;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getNumeroMaxPassageiros() {
        return numeroMaxPassageiros;
    }

    public void setNumeroMaxPassageiros(int numeroMaxPassageiros) {
        this.numeroMaxPassageiros = numeroMaxPassageiros;
    }

    @Override
    public String toString() {
        return "PesadoPassageiros{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", cargaMaxima=" + cargaMaxima +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", numeroMaxPassageiros=" + numeroMaxPassageiros +
                '}';
    }
    
}
