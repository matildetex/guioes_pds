package Ex1;

public class FruitCakeBuilder implements CakeBuilder{
    private Cake cake= new Cake();

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Fruit");
    }

    @Override
    public void addCreamLayer() {
        cake.setmidLayerCream(Cream.Chocolate);
    }

    @Override
    public void addTopLayer() {
        cake.settopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    @Override
    public void addMessage(String m) {
        cake.setMessage(m);
    }

    @Override
    public void createCake() {
            addCakeLayer();
            addCreamLayer();
            addTopLayer();
            addTopping();
    }

    @Override
    public Cake getCake() {
        return cake;
    }
}
