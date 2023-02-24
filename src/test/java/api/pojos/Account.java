package api.pojos;

import java.util.List;

public class Account extends User  {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    }

    public Account(boolean activated, List<Object> authorities, String createdBy, String createdDate, String email, String firstName, float id, String imageUrl, String langKey, String lastModifiedBy, String lastModifiedDate, String lastName, String login, String ssn, String password) {
        super(activated, authorities, createdBy, createdDate, email, firstName, id, imageUrl, langKey, lastModifiedBy, lastModifiedDate, lastName, login, ssn);
        this.password = password;
    }


}
