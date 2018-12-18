package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class RqApartmentList {
    private ArrayList<RqApartment> requestList;

    public RqApartmentList() {
        this.requestList = new ArrayList<>();
    }

    public RqApartment get(int index) {
        return requestList.get(index);
    }

    public void add(RqApartment request) {
        requestList.add(request);
    }

    public int size() {
        return requestList.size();
    }

    @Override
    public String toString() {
        String all = "";
        for(int i=0; i<requestList.size();i++)
        {
            all += requestList.get(i).toString() + ("\n");
        }
        return all;
    }
}