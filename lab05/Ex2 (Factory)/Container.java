package Ex2;

// Classe para representar um recipiente
class Container {
    private Portion portion;
    private String name;

    private Container(String name, Portion portion) {
        this.name = name;
        this.portion = portion;
    }

    public static Container create(Portion portion) {
        switch (portion.getState()) {
            case solid:
                if (portion.getTemperature() == Temperature.COLD) {
                    return new Container("PlasticBag", portion);
                } else {
                    return new Container("Tupperware", portion);
                }
            case liquid:
                if (portion.getTemperature() == Temperature.COLD) {
                    return new Container("PlasticBottle", portion);
                } else {
                    return new Container("TermicBottle", portion);
                }
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return name + " with portion = " + portion.toString();
    }
}