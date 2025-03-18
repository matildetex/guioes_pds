package Ex2;

// Implementação da classe Meat que representa uma carne
class Meat implements Portion {
    private Temperature temperature;
    private String name;

    public Meat(String name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public State getState() {
        return State.solid;
    }

    @Override
    public String toString() {
        return name + ": Temperature " + temperature + ", State " + getState();
    }
}
