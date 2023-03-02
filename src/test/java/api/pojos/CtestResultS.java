package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CtestResultS {
    private String createdBy;
    private String createdDate;
    private String ctest;
    private CtestItemS ctestItem;
    private String date;
    private String description;
    private Integer id;
    private String result;
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
    public String getCtest() {
        return ctest;
    }
    public void setCtest(String ctest) {
        this.ctest = ctest;
    }
    public CtestItemS getCtestItem() {
        return ctestItem;
    }
    public void setCtestItem(CtestItemS ctestItem) {
        this.ctestItem = ctestItem;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}