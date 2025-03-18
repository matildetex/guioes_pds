package lab10.Ex2;

public class SushiChef extends Chef {
    public boolean canHandleRequest(String request){
        return request.toLowerCase().contains("sushi");
    }


    public void cookRequest(String request){
        System.out.println("SushiChef: Starting to cook " + request + ". Out in 14 minutes!");
    }
}