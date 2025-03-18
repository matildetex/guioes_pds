import java.util.ArrayList;
import java.util.List;

public class Rental{
    private String name;
    private String license;
    private String email;
    public List<Veiculo> listaveiculos = new ArrayList<Veiculo>();


    public Rental(String name, String license, String email) {
        this.name = name;
        this.license = license;
        this.email = email;
    }

    public void addVeiculo(Veiculo object) {
        listaveiculos.add(object);
    }

    public List<Veiculo> getStock() {
        return listaveiculos;
    }

}
