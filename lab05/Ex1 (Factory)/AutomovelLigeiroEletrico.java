public class AutomovelLigeiroEletrico extends Veiculo {
    String numeroSerie;
    int capacidadeBagageira;
    int autonomia;
    int capacidadeBateria;
    
    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, String numeroSerie,
            int capacidadeBagageira, int autonomia, int capacidadeBateria) {
        super(matricula, marca, modelo, potencia);
        this.numeroSerie = numeroSerie;
        this.capacidadeBagageira = capacidadeBagageira;
        this.autonomia = autonomia;
        this.capacidadeBateria = capacidadeBateria;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public int getCapacidadeBagageira() {
        return capacidadeBagageira;
    }
    public void setCapacidadeBagageira(int capacidadeBagageira) {
        this.capacidadeBagageira = capacidadeBagageira;
    }
    public int getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
    public int getCapacidadeBateria() {
        return capacidadeBateria;
    }
    public void setCapacidadeBateria(int capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }
    
    @Override
    public String toString() {
        return "AutomovelLigeiroEletrico{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", capacidadeBagageira=" + capacidadeBagageira +
                ", autonomia=" + autonomia +
                ", capacidadeBateria=" + capacidadeBateria +
                '}';
    }


   
}