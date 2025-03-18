public class Motociclo extends Veiculo{

    String cavalos;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String cavalos2) {
        super(matricula, marca, modelo, potencia);
        this.cavalos =  cavalos2;
    }

    public String getcavalos() {
        return cavalos;
    }

    public void setcavalos(String cavalos) {
        this.cavalos = cavalos;
    }

    @Override
    public String toString() {
        return "Motociclo{" +
                "matricula='" + getMatricula() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", potencia=" + getPotencia() +
                ", cavalos='" + cavalos + '\'' +
                '}';
    }
    
}