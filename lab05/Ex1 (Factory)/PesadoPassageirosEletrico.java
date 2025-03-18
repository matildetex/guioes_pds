public class PesadoPassageirosEletrico extends Veiculo {
    int capacidadeBateria;
    String numeroSerie;
    int autonomia;
    int custoDiario;
    int custoMensal;

    public PesadoPassageirosEletrico(String matricula, String marca, String modelo, int custoDiario, int custoMensal, String numeroSerie, int capacidadeBateria, int autonomia, int potencia) {
        super(matricula, marca, modelo, potencia);
        this.custoDiario = custoDiario;
        this.custoMensal = custoMensal;
        this.numeroSerie = numeroSerie;
        this.capacidadeBateria = capacidadeBateria;
        this.autonomia = autonomia;
        this.potencia = potencia;
    }

    public int getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(int capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCustoDiario() {
        return custoDiario;
    }

    public void setCustoDiario(int custoDiario) {
        this.custoDiario = custoDiario;
    }

    public int getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(int custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "PesadoPassageirosEletrico{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", capacidadeBateria=" + capacidadeBateria +
                ", autonomia=" + autonomia +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", custoDiario=" + custoDiario +
                ", custoMensal=" + custoMensal +
                '}';
    }

}
