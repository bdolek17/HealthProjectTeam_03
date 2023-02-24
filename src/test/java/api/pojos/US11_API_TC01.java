package api.pojos;

public class US11_API_TC01 {
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
            "createdBy": "anonymousUser",
            "createdDate": "2023-02-14T08:01:37.895540Z",
            "id": 1202,
            "firstName": "mustafa",
            "lastName": "ors",
           }
           }
 */
    private  String Id;
    private  String startDate;
    private  String endDate;
    private  String status;
    private  String anamnesis;
    private  String treatment;
    private  String diagnosis;
    private  String prescription;
    private  String description;
    private  String physician;

    public US11_API_TC01(String id, String startDate, String endDate, String status, String anamnesis, String treatment, String diagnosis, String prescription, String description, String physician) {
        Id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.description = description;
        this.physician = physician;
    }

    public US11_API_TC01() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }

    @Override
    public String toString() {
        return "US11_API_TC01{" +
                "Id='" + Id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", description='" + description + '\'' +
                ", physician='" + physician + '\'' +
                '}';
    }
}


