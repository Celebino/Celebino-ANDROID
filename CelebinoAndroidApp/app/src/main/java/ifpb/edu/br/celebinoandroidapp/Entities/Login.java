package ifpb.edu.br.celebinoandroidapp.Entities;

/**
 * Created by gabri on 15/04/2017.
 */
public class Login {

    private String email;
    private String password;

    public Login(){}

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
