package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US20_API_StaffCreation {

    private String firstName;
    private String lastName;
    private int phone;
    private String ssn;
    private US20_API_UserPojo user;

    public US20_API_StaffCreation() {
    }

    public US20_API_StaffCreation(String firstName, String lastName, int phone, String ssn, US20_API_UserPojo user) {
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public US20_API_UserPojo getUser() {
        return user;
    }

    public void setUser(US20_API_UserPojo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "US20_API_StaffCreation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }
}


