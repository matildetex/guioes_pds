package lab12.Ex3;

public class DisponivelState implements State {
    public void regista(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public void requisita(Livro livro) {
        livro.setState(new EmprestadoState());
        System.out.println("Livro requisitado e agora está emprestado.");
    }
    public void devolve(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public void reserva(Livro livro) {
        livro.setState(new ReservadoState());
        System.out.println("Livro reservado.");
    }
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível.");
    }
    public String getNome() {
        return "Disponível";
    }
}