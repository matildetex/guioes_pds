package lab13.XIII1;

public interface ProductFactory {
    Car createCar(String brand, String model_ano, int max_speed);
    Van createVan(String brand, String model_ano, int max_speed);
    Motorcycle createMotorcycle(String brand, String model_ano, int max_speed);
    OldJeep creatOldJeep(String data);
}
