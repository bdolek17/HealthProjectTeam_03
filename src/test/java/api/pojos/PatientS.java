package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientS {
    private String adress;
    private List<AppointmentS> appointments = new ArrayList<AppointmentS>();
    private String birthDate;
    private String bloodGroup;
    private CountryS country;
    private String createdBy;
    private String createdDate;
    private CstateS cstate;
    private String description;
    private String email;
    private String firstName;
    private String gender;
    private String id;
    private List<InPatientS> inPatients = new ArrayList<InPatientS>();
    private String lastName;
    private String phone;
    private String ssn;
    private User user;
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public List<AppointmentS> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<AppointmentS> appointments) {
        this.appointments = appointments;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public CountryS getCountry() {
        return country;
    }
    public void setCountry(CountryS country) {
        this.country = country;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public CstateS getCstate() {
        return cstate;
    }
    public void setCstate(CstateS cstate) {
        this.cstate = cstate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<InPatientS> getInPatients() {
        return inPatients;
    }
    public void setInPatients(List<InPatientS> inPatients) {
        this.inPatients = inPatients;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
