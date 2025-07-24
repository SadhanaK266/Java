import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperMarketBillingSystem {
    static class User {
        String name;
        String email;
        String password;
        String role;

        public User(String name, String email, String password, String role) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
        }
    }
    static class UserDatabase {
        static Map<String, User> users = new HashMap<>();

        static {
            // Preloaded users
            users.put("admin@gmail.com", new User("Admin One", "admin@gmail.com", "admin123", "ADMIN"));
            users.put("customer@gmail.com", new User("Customer One", "customer@gmail.com", "cust123", "CUSTOMER"));
        }

        public static User authenticate(String email, String password) {
            if (users.containsKey(email)) {
                User user = users.get(email);
                if (user.password.equals(password)) {
                    return user;
                }
            }
            return null;
        }

        public static void addUser(User user) {
            users.put(user.email, user);
        }

        public static boolean emailExists(String email) {
            return users.containsKey(email);
        }
    }
    static class Authentication {
        public static User login(Scanner sc) {
            System.out.println("=== Super Market Billing System ===");
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = UserDatabase.authenticate(email, password);
            if (user != null) {
                System.out.println("\nLogin successful. Welcome, " + user.name + " (" + user.role + ")");
            } else {
                System.out.println("\nInvalid credentials. Please try again.");
            }
            return user;
        }
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User currentUser = null;

        while (currentUser == null) {
            currentUser = Authentication.login(sc);
        }
        if (currentUser.role.equalsIgnoreCase("ADMIN")) {
            adminMenu(sc, currentUser);
        } else if (currentUser.role.equalsIgnoreCase("CUSTOMER")) {
            customerMenu(sc, currentUser);
        }
        sc.close();
    }

    private static void adminMenu(Scanner sc, User user) {
        int choice;
        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Inventory Management");
            System.out.println("2. Manage Users");
            System.out.println("3. View Reports");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("-> Inventory management module coming soon.");
                    break;
                case 2:
                    System.out.println("-> Add or remove Admins/Customers coming soon.");
                    break;
                case 3:
                    System.out.println("-> Viewing reports coming soon...");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    private static void customerMenu(Scanner sc, User user) {
        int choice;
        do {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. View Cart & Purchase");
            System.out.println("3. View Purchase History");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("-> Displaying product list...");
                    break;
                case 2:
                    System.out.println("-> Shopping cart and payment...");
                    break;
                case 3:
                    System.out.println("-> Viewing past purchase history...");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

}
    