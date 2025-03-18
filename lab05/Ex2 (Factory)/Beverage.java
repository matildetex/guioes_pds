package Ex2;

// Implementação da classe Beverage que representa uma bebida
class Beverage implements Portion {
    private Temperature temperature;
    private String name;

    public Beverage(String name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
    }
    @Override
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public State getState() {
        return State.liquid;
    }

    @Override
    public String toString() {
        return name + "Temperature " + temperature + ", State " + getState();
    }
}