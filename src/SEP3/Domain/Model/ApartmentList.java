package SEP3.Domain.Model;

import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> list;

    public ApartmentList() {
        list = new ArrayList<Apartment>();
    }
    
        public void addApartment(Apartment apartment) throws Exception {
            // checking if there is apartment with same number
            for(int i = 0; i < list.size(); i++)
            {
                if(list.get(i).getNumber() == apartment.getNumber())
                    throw new Exception("SEP3.Domain.Model.Apartment with this number is already in the system");
            }

            // checking if all fields are filled
            if(apartment.getLocation().equals(""))
                throw new Exception("Make sure to enter the location");

            list.add(apartment);
        }

    public void removeApartmentByNumber(int number) {
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

    public Apartment getApartmentByNumber(int number){
        for (int i=0; i<list.size();i++){
            if (list.get(i).getNumber() == number){
                return list.get(i);
            }

        }
        return null;
    }

    public void changeStatusOfApartmentByNumber(int number, boolean status){
        for (int i=0; i < list.size();i++)
        {
            if (list.get(i).getNumber() == number){
                list.get(i).setStatus(status);
            }
        }
    }




}
