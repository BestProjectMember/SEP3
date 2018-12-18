package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class ApartmentList {

    private ArrayList<Apartment> apartmentList;

    public ApartmentList() {
        apartmentList = new ArrayList<Apartment>();
    }

        public void addApartment(Apartment apartment) {
            apartmentList.add(apartment);
        }
    public int size() {
        return apartmentList.size();
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
