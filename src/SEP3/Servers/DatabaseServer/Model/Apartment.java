package SEP3.Servers.DatabaseServer.Model;

public class Apartment {

    private int number;
    private String location;
    private int size;
    private boolean status;
    private double price;
    private int floor;

    public Apartment(int number, String location, int size, boolean status, double price, int floor) {
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

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public boolean getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
       String all = number + " " + location + " " + size + " " + status + " " + price + " " + floor;
       return all;
    }
}