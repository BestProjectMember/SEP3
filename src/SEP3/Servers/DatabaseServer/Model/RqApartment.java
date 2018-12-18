package SEP3.Servers.DatabaseServer.Model;

import com.google.gson.annotations.SerializedName;

public class RqApartment {
    @SerializedName("firstName")
    public String firstName;
    @SerializedName("lastName")
    public String lastName;
    @SerializedName("id")
    public String id;
    @SerializedName("email")
    public String email;
    @SerializedName("campus")
    public String campus;
    @SerializedName("roomNumber")
    public String roomNumber;

    public RqApartment(String firstName, String lastName, String id, String email, String campus, String roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.campus = campus;
        this.roomNumber = roomNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCampus() {
        return campus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "RqApartment{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", campus='" + campus + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
