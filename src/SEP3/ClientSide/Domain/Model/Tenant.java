package SEP3.ClientSide.Domain.Model;

import java.time.LocalDate;

public class Tenant {
    private String firstName;
    private String lastName;
    private String tenantID;
    private LocalDate DOB;
    private String email;
    private String telephoneNumber;
    private String sex;
    private String username;
    private String password;

    public Tenant(String firstName, String lastName, String tenantID, LocalDate DOB, String email, String telephoneNumber, String sex, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tenantID = tenantID;
        this.DOB = DOB;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.sex = sex;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTenantID() {
        return tenantID;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public String toString(){
        String all = firstName + " " + lastName + " " + tenantID + " " + DOB + " " + email + " " + telephoneNumber + " " + sex;
        return all;
    }
}
