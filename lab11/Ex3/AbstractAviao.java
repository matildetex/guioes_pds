package lab11.Ex3;

public abstract class AbstractAviao {
    protected TorreControlo mediator;

    public AbstractAviao(TorreControlo mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveMessage();

    public abstract void sendMessage();
}
