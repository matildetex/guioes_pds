package lab13.XIII1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ToShare implements ProductsReader {
    private List<Product> products;
    private Map<String, Queue<Client>> waitList;
    private List<Client> observers;

    public ToShare() {
        this.products = new ArrayList<>();
        this.waitList = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public void setProducts(ProductsReader reader) {
        this.products = reader.getItems();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addObserver(Client client) {
        observers.add(client);
    }

    public void removeObserver(Client client) {
        observers.remove(client);
    }

    private void notifyObservers(Product product) {
        for (Client observer : observers) {
            observer.update(product);
        }
    }

    public boolean add(Product p) {
        return products.add(p);
    }

    public Product remove(String code) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                products.remove(p);
                return p;
            }
        }
        return null;
    }

    public boolean share(String code, Client user) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                if (p.isAvailable()) {
                    p.setAvailable(false);
                    user.add(p);
                    return true;
                } else {
                    waitList.computeIfAbsent(code, k -> new LinkedList<>()).add(user);
                    return false;
                }
            }
        }
        return false;
    }

    public boolean share(Product p, Client user) {
        return share(p.code(), user);
    }

    public boolean giveBack(String code) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                if (!p.isAvailable()) {
                    p.setAvailable(true);
                    Queue<Client> queue = waitList.get(code);
                    if (queue != null && !queue.isEmpty()) {
                        Client nextClient = queue.poll();
                        share(code, nextClient);
                    }
                    notifyObservers(p);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean giveBack(Product p) {
        return giveBack(p.code());
    }

    public List<Product> sharedProducts() {
        List<Product> sharedProducts = new ArrayList<>();
        for (Product p : products) {
            if (!p.isAvailable()) {
                sharedProducts.add(p);
            }
        }
        return sharedProducts;
    }

    @Override
    public List<Product> getItems() {
        return products;
    }
}
