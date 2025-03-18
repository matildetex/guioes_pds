package lab10.Ex2;

public class BurgerChef extends Chef{

    public boolean canHandleRequest(String request){
        return request.toLowerCase().contains("burger");
    }


    public void cookRequest(String request){
        System.out.println("BurgerChef: Starting to cook " + request + ". Out in 19 minutes!");
    }
}
