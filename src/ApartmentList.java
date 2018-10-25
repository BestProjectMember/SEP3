import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> list;

    public ApartmentList() {
        list = new ArrayList<Apartment>();
    }

    public void addApartment(Apartment apartment) {
        list.add(apartment);
    }

    public void removeApartment(int number) {
        for (int i = 0; i<list.size(); i++) {
            if (number == list.get(i).getNumber()) {
                list.remove(i);
            }
        }
    }

    public int size() {
        return list.size();
    }

    public String getAllApartments() {
        String a = "";
        for (int i = 0; i<list.size(); i++) {
            a+= list.get(i).toString() + "\n";
        }
        return a;
    }




}
