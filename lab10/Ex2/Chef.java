package lab10.Ex2;

public abstract class Chef{
    private Chef successor=null;

    public void handleRequest(String request) {
        if (canHandleRequest(request)) {
            cookRequest(request);
        } else{
            System.out.println(this.getClass().getSimpleName() + ": I can't cook that.");
            if (successor!= null) {
                successor.handleRequest(request);
            } else {
                System.out.println("We're sorry but that request can't be satisfied by our service!");
            }
        }
    }

    protected abstract boolean canHandleRequest(String request);
    protected abstract void cookRequest(String request);

    public Chef setsuccessor(Chef successor){
        this.successor = successor;
        return this;
    }
}
