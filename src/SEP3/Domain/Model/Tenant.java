package SEP3.Domain.Model;

import java.util.Date;

public class Tenant {
    private String firstName;
    private String lastName;
    private String tenantID;
    private Date DOB;
    private String email;
    private String telephoneNumber;
    private String sex;

    public Tenant(String firstName, String lastName, String tenantID,Date DOB, String email, String telephoneNumber, String sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tenantID = tenantID;
        this.DOB = DOB;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.sex = sex;
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

    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString(){
        String all = firstName + " " + lastName + " " + tenantID + " " + DOB + " " + email + " " + telephoneNumber + " " + sex;
        return all;
    }
}
