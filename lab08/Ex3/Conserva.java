public class Conserva implements Produto{
    private String label;
    private double weight;
    
    public Conserva(String label, int weight) {
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
        System.out.println("Conserva '" + label + "' - Weight : " + weight + "]");
    }
}
