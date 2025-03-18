package lab11.Ex3;
public class Aviao extends AbstractAviao {
    private static int counter = 0;
    private int id;

    public Aviao(TorreControlo controlo) {
        super(controlo);
        counter++;
        this.id = counter;
    }

    @Override
    public void sendMessage() {
        System.out.println("Aviao " + id + " asks for permission.");
        mediator.sendMessage(this);
    }

    public int getId() {
        return id;
    }

    @Override
    public void receiveMessage() {
        System.out.println("Permission Granted: Aviao " + id + ".");
    }
}