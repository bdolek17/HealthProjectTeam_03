package api.pojos;

public class US11_API_TC01_Patient {
    /*
{

        "id": 1252,
        "startDate": "2023-02-14T00:00:00Z",
        "endDate": "2023-02-14T01:00:00Z",
        "status": "UNAPPROVED",
        "anamnesis": null,
        "treatment": null,
        "diagnosis": null,
        "prescription": null,
        "description": null,
        "physician": null,
        "patient": {

            "createdDate": "2023-02-14T08:01:37.895540Z",
            "id": 1202,
            "firstName": "mustafa",
            "lastName": "ors",
           }
           }
 */

    private  String createdDate;
    private  String firstName;
    private  String lastName;

    public US11_API_TC01_Patient() {
    }

    public US11_API_TC01_Patient(String createdDate, String firstName, String lastName) {
        this.createdDate = createdDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    @Override
    public String toString() {
        return "US11_API_TC01_Patient{" +
                "createdDate='" + createdDate + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
