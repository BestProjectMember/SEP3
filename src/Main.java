import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        ApartmentList adminList = new ApartmentList();
        Apartment apartment = new Apartment(11, "1233", 1, true, 10.2, 1 );
        Apartment apartment1 = new Apartment(13, "1233", 2, true, 10.2, 1 );
        Apartment apartment2 = new Apartment(14, "1233", 1, true, 10.2, 1 );
        TenantList tenantList = new TenantList();
        Tenant tenant1 = new Tenant("lukas", "asdasd", "EC1234412",  new Date(11/1/1998), "adsasd@via.dk", "+4550505050", "dog");


        try {
            adminList.addApartment(apartment);
            adminList.addApartment(apartment1);
            adminList.addApartment(apartment2);
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println(adminList.getAllApartments() + "\n");

    }
}
