package pojos;

public class Appointment {

    private String firstName;
    private String lastName;
    private int phone;
    private int ssn;
    private String user;

    public Appointment(String firstName, String lastName, int phone, int ssn, String user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.ssn = ssn;
        this.user = user;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", ssn=" + ssn +
                ", user='" + user + '\'' +
                '}';
    }
}


