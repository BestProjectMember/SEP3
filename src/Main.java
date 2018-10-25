public class Main {

    public static void main(String[] args) {

        ApartmentList list = new ApartmentList();
        Apartment apartment = new Apartment(11, "1233", 23.3, true, 10.2, 1 );
        Apartment apartment1 = new Apartment(13, "1233", 23.3, true, 10.2, 1 );
        Apartment apartment2 = new Apartment(14, "1233", 23.3, true, 10.2, 1 );

        list.addApartment(apartment);
        list.addApartment(apartment1);
        list.addApartment(apartment2);
        list.removeApartment(14);

        System.out.println(list.getAllApartments() + "\n");

    }
}
