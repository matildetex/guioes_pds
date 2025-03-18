package Ex1;

public class CakeMaster { /*Director*/
    private CakeBuilder cakeBuilder;
    
    public void setCakeBuilder(CakeBuilder cb) { 
        cakeBuilder = cb; 
    }
    public void createCake(String message) {
        cakeBuilder.addMessage(message);
        this.getCake().setnumCakeLayers(1);
        cakeBuilder.createCake();
    }

    public void createCake(Shape shape, int layer, String message) {
        cakeBuilder.addMessage(message);
        this.getCake().setnumCakeLayers(layer);
        cakeBuilder.addCakeLayer();
        cakeBuilder.setCakeShape(shape);
        cakeBuilder.createCake();
    }

    public void createCake(int layer, String message) {
        cakeBuilder.addMessage(message);
        this.getCake().setnumCakeLayers(layer);
        cakeBuilder.addCakeLayer();
        cakeBuilder.createCake();
    }

    public void createCake(Shape shape, String message) {
        cakeBuilder.addMessage(message);
        this.getCake().setnumCakeLayers(1);
        cakeBuilder.addCakeLayer();
        cakeBuilder.createCake();
    }


    public Cake getCake() { 
        return cakeBuilder.getCake(); 
    }
}
