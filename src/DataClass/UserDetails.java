package DataClass;

public class UserDetails {

    private String userId;
    private String password;
    private String role;


    public UserDetails(String userId, String passwrd,String role) {
        this.userId = userId;
        this.password = passwrd;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return "DataClass.UserDetails{" +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }
}
