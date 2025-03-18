package lab13.XIII1;


public class ImplFactorys implements ProductFactory{
    
    Product product;

    public ImplFactorys(Product product) {
        this.product = product;
    }

    @Override
    public Car createCar(String brand, String model_ano, int max_speed) {
        return new Car(brand, model_ano, max_speed);
    }

    @Override
    public Van createVan(String brand, String model_ano, int max_speed) {
    return new Van(brand, model_ano, max_speed);
    }

    @Override
    public Motorcycle createMotorcycle(String brand, String model_ano, int max_speed) {
        return new Motorcycle(brand, model_ano, max_speed);
    }

    @Override
    public OldJeep creatOldJeep(String data) {
        return new OldJeep(data);
    }
}


