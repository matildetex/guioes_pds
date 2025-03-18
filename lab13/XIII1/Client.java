package lab13.XIII1;

import java.util.ArrayList;
import java.util.List;

public class Client implements Observer {
    private String id;
    private String name;
    private List<Product> borrowedProducts;

    public List<Product> getBorrowedProducts() {
        return borrowedProducts;
    }

    public void setBorrowedProducts(List<Product> borrowedProducts) {
        this.borrowedProducts = borrowedProducts;
    }

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedProducts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void add(Product product) {
        borrowedProducts.add(product);
    }

    public void remove(Product product) {
        borrowedProducts.remove(product);
    }

    @Override
    public void update(Product product) {
        System.out.println("Client " + name + " notified: " + product.code() + " is now available.");
    }

    @Override
    public String toString() {
        return "Client{id='" + id + "', name='" + name + "', borrowedProducts=" + borrowedProducts + "}";
    }
}
