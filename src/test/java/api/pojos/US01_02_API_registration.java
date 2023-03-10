package api.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US01_02_API_registration {
    private Boolean activated;
    private String createdBy;
    private String createdDate;
    private String email;
    private String firstName;
    private int id;
    private String imageUrl;
    private String langKey;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String lastName;
    private String login;
    private String password;
    private String ssn;
    private String [] authorities;

    public US01_02_API_registration() {
    }

    public US01_02_API_registration(Boolean activated, String createdBy, String createdDate, String email, String firstName,
                                    int id, String imageUrl, String langKey, String lastModifiedBy, String lastModifiedDate, String lastName,
                                    String login, String password, String ssn, String[] authorities) {
        this.activated = activated;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.imageUrl = imageUrl;
        this.langKey = langKey;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.ssn = ssn;
        this.authorities = authorities;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "US01_02_API_registration{" +
                "activated=" + activated +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", langKey='" + langKey + '\'' +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ssn='" + ssn + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                '}';
    }
}
/*
{
  "activated": true,
  "authorities": [
    "string"
  ],
  "createdBy": "ali",
  "createdDate": "2023-02-26T14:39:15.168Z",
  "email": "a@gmail.com",
  "firstName": "ali",
  "id": 0,
  "imageUrl": "string",
  "langKey": "string",
  "lastModifiedBy": "string",
  "lastModifiedDate": "2023-02-26T14:39:15.168Z",
  "lastName": "bisey",
  "login": "a_ali",
  "password": "123.kaleM",
  "ssn": "456-85-9655"
}
 */