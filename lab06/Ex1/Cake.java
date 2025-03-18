package Ex1;

public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public void setShape(Shape shape) { this.shape = shape; }
    public void setCakeLayer(String cakeLayer) { this.cakeLayer = cakeLayer; }
    public void setnumCakeLayers(int numCakesLayers) { this.numCakeLayers=numCakesLayers;}
    public void setmidLayerCream(Cream midLayerCream) { this.midLayerCream=midLayerCream; }
    public void settopLayerCream(Cream topLayerCream) { this.topLayerCream=topLayerCream;}
    public void setTopping(Topping topping) { this.topping = topping;}
    public void setMessage(String message) { this.message=message;}
    
    @Override
    public String toString() {
        System.out.println("\n");
        if (topLayerCream == null) {
            return cakeLayer + " cake with " + numCakeLayers + " layers, topped with " + midLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".";
        }
        return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + " cream, topped with " + topLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".";
    }
    
    
}
