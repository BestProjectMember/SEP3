package SEP3.Servers.DatabaseServer.Model;

public class Administrator {

    private String firstName;
    private String lastName;
    private String administratorID;
    private String telephoneNumber;
    private TenantList tenantList;
    private ApartmentList apartmentList;

    public Administrator(String firstName, String lastName, String administratorID, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.administratorID = administratorID;
        this.telephoneNumber = telephoneNumber;
        this.tenantList = new TenantList();
        this.apartmentList = new ApartmentList();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(String administratorID) {
        this.administratorID = administratorID;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }



    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + administratorID + " " + telephoneNumber;
    }
}
