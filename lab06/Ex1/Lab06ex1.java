package Ex1;
 // to complete

public class Lab06ex1 {
    public static void main(String[] args) {
        System.out.println("\n<<<<<<<<<<<<<<<<<<Opening Store>>>>>>>>>>>>>>>>>>>>>>>>>");
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");       // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");           // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // you should add here other example(s) of CakeBuilder   

        CakeBuilder redVelvet = new RedVelvetCakeBuilder();
        cakeMaster.setCakeBuilder(redVelvet);
        cakeMaster.createCake(Shape.Triangle, "Happy Birthday"); // Triangle, 1 cake layer
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder carrot = new CarrotCakeBuilder();
        cakeMaster.setCakeBuilder(carrot);
        cakeMaster.createCake( "Happy Easter"); // 1 layer
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder fruit = new FruitCakeBuilder();
        cakeMaster.setCakeBuilder(fruit);
        cakeMaster.createCake(Shape.Oval, 9, "Age is just a number"); // oval, 9 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        System.out.println("\n<<<<<<<<<<<<<<<<<<Closing Store>>>>>>>>>>>>>>>>>>>>>>>>>\n");       

    }
}
