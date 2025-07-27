import java.util.*;
public class User {
    String email, password, role;
    double credit = 1000;
    int loyaltyPoints = 0;
    List<Purchase> history = new ArrayList<>();

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
