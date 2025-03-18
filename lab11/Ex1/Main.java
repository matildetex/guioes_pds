package lab11.Ex1;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Leite", 100);
        Produto p2 = new Produto("Bolachas", 200);
        Produto p3 = new Produto("Fruta", 300);

        Leilao leilao1 = new Leilao(p1);
        Leilao leilao2 = new Leilao(p2);
        Leilao leilao3 = new Leilao(p3);


        Cliente c1 = new Cliente("Sofia");
        Cliente c2 = new Cliente("Carolina");
        Cliente c3 = new Cliente("Matilde");

        Gestor g1 = new Gestor("Taylor Swift");

        leilao1.adicionarObserver(c1);
        leilao1.adicionarObserver(g1);
        leilao2.adicionarObserver(c2);
        leilao2.adicionarObserver(g1);
        leilao3.adicionarObserver(c3);
        leilao3.adicionarObserver(g1);

        leilao1.iniciarLeilao(10);
        leilao2.iniciarLeilao(15);
        leilao3.iniciarLeilao(20);

        c1.licitar(leilao1, 150);
        c2.licitar(leilao2, 250);
        c3.licitar(leilao3, 350);

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}