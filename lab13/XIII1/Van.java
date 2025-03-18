package lab13.XIII1;

public class Van implements Product{
    String brand;
    String model_ano;
    int max_speed;

    public Van(String brand, String model_ano, int max_speed) {
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
    public String code() {
        // TODO Auto-generated method stub
    return getBrand();
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return getModel_ano();
    }

    @Override
    public double points() {
        // TODO Auto-generated method stub
        return getMax_speed();
    }

    

}
