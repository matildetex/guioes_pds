package lab13.XIII1;

public class Car implements Product{
    String brand;
    String model_ano;
    int max_speed;

    public Car(String brand, String model_ano, int max_speed) {
        this.brand = brand;
        this.model_ano = model_ano;
        this.max_speed = max_speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel_ano() {
        return model_ano;
    }

    public void setModel_ano(String model_ano) {
        this.model_ano = model_ano;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model_ano=" + model_ano + ", max_speed=" + max_speed + "]";
    }

    @Override
    public String code() {
        return getBrand();
    }

    @Override
    public String description() {
        return getModel_ano();
    }

    @Override
    public double points() {
        return getMax_speed();
    }
}
