package Ex1;
public class SpongeCakeBuilder implements CakeBuilder{
    private Cake cake = new Cake();

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Sponge");
    }

    @Override
    public void addCreamLayer() {
        cake.setmidLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopLayer() {
        cake.settopLayerCream(Cream.Whipped_Cream);
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
