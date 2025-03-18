package lab10.Ex2;

public class PastaChef extends Chef{

    public boolean canHandleRequest(String request){
        return request.toLowerCase().contains("pasta"); 
    }


    public void cookRequest(String request){
        System.out.println("PastaChef: Starting to cook " + request + ". Out in 14 minutes!");
    }
}
