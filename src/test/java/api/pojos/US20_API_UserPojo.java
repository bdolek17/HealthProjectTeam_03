package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US20_API_UserPojo {

    private Boolean activated;
    private String login;
    private String ssn;

    public US20_API_UserPojo(Boolean activated, String login, String ssn) {
        this.activated = activated;
        this.login = login;
        this.ssn = ssn;
    }

    public US20_API_UserPojo() {
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "US20_API_UserPojo{" +
                "activated=" + activated +
                ", login='" + login + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
/*
{

    "firstName": "Angel",
    "lastName": "Dolek",
    "phone": 4443331022,
    "ssn": "321-33-4567",
    "user":
    {
        "activated": true,
        "login": "string",
        "ssn":"321-33-4667"
    }

}
 */