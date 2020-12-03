package nuvemdesoftware.ceramicpro.authentication;

public class JwtAuthenticationUser {

    private String username;
    private String token;

    public JwtAuthenticationUser(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
