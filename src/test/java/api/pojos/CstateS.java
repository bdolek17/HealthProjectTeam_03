package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CstateS {
    private CountryS country;
    private Integer id;
    private String name;
    public CountryS getCountry() {
        return country;
    }
    public void setCountry(CountryS country) {
        this.country = country;
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
}