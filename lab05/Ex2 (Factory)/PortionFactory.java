package Ex2;

// Implementação da classe de fábrica para criar instâncias de comidas
class PortionFactory {
    public static Portion create(String type, Temperature temperature) {
        switch (type) {
            case "Beverage":
                switch (temperature) {
                    case COLD:
                        return new Beverage("FruitJuice: Orange, ", temperature);
                    case WARM:
                        return new Beverage("Milk: ", temperature);
                    default:
                        break;
                }
        
            case "Meat":
                switch (temperature) {
                    case COLD:
                        return new Meat("Tuna",temperature);
                    case WARM:
                        return new Meat("Pork",temperature);
                    default:
                        break;
    }
}
    return null;
}
}
