import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TEST {

    private ApartmentList list;

    private boolean isEmpty() {
        return list.size() == 0;
    }

    @Before
    public void setUp() {
        list = new ApartmentList();
    }

    @After
    public void tearDown() {

    }

    // Zero
    @Test
    public void testApartmentCreation() {
    }

    @Test
    public void testApartmentListEmptyWhenCreated() {
        assertTrue(isEmpty());
    }

    // One
    @Test
    public void testOneApartmentCanBeAdded() {
        list.addApartment(new Apartment(11, "1233", 23.3, true, 10.2, 1 ));
        assertFalse(isEmpty());
    }

    @Test
    public void testApartmentCanBeAddedAndRemoved() {
        list.addApartment(new Apartment(11, "1233", 23.3, true, 10.2, 1 ));
        list.removeApartment(11);
        assertTrue(isEmpty());
    }

//    MORE OR MANY
        @Test
        public void testTwoApartmentsCanBeAdded() {
            list.addApartment(new Apartment(11, "1233", 23.3, true, 10.2, 1 ));
            list.addApartment(new Apartment(12, "1233", 23.3, true, 10.2, 1 ));
            assertFalse(isEmpty());
        }

        @Test
        public void testTwoApartmentsCanBeAddedAndRemoved() {
            list.addApartment(new Apartment(11, "1233", 23.3, true, 10.2, 1 ));
            list.addApartment(new Apartment(12, "1233", 23.3, true, 10.2, 1 ));
            list.removeApartment(11);
            list.removeApartment(12);
            assertTrue(isEmpty());
        }



    /*
    *Boundaries*
        ArrayLists with undefined size are being used,
        therefore boundary testing is not needed
     */


    // EXCEPTIONAL BEHAVIOUR

//    @Test (expected = ItemExistsException.class)
//    public void testExceptionAddingItemWhichExists() throws SQLException, ItemExistsException {
//        ItemList list = new ItemList();
//        Item item1 = new Item(1, "testName", "testSize", 111, "testType", "testLocation");
//        Item item2 = new Item(1, "testName", "testSize", 111, "testType", "testLocation");
//        list.add(item1);
//        list.add(item2);
//
//    }
//
//    @Test (expected = EmployeeExistsException.class)
//    public void testExceptionAddingDuplicateEmployee() throws SQLException, EmployeeExistsException {
//        Employee e1 = new Employee(111, "testFirstName", "testLastName", 911, "testEmail", "testRole", "01-01-2000" );
//        Employee e2 = new Employee(111, "testFirstName", "testLastName", 911, "testEmail", "testRole", "01-01-2000" );
//
//
//    }



}
