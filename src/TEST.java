import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TEST {

    private ApartmentList apartmentList;
    private TenantList tenantList;

    private boolean apartmentListIsEmpty() {
        return apartmentList.size() == 0;
    }

    private boolean tenantListIsEmpty() {
        return tenantList.size() == 0;
    }

    @Before
    public void setUp() {
        apartmentList = new ApartmentList();
        tenantList = new TenantList();
    }

    @After
    public void tearDown() {

    }

    // Zero
    @Test
    public void testApartmentListCreation() {
    }
    // Zero
    @Test
    public void testTenantListCreation() {
    }

    @Test
    public void testApartmentListIsEmptyWhenCreated() {
        assertTrue(apartmentListIsEmpty());
    }

    @Test
    public void testTenantListIsEmptyWhenCreated() {
        assertTrue(tenantListIsEmpty());
    }

    // One
    @Test
    public void testOneApartmentCanBeAdded() throws Exception {
        apartmentList.addApartment(new Apartment(11, "1233", 2, true, 10.2, 1 ));
        assertFalse(apartmentListIsEmpty());
    }

    @Test
    public void testApartmentCanBeAddedAndRemoved() throws Exception {
        apartmentList.addApartment(new Apartment(11, "1233", 1, true, 10.2, 1 ));
        apartmentList.removeApartmentByNumber(11);
        assertTrue(apartmentListIsEmpty());
    }

    @Test
    public void testOneTenantCanBeAdded() throws Exception {
        tenantList.addTenant(new Tenant("test", "test", "11", new Date(11/1/1998), "test", "123", "M"));
        assertFalse(tenantListIsEmpty());
    }

    @Test
    public void testTenantCanBeAddedAndRemoved() throws Exception {
        tenantList.addTenant(new Tenant("test", "test", "11", new Date(11/1/1998), "test", "123", "M"));
        tenantList.removeTenantByID("11");
        assertTrue(apartmentListIsEmpty());
    }

//    MORE OR MANY
        @Test
        public void testTwoApartmentsCanBeAdded() throws Exception {
            apartmentList.addApartment(new Apartment(11, "1233", 3, true, 10.2, 1 ));
            apartmentList.addApartment(new Apartment(12, "1233", 3, true, 10.2, 1 ));
            assertFalse(apartmentListIsEmpty());
        }

        @Test
        public void testTwoApartmentsCanBeAddedAndRemoved() throws Exception {
            apartmentList.addApartment(new Apartment(11, "1233", 3, true, 10.2, 1 ));
            apartmentList.addApartment(new Apartment(12, "1233", 3, true, 10.2, 1 ));
            apartmentList.removeApartmentByNumber(11);
            apartmentList.removeApartmentByNumber(12);
            assertTrue(apartmentListIsEmpty());
        }

    @Test
    public void testTwoTenantsCanBeAdded() throws Exception {
        tenantList.addTenant(new Tenant("test", "test", "11", new Date(11/1/1998), "test", "123", "M"));
        tenantList.addTenant(new Tenant("test", "test", "13", new Date(11/1/1998), "test", "123", "M"));
        assertFalse(tenantListIsEmpty());
    }

    @Test
    public void testTwoTenantsCanBeAddedAndRemoved() throws Exception {
        tenantList.addTenant(new Tenant("test", "test", "11", new Date(11/1/1998), "test", "123", "M"));
        tenantList.addTenant(new Tenant("test", "test", "13", new Date(11/1/1998), "test", "123", "M"));
        apartmentList.removeApartmentByNumber(11);
        apartmentList.removeApartmentByNumber(13);
        assertTrue(apartmentListIsEmpty());
    }



    /*
    *Boundaries*
        ArrayLists with undefined size are being used,
        therefore boundary testing is not needed
     */


     //EXCEPTIONAL BEHAVIOUR

    @Test (expected = Exception.class)
    public void testExceptionAddingApartmentWhichExists() throws Exception {
        apartmentList.addApartment(new Apartment(11, "1233", 3, true, 10.2, 1 ));
        apartmentList.addApartment(new Apartment(12, "1233", 3, true, 10.2, 1 ));
    }


//
//    @Test (expected = EmployeeExistsException.class)
//    public void testExceptionAddingDuplicateEmployee() throws SQLException, EmployeeExistsException {
//        Employee e1 = new Employee(111, "testFirstName", "testLastName", 911, "testEmail", "testRole", "01-01-2000" );
//        Employee e2 = new Employee(111, "testFirstName", "testLastName", 911, "testEmail", "testRole", "01-01-2000" );
//
//
//    }



}
