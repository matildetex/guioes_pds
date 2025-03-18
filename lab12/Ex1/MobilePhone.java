package Ex1;

class MobilePhone {
    String processor;
    double price;
    int memory;
    double camera;

    public MobilePhone(String processor, double price, int memory, double camera) {
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "MobilePhone [processor=" + processor + ", price=" + price + ", memory=" + memory + ", camera=" + camera + "]";
    }
}