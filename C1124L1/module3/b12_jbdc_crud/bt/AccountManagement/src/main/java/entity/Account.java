package entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    public Account(int id, String username,  String password, String email, String role) {
        this.email = email;
        this.id = id;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public Account() {

    }

    public Account(String userName, String password, String role, String email) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
