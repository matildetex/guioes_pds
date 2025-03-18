package lab13.XIII1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtProductsReader implements ProductsReader {
    private String filePath;

    public TxtProductsReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Product> getItems() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String type = parts[0].trim();
                    String brand = parts[1].trim();
                    String model_ano = parts[2].trim();
                    int max_speed = Integer.parseInt(parts[3].trim());

                    switch (type.toLowerCase()) {
                        case "car":
                            products.add(new Car(brand, model_ano, max_speed));
                            break;
                        case "motorcycle":
                            products.add(new Motorcycle(brand, model_ano, max_speed));
                            break;
                        case "van":
                            products.add(new Van(brand, model_ano, max_speed));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
