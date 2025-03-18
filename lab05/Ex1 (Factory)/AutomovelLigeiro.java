public class AutomovelLigeiro extends Veiculo{
    String numeroSerie;
    int capacidadeBagageira;
    
    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String string,
            int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numeroSerie = string;
        this.capacidadeBagageira = capacidadeBagageira;
    }

    public String getnumeroSerie() {
        return numeroSerie;
    }

    public void setnumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCapacidadeBagageira() {
        return capacidadeBagageira;
    }

    public void setCapacidadeBagageira(int capacidadeBagageira) {
        this.capacidadeBagageira = capacidadeBagageira;
    }

    @Override
    public String toString() {
        return "AutomovelLigeiro{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", capacidadeBagageira=" + capacidadeBagageira +
                '}';
    }
   
}
