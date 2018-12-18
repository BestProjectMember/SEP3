package SEP3.ClientSide.Domain.Model;

import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> apartmentList;

    public ApartmentList() {
        apartmentList = new ArrayList<Apartment>();
    }
    
        public void addApartment(Apartment apartment){
            apartmentList.add(apartment);
        }

    public int size() {
        return apartmentList.size();
    }

    public Apartment get(int number) {
        return apartmentList.get(number);
    }

    @Override
    public String toString() {
        String all = "";
        for(int i=0; i<apartmentList.size();i++)
        {
            all += apartmentList.get(i).toString() + ("\n");
        }
        return all;
    }




}
