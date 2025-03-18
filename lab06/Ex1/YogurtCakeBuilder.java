package Ex1;
public class YogurtCakeBuilder implements CakeBuilder{
    private Cake cake= new Cake();

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Yogurt");
    }

    @Override
    public void addCreamLayer() {
        cake.setmidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addTopLayer() {
        cake.settopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
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
