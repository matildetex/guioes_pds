package lab11.Ex1;

class Gestor implements Observer {
    private String nome;

    public Gestor(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Gestor (" + nome + ") recebeu a mensagem: " + mensagem);
    }
}