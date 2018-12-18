package SEP3.ClientSide.Domain.Model;

public class Administrator {

    private String firstName;
    private String lastName;
    private String administratorID;
    private String telephoneNumber;

    public Administrator(String firstName, String lastName, String administratorID, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.administratorID = administratorID;
        this.telephoneNumber = telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdministratorID() {
        return administratorID;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + administratorID + " " + telephoneNumber;
    }
}
