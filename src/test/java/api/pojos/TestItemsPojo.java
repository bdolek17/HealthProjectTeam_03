package api.pojos;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestItemsPojo {
    private String createdBy;
    private String createdDate;
    private String defaultValMax;
    private String defaultValMin;
    private String description;
    private String name;
    private int price;

    public TestItemsPojo() {
    }

    public TestItemsPojo(String createdBy, String createdDate, String defaultValMax, String defaultValMin,
                         String description, String name, int price) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.defaultValMax = defaultValMax;
        this.defaultValMin = defaultValMin;
        this.description = description;
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TestItemsPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                ", defaultValMin='" + defaultValMin + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
/*
{
  "createdBy": "string",
  "createdDate": "2023-03-10T03:53:48.311Z",
  "defaultValMax": "string",
  "defaultValMin": "string",
  "description": "string",
  "id": 0,
  "name": "string",
  "price": 0
}
 */
