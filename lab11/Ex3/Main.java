package lab11.Ex3;

public class Main {
    public static void main(String[] args){
        TorreControlo mediator= new TorreControlo();
        Aviao p1= new Aviao(mediator);
        Aviao p2= new Aviao(mediator);
        mediator.addPlane(p1);
        mediator.addPlane(p2);
        p1.sendMessage();
        p2.sendMessage();
        p1.sendMessage();
        p2.sendMessage();
    }
}
