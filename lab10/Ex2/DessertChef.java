package lab10.Ex2;

public class DessertChef extends Chef {
    public boolean canHandleRequest(String request){
        return request.toLowerCase().contains("dessert");
    }


    public void cookRequest(String request){
        System.out.println("DessertChef: Starting to cook " + request + ". Out in 17 minutes!");
    }
}
