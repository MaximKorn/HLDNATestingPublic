package Models;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User createUserFromData(String[] userData) {
        return new User(userData[0], userData[1]);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
