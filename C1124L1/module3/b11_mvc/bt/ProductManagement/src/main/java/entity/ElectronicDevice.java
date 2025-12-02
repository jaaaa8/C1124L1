package entity;

public class ElectronicDevice extends Product{
    private String manufacturer;

    public ElectronicDevice(int id, String name, double price, String category, int quantity, float discount,
                            String manufacturer) {
        super(id, name, price, category, quantity, discount);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
