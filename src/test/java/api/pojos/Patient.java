package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    private String id;
    private String ssn;
    private String lastName;
    private String firstName;
    private String birthDate;
    private String phone;
    private String email;
    private String gender;
    private String bloodGroup;
    private String address;
    private String description;
    private String createdDate;
    private String login;
    private String country;
    private String cstate;

    public Patient() {
    }

    public Patient(String id, String ssn, String lastName, String firstName, String birthDate, String phone, String email, String gender, String bloodGroup, String address, String description, String createdDate, String login, String country, String state_city) {
        this.id = id;
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.description = description;
        this.createdDate = createdDate;
        this.login = login;
        this.country = country;
        this.cstate = state_city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState_city() {
        return cstate;
    }

    public void setState_city(String state_city) {
        this.cstate = state_city;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", ssn='" + ssn + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", login='" + login + '\'' +
                ", country='" + country + '\'' +
                ", state_city='" + cstate + '\'' +
                '}';
    }
}
