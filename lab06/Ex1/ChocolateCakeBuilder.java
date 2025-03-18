package Ex1;
public class ChocolateCakeBuilder implements CakeBuilder{
    private Cake cake=new Cake();

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.setCakeLayer("Soft Chocolate");
    }

    @Override
    public void addCreamLayer() {
        cake.setmidLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopLayer() {
        
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
