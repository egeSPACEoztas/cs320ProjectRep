public class items {

    public int pid,quantity;
    public double price;
    public String name,brand;

    public items(int pid, String name, double price , String brand, int quantity) {
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public int getPid() {
        return pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
