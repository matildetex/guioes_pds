public class Taxi extends AutomovelLigeiro{
    
    String numeroLicença;

    public Taxi(String matricula, String marca, String modelo, int potencia, String numeroSerie, int capacidadeBagageira,
            String numeroLicença) {
        super(matricula, marca, modelo, potencia, numeroSerie, capacidadeBagageira);
        this.numeroLicença = numeroLicença;
    }

    public String getNumeroLicença() {
        return numeroLicença;
    }

    public void setNumeroLicença(String numeroLicença) {
        this.numeroLicença = numeroLicença;
    }
    
    @Override
    public String toString() {
        return "Taxi{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", numeroSerie='" + getnumeroSerie() + '\'' +
                ", capacidadeBagageira=" + getCapacidadeBagageira() +
                ", numeroLicença='" + numeroLicença + '\'' +
                '}';
    }

   
}
