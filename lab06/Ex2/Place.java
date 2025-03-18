package Ex2;


public class Place {
    private final String name;
    private final String address;

    public Place(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + ", " + address + ";";
    }
}
