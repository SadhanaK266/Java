import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static  Map<String,User> userMap=new HashMap<>();
    static  Map<String,Book> bookMap=new HashMap<>();
    static  Map<String,String> fineHistory=new HashMap<>();

    public static void main(String[] args) {
        preloadedUserData();
        login();
    }
    public static void preloadedUserData(){
        userMap.put("admineg@gmail.com",new User("admin123","admineg@gmail.com","Admin"));
        userMap.put("borrowereg@gmail.com",new User("borrowereg@gmail.com","borrower123","Borrower"));
    }
    public static void login(){
        System.out.println(".....Welcome to the Library Management System.....");
        System.out.print("Enter your email:");
        String email=sc.nextLine();
        System.out.print("Enter your password:");
        String password=sc.nextLine();  
        if(userMap.containsKey(email) && userMap.get(email).password.equals(password)){
            User currentUser=userMap.get(email);
            if(currentUser.role.equalsIgnoreCase("Admin")){
                System.out.println("Welcome Admin");
                adminMenu();
            }else{
                System.out.println("Welcome Borrower");
                borrowerMenu(currentUser);
            }
        }
        else{
            System.out.println("Invalid login detail(s)");
        }
    }
    public static void adminMenu(){
        while(true){
            System.out.println("-----Admin Menu-----");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. View Books");
            System.out.println("4. Search Book(By name / ISBN)");
            System.out.println("5. Add user(Admin/Borrower)");
            System.out.println("6. Logout");
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1: addBook(); break;
                case 2: removeBook(); break;
                case 3: viewBooks(); break;
                case 4:searchBook(); break;
                case 5: addUser(); break;
                case 6: System.out.println("You have logged out from the admin role");return;
                default: System.out.println("Invalid choice");
            }
        }
    }
    static  void addBook(){
        System.out.print("Enter the title : ");
        String title=sc.nextLine();
        System.out.print("Enter the author : ");
        String author=sc.nextLine();
        System.out.print("Enter the ISBN : ");
        String isbn=sc.nextLine();
        System.out.print("Enter the cost : ");
        double cost=sc.nextDouble();
        System.out.print("Enter the quantity : ");
        int quantity=sc.nextInt();
        Book b=new Book(title, author, isbn, cost, quantity);
        bookMap.put(isbn,b);
        System.out.println("Book added successfully.");
    }
    static  void removeBook(){
        System.out.println("Enter the ISBN ");
        String isbn=sc.nextLine();
        if(bookMap.containsKey(isbn)){
            bookMap.remove(isbn);
            System.out.println("Book removed successfully.");
        }
        else{
            System.out.println("Book not found");
        }
    }
    static  void viewBooks(){
        List<Book> bookList=new ArrayList<>(bookMap.values());
        System.out.println("View books in sorted order by\n1. Name\n2. Quantity");
        int ch=sc.nextInt();
        if(ch==1){
            bookList.sort(Comparator.comparing(book-> book.title));
        }
        else if(ch==2){
            bookList.sort(Comparator.comparingInt(book->book.quantity));
        }
        else{
            System.out.println("Enter a valid choice.");
        }
        for(Book i:bookList){
            System.out.println(i);
        }
    }
    static  void searchBook(){
        System.out.println("Search a book by\n1. Name\n2. ISBN");
        int ch=sc.nextInt();
        if(ch==1){
            System.out.println("Enter the name of the book: ");
            String name=sc.nextLine();
            for(Book i:bookMap.values()){
                if(i.title.contains(name)){
                    System.out.println(i+" is found");
                }
                else{
                    System.out.println("Book not found");
                }
            }
        }
        else if(ch==2){
            System.out.println("Enter ISBN of the book : ");
            String isbn=sc.nextLine();
            if(bookMap.get(isbn)!=null){
                System.out.println(isbn+" is found");
            }else{
                System.out.println("Book not found");
            }
        }
    }
    static void addUser(){
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        if (userMap.containsKey(email)) {
            System.out.println("User already exists.");
            return;
        }
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Role (Admin/Borrower): ");
        String role = sc.nextLine();
        userMap.put(email,new User(password,email,role));
        System.out.println("User added successfully");
    }


    public static void borrowerMenu(User u){
        while(true){
            System.out.println("-----Borrower Menu-----");
            System.out.println("1. View All Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. View Fine(s) & Balance");
            System.out.println("6. Logout");
            System.out.print("Enter your choice");
            int choice=sc.nextInt();
            switch (choice) {
                case 1: viewBooks(); break;//already there in adminMenu
                case 2: borrowBooks(u); break;
                case 3: returnReport(u); break;
                case 4: searchBook(); break;//already there in adminMenu
                case 5: viewFineAndBalance(u); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
    static  void borrowBooks(User u){
        if (u.deposit < 500) {
        System.out.println("Insufficient deposit -> Minimum ₹500 deposit required to borrow books.");
        return;
        }

        if (u.borrowedBooks.size() >= 3) {
            System.out.println("You have already borrowed 3 books. Return one to borrow more.");
            return;
        }
        System.out.print("Enter book title or ISBN to borrow: ");
        int ch = sc.nextInt(); 
        sc.nextLine();
        
        Book selectedBook = null;

        if (ch==1) {
            System.out.print("Enter book name: ");
            String name = sc.nextLine().toLowerCase();
            for (Book book : bookMap.values()) {
                if (book.title.toLowerCase().contains(name)) {
                    selectedBook = book;
                    break;
                }
            }
        } 
        else if (ch == 2) {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        selectedBook = bookMap.get(isbn);
        }
        if (selectedBook == null) {
            System.out.println("Book not found.");
            return;
        }

        if (u.borrowedBooks.contains(selectedBook.isbn)) {
            System.out.println("You have already borrowed this book.");
            return;
        }

        if (selectedBook.quantity <= 0) {
            System.out.println("Book out of stock.");
            return;
        }
        u.borrowedBooks.add(selectedBook.isbn);
        u.borrowDates.put(selectedBook.isbn, LocalDate.now());
        selectedBook.quantity--;
        System.out.println("Book borrowed successfully.");

    }
   
    static  void returnReport(User u){
        if(u.borrowedBooks.isEmpty()){
            System.out.println("No borrowed books to return");
            return;
        }
        System.out.println("Enter the ISBN of the book to return: ");
        String isbn=sc.nextLine();
        if (!u.borrowedBooks.contains(isbn)) {
            System.out.println("You have not borrowed this book.");
            return;
        }

        Book book = bookMap.get(isbn);
        LocalDate borrowedDate = u.borrowDates.get(isbn);

        System.out.print("Enter actual return date (DD/MM/YYYY): ");
        String returnDateStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate returnDate = LocalDate.parse(returnDateStr, formatter);

        long daysBorrowed = ChronoUnit.DAYS.between(borrowedDate, returnDate);
        double fine = 0.0;

        if (daysBorrowed > 15) {
            long extraDays = daysBorrowed - 15;
            fine = 2 * extraDays;
            long exponentialMultiplier = extraDays / 10;
            fine *= Math.pow(1.5, exponentialMultiplier);
            double maxFine = 0.8 * book.cost;
            fine = Math.min(fine, maxFine);
        }
        book.quantity++;
        u.borrowedBooks.remove(isbn);
        u.borrowDates.remove(isbn);

        if (fine > 0) {
            System.out.printf("You have a fine of ₹%.2f for returning '%s' late.%n", fine, book.title);
            System.out.println("Choose payment option:\n1. Deduct from deposit\n2. Pay by cash");
            int ch = Integer.parseInt(sc.nextLine());
            if (ch == 1) {
                u.deposit -= fine;
                System.out.println("Fine deducted from deposit.");
            } else {
                System.out.println("Fine to be collected in cash.");
            }
            u.fineHistory.put(isbn, "Late return fine ₹" + String.format("%.2f", fine));
        } else {
            System.out.println("Book returned on time. No fine.");
        }

        System.out.println("Return process completed.");
    }
    static void viewFineAndBalance(User borrower) {
        System.out.println("--------------------------");
        System.out.println("Deposit Balance: ₹" + borrower.deposit);
        System.out.println("----- Fine History -----");

        if (borrower.fineHistory.isEmpty()) {
            System.out.println("No fines yet.");
        } else {
            double totalFine = 0;

            for (Map.Entry<String, String> entry : borrower.fineHistory.entrySet()) {
                String isbn = entry.getKey();
                String reason = entry.getValue();
                Book book = bookMap.get(isbn);

                // Try to show book title if found
                String bookTitle = (book != null) ? book.title : "[Unknown Book]";
                
                // Extract fine amount from reason string
                String[] parts = reason.split("₹");
                double fineAmount = 0;
                if (parts.length > 1) {
                    try {
                        fineAmount = Double.parseDouble(parts[1]);
                    } catch (NumberFormatException e) {
                        // Skip if amount format is invalid
                    }
                }

                totalFine += fineAmount;
                System.out.printf("- %s (ISBN: %s): %s%n", bookTitle, isbn, reason);
            }

            System.out.println("--------------------------");
            System.out.printf("Total Fine Paid: ₹%.2f%n", totalFine);
        }

        System.out.println("--------------------------");
    }

}
