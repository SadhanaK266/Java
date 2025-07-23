
import java.time.LocalDate;
import java.util.*;


public class LibraryManagementSystem {
    enum Role{
    ADMIN,BORROWER
    }
    static class  User{
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
    static class  Book{
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


    static Scanner sc=new Scanner(System.in);
    static Map<String,User> users=new HashMap<>();
    static Map<String,Book> books=new HashMap<>();
    Map<String, LocalDate> dueDates=new HashMap<>();

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.sampleDataSet();
        library.login();
    }
    public void sampleDataSet() {
        users.put("admin@example.com", new User("admin@example.com","admin123", Role.ADMIN));
        users.put("borrower@example.com", new User("borrower@example.com","borrower123", Role.BORROWER));
    }
    public void login(){
        System.out.print("Enter the email :");
        String email=sc.nextLine();
        System.out.print("Enter the password :");
        String password=sc.nextLine();

        if(users.containsKey(email) && users.get(email).password.equals(password)){
            User user = users.get(email);
            if(user.role == Role.ADMIN){
                System.out.println("Welcome Admin");
                adminMenu(); // Admin functionalities
            } else {
                System.out.println("Welcome Borrower");
                // Borrower functionalities
            }
        } else {
            System.out.println("Invalid email or password");
        }
    }

    public static void adminMenu() {
        System.out.println();
        System.out.println("-----Admin Menu:------");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. View All Books");
        System.out.println("4. View Borrowers");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        // sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                viewAllBooks();
                break;
            case 4:
                viewBorrowers();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
        adminMenu(); 
    }
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        
        Book book = new Book(title, isbn, quantity, price);
        books.put(isbn, book);
        System.out.println("Book added successfully: " + book.title);
    }
    public static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = sc.nextLine();
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    public static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books.values()) {
                System.out.println("Title: " + book.title+" " + ", ISBN: " + book.isbn+" " + ", Quantity: " + book.quantity+" " + ", Price: " + book.price+" ");
            }
        }
    }
    public static void viewBorrowers() {
        System.out.println("Borrowers:");
        for (User user : users.values()) {
            if (user.role == Role.BORROWER) {
                System.out.println("Email: " + user.email+" " + ", Borrowed Books: " + user.borrowedBooks+" ");
            }
        }
    }
    
    public void borrowBook(String email, String isbn) {
        User user = users.get(email);
        Book book = books.get(isbn);
        
        if (user == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }
        if (book.quantity <= 0) {
            System.out.println("Book is not available for borrowing.");
            return;
        }
    }
        
        
}
