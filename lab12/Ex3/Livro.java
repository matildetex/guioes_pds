package lab12.Ex3;

public class Livro {
    private String titulo;
    private String isbn;
    private int ano;
    private String autor;
    private State estado;

    public Livro(String titulo, String isbn, int ano, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.autor = autor;
        this.estado = new InventarioState();  // Estado inicial
    }

    public void setState(State estado) {
        this.estado = estado;
    }

    public void regista() {
        estado.regista(this);
    }

    public void requisita() {
        estado.requisita(this);
    }

    public void devolve() {
        estado.devolve(this);
    }

    public void reserva() {
        estado.reserva(this);
    }

    public void cancelaReserva() {
        estado.cancelaReserva(this);
    }

    public String getEstado() {
        return estado.getNome();
    }

    @Override
    public String toString() {
        return titulo + " " + autor + " [" + getEstado() + "]";
    }
}
