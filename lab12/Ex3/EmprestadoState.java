package lab12.Ex3;

public class EmprestadoState implements State {
    public void regista(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public void requisita(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public void devolve(Livro livro) {
        livro.setState(new DisponivelState());
        System.out.println("Livro devolvido e agora está disponível.");
    }
    public void reserva(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public String getNome() {
        return "Emprestado";
    }
}