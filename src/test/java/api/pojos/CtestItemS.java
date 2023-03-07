package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CtestItemS {
    private String createdBy;
    private String createdDate;
    private String defaultValMax;
    private String defaultValMin;
    private String description;
    private Integer id;
    private String name;
    private Integer price;
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
    public String getDefaultValMax() {
        return defaultValMax;
    }
    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }
    public String getDefaultValMin() {
        return defaultValMin;
    }
    public void setDefaultValMin(String defaultValMin) {
        this.defaultValMin = defaultValMin;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
