public abstract class Product {
    private static int lastAssignedId = 0;
    protected int id;
    private String name;
    private double price;
    private double discount;
    private int stock;
    private Brand brand;
    private String color;


    public Product(String name, double price, double discount, int stock, Brand brand, String color) {
        this.id = ++lastAssignedId;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.brand = brand;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}