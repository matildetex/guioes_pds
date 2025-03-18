package lab10.Ex2;

public class PizzaChef extends Chef {
    public boolean canHandleRequest(String request){
        return request.toLowerCase().contains("pizza");
    }

    public void cookRequest(String request){
        System.out.println("PizzaChef: Starting to cook " + request + ". Out in 7 minutes!");
    }
}
