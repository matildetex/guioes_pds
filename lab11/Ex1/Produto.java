package lab11.Ex1;

public class Produto {
    private static int codigoGenerator = 0;
    private int codigo;
    private String descricao;
    private double precoBase;
    private EstadoProduto estado;

    public Produto(String descricao, double precoBase) {
        this.codigo = ++codigoGenerator;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.estado = EstadoProduto.STOCK;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public EstadoProduto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProduto estado) {
        this.estado = estado;
    }
}
