package api.pojos;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentS {
    private String anamnesis;
    private String createdBy;
    private String createdDate;
    private List<CtestS> ctests = new ArrayList<CtestS>();
    private String description;
    private String diagnosis;
    private String endDate;
    private Integer id;
    private String patient;
    private PhysicianS physician;
    private String prescription;
    private String startDate;
    private String status;
    private String treatment;
    public String getAnamnesis() {
        return anamnesis;
    }
    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
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
    public List<CtestS> getCtests() {
        return ctests;
    }
    public void setCtests(List<CtestS> ctests) {
        this.ctests = ctests;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPatient() {
        return patient;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }
    public PhysicianS getPhysician() {
        return physician;
    }
    public void setPhysician(PhysicianS physician) {
        this.physician = physician;
    }
    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
