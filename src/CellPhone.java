public class CellPhone extends Product {
    private int memory;
    private double screenSize;
    private int batteryCapacity;
    private int ram;

    public CellPhone(String name, double price, double discount, int stock, Brand brand, String color, int memory, double screenSize, int batteryCapacity, int ram) {
        super(name, price, discount, stock, brand, color);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}

