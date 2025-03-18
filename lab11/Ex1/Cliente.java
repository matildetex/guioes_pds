package lab11.Ex1;

class Cliente implements Observer {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Cliente (" + nome + ") recebeu a mensagem: " + mensagem);
    }

    public void licitar(Leilao leilao, double valor) {
        leilao.licitar(this, valor);
    }
}