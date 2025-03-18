import java.util.ArrayList;
import java.util.List;

public class Caixa implements Produto {
    private String label;
    private double weight;
    private double total;
    private List<Produto> produtos;

    public Caixa(String label, double weight) {
        this.label = label;
        this.weight = weight;
        this.produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Double getWeight() {
        total = weight;
        for (Produto produto : produtos) {
            total += produto.getWeight();
        }
        return total;
    }

    public void build(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }
        String tab = indentation.toString();
        System.out.println(tab + "* Caixa '" + label + "' [ Weight: " + weight + " ; Total: " + getWeight() + "]");
        for (Produto produto : produtos) {
            if (produto instanceof Caixa) {
                ((Caixa) produto).build(depth + 1); //incrementa espaço consoante profundidade caixa
            } else {
                for (int i = 0; i < depth; i++) {
                    System.out.print("\t");
                }
                produto.draw();
            }
        }
    }

    public void draw() {
        build(0); // Começa com profundidade 0
    }
}
