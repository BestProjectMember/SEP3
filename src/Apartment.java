public class Apartment {

    private int number;
    private String location;
    private double size;
    private boolean status;
    private double price;
    private int floor;

    public Apartment(int number, String location, double size, boolean status, double price, int floor) {
        this.number = number;
        this.location = location;
        this.size = size;
        this.status = status;
        this.price = price;
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "number=" + number +
                ", location='" + location + '\'' +
                ", size=" + size +
                ", status=" + status +
                ", price=" + price +
                ", floor=" + floor +
                '}';
    }
}
