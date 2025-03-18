package lab12.Ex3;

public class ReservadoState implements State {
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
        System.out.println("Operação não disponível.");
    }
    public void cancelaReserva(Livro livro) {
        livro.setState(new DisponivelState());
        System.out.println("Reserva cancelada e livro agora está disponível.");
    }
    public String getNome() {
        return "Reservado";
    }
}
