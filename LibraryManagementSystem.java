
import java.util.List;
import java.util.Map;
import java.util.Scanner;


enum Role{
    ADMIN,BORROWER
}
class  User{
    String email;
    String password;
    Role role;
    double deposit=1500;
    List<String> borrowedBooks = new ArrayList<>();

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
class  Book{
    String title;
    String isbn;
    int quantity;
    double price;
    List<String> borrowers = new ArrayList<>();

    public Book(String title, String isbn, int quantity, double price) {
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
    }
}
public class LibraryManagementSystem {
    Scanner sc=new Scanner(System.in);
    Map<String,User> users=new HashMap<>();
    Map<String,Book> books=new HashMap<>();
    Map<String, LocalDate> dueDates=new HashMap<>();

    public static void main(String[] args) {
        login();
    }

    public static void login(){
        System.out.print("Enter the email :");
        String email=sc.nextLine();
        System.out.print("Enter the password :");
        String password=sc.nextLine();

        if(users.containsKey(email) && users.get(email).password.equals(password)){
            User user = users.get(email);
            if(user.role == Role.ADMIN){
                System.out.println("Welcome Admin");
                // Admin functionalities
            } else {
                System.out.println("Welcome Borrower");
                // Borrower functionalities
            }
        } else {
            System.out.println("Invalid email or password");
        }
    }
}
