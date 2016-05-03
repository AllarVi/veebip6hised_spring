package application.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaceUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String facebookId;

    private String name;

    private String authResponse;

    protected PaceUser() {
    }

    public PaceUser(String name, String facebookId) {
        this.name = name;
        this.facebookId = facebookId;
    }

    @Override
    public String toString() {
        return String.format("PaceUser[id=%d, name='%s', facebookId='%s']", id, name, facebookId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getAuthResponse() {
        return authResponse;
    }

    public void setAuthResponse(String authResponse) {
        this.authResponse = authResponse;
    }
}


