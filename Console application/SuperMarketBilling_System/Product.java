public class Product {
    String id, name;
    double price;
    int quantity;
    int totalSales = 0;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
