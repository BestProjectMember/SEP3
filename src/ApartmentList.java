import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> list;

    public ApartmentList() {
        list = new ArrayList<Apartment>();
    }

    public void addApartment(Apartment apartment) throws Exception {
        // checking if there is no apartment with same number
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getNumber() == apartment.getNumber())
                throw new Exception("Apartment with this number is already in the system");
        }

        // checking if all fields are filled
        if(apartment.getLocation().equals(""))
            throw new Exception("Make sure to enter the location");

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
