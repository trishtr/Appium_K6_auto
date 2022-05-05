package test_data.models;

public class LoginCredData {

    private String email;
    private String password;


    public LoginCredData(String email, String password) {
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

    @Override
    public String toString() {
        return "LoginCredData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
