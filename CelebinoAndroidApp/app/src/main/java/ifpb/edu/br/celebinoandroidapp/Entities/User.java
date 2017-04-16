package ifpb.edu.br.celebinoandroidapp.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gabri on 15/04/2017.
 */
public class User {

    private Long id;

    private String email;

    private String name;

    private String password;

    private String username;



    public User(){}

    public User(String email, String password){

    }

    public User(Long id, String email, String name, String username, String password) {
        super();
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User [name=" + name + ", username=" + username + ", email=" + email  + "]";
    }
}