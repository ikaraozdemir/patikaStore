public class NoteBook extends Product {
    private double screenSize;
    private int ram;
    private int storageCapacity;


    public NoteBook(String name, double price, double discount, int stock, Brand brand, String color,double screenSize,int ram,int storageCapacity) {
        super(name, price, discount, stock, brand, color);
        this.screenSize = screenSize;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
    }


    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
}
