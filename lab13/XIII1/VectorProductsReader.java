package lab13.XIII1;

import java.util.Arrays;
import java.util.List;

public class VectorProductsReader implements ProductsReader {
    private List<Product> products;

    public VectorProductsReader(Product[] productsArray) {
        this.products = Arrays.asList(productsArray);
    }

    @Override
    public List<Product> getItems() {
        return products;
    }
}
