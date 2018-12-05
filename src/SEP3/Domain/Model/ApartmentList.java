package SEP3.Domain.Model;

import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> apartmentList;

    public ApartmentList() {
        apartmentList = new ArrayList<Apartment>();
    }
    
        public void addApartment(Apartment apartment) throws Exception {
            // checking if there is apartment with same number
            for(int i = 0; i < apartmentList.size(); i++)
            {
                if(apartmentList.get(i).getNumber() == apartment.getNumber())
                    throw new Exception("SEP3.Domain.SystemModel.Apartment with this number is already in the system");
            }

            // checking if all fields are filled
            if(apartment.getLocation().equals(""))
                throw new Exception("Make sure to enter the location");

            apartmentList.add(apartment);
        }

    public void removeApartmentByNumber(int number) {
        for (int i = 0; i<apartmentList.size(); i++) {
            if (number == apartmentList.get(i).getNumber()) {
                apartmentList.remove(i);
            }
        }
    }

    public int size() {
        return apartmentList.size();
    }

    public String getAllApartments() {
        String a = "";
        for (int i = 0; i<apartmentList.size(); i++) {
            a+= apartmentList.get(i).toString() + "\n";
        }
        return a;
    }

    public Apartment getApartmentByNumber(int number){
        for (int i=0; i<apartmentList.size();i++){
            if (apartmentList.get(i).getNumber() == number){
                return apartmentList.get(i);
            }

        }
        return null;
    }

    public Apartment getApartmnet(int index) {
        return apartmentList.get(index);
    }


    public void changeStatusOfApartmentByNumber(int number, boolean status){
        for (int i=0; i < apartmentList.size();i++)
        {
            if (apartmentList.get(i).getNumber() == number){
                apartmentList.get(i).setStatus(status);
            }
        }
    }

    @Override
    public String toString() {
        String all = " ";
        for(int i=0; i<apartmentList.size();i++)
        {
            all += apartmentList.get(i).toString() + ("\n");
        }
        return all;
    }




}
