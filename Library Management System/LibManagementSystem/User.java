import java.time.LocalDate;
import java.util.*;
public class User {
    String password;
    String email;
    String role;
    double deposit=1500.0;
    List<Book> borrowedBooks = new ArrayList<>();
    Map<String, LocalDate> borrowDates = new HashMap<>();

    public User(String password,String email,String role){
        this.password=password;
        this.email=email;
        this.role=role;
    }
}
