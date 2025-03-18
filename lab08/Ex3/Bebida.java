public class Bebida implements Produto{
    private String label;
    private double weight;
    
    public Bebida(String label, int weight) {
        this.label = label;
        this.weight = Double.valueOf(weight);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void draw() {
        System.out.println("Doce '" + label + "' - Weight : " + weight + "]");
    }
     
}
