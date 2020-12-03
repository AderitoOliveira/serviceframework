package nuvemdesoftware.ceramicpro.authentication;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final JwtAuthenticationUser user;
    private final String auth_message;

    public JwtResponse(JwtAuthenticationUser user, String auth_message) {

        this.user = user;
        this.auth_message = auth_message;
    }

    public String getAuth_message() {
        return auth_message;
    }

    public JwtAuthenticationUser getUser() {
        return user;
    }
}
