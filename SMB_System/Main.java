import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, User> users = new HashMap<>();
    static HashMap<String, Product> products = new HashMap<>();
    static String currentUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. SignUp\n2. SignIn\n3. Exit");
            int opt = Integer.parseInt(sc.nextLine());
            switch (opt) {
                case 1 -> signUp();
                case 2 -> signIn();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    static void signUp() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Role (admin/customer): ");
        String role = sc.nextLine().toLowerCase();

        if (users.containsKey(email)) {
            System.out.println("User already exists!");
            return;
        }

        users.put(email, new User(email, pass, role));
        System.out.println("Signup Successful.");
    }

    static void signIn() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!users.containsKey(email) || !users.get(email).password.equals(pass)) {
            System.out.println("Invalid credentials");
            return;
        }

        currentUser = email;
        if (users.get(email).role.equals("admin")) adminMenu();
        else customerMenu();
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Product\n2. Modify Product\n3. Delete Product\n4. View Products\n5. Search Product");
            System.out.println("6. Add Customer/Admin\n7. Increase Customer Credit\n8. View Reports\n9. Logout");
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> addProduct();
                case 2 -> modifyProduct();
                case 3 -> deleteProduct();
                case 4 -> viewProducts();
                case 5 -> searchProduct();
                case 6 -> signUp();
                case 7 -> increaseCredit();
                case 8 -> viewReports();
                case 9 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void customerMenu() {
        Map<String, Integer> cart = new HashMap<>();
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Products\n2. Add to Cart\n3. Edit Cart\n4. Checkout\n5. View Purchase History\n6. Logout");
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> viewProducts();
                case 2 -> addToCart(cart);
                case 3 -> editCart(cart);
                case 4 -> checkout(cart);
                case 5 -> viewHistory();
                case 6 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // MODULE B: Inventory
    static void addProduct() {
        System.out.print("Product ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        products.put(id, new Product(id, name, price, qty));
        System.out.println("Product added.");
    }

    static void modifyProduct() {
        System.out.print("Product ID to modify: ");
        String id = sc.nextLine();
        if (!products.containsKey(id)) {
            System.out.println("Product not found");
            return;
        }
        Product p = products.get(id);
        System.out.print("New Price: ");
        p.price = Double.parseDouble(sc.nextLine());
        System.out.print("New Quantity: ");
        p.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Updated.");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = sc.nextLine();
        products.remove(id);
        System.out.println("Deleted.");
    }

    static void viewProducts() {
        List<Product> list = new ArrayList<>(products.values());
        System.out.println("1. Sort by Name\n2. Sort by Price\n3. No Sort");
        int sort = Integer.parseInt(sc.nextLine());
        if (sort == 1) list.sort(Comparator.comparing(p -> p.name));
        if (sort == 2) list.sort(Comparator.comparingDouble(p -> p.price));

        for (Product p : list)
            System.out.println(p.id + " | " + p.name + " | ₹" + p.price + " | Qty: " + p.quantity);
    }

    static void searchProduct() {
        System.out.print("Enter product name to search: ");
        String keyword = sc.nextLine().toLowerCase();
        for (Product p : products.values()) {
            if (p.name.toLowerCase().contains(keyword)) {
                System.out.println(p.id + " | " + p.name + " | ₹" + p.price + " | Qty: " + p.quantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    static void increaseCredit() {
        System.out.print("Customer email: ");
        String email = sc.nextLine();
        if (!users.containsKey(email) || !users.get(email).role.equals("customer")) {
            System.out.println("Customer not found");
            return;
        }
        System.out.print("Amount to add: ");
        double amt = Double.parseDouble(sc.nextLine());
        users.get(email).credit += amt;
        System.out.println("Credit updated.");
    }

    // MODULE C: Cart
    static void addToCart(Map<String, Integer> cart) {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        if (!products.containsKey(id)) {
            System.out.println("Invalid product ID");
            return;
        }
        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());
        cart.put(id, cart.getOrDefault(id, 0) + qty);
        System.out.println("Added to cart.");
    }

    static void editCart(Map<String, Integer> cart) {
        System.out.print("Enter Product ID to modify/remove: ");
        String id = sc.nextLine();
        if (!cart.containsKey(id)) {
            System.out.println("Product not in cart");
            return;
        }
        System.out.print("Enter new quantity (0 to remove): ");
        int qty = Integer.parseInt(sc.nextLine());
        if (qty == 0) cart.remove(id);
        else cart.put(id, qty);
        System.out.println("Cart updated.");
    }

    // MODULE D: Payment & Loyalty
    static void checkout(Map<String, Integer> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = 0;
        for (String id : cart.keySet()) {
            Product p = products.get(id);
            int qty = cart.get(id);
            if (qty > p.quantity) {
                System.out.println("Not enough stock for: " + p.name);
                return;
            }
            total += p.price * qty;
        }

        User u = users.get(currentUser);
        double discount = 0;
        if (total >= 5000) {
            discount = 100;
        } else if (u.loyaltyPoints >= 50) {
            discount = 100;
            u.loyaltyPoints -= 50;
        } else {
            u.loyaltyPoints += (int) (total / 100);
        }

        double finalAmount = total - discount;
        if (u.credit < finalAmount) {
            System.out.println("Insufficient credit.");
            return;
        }

        u.credit -= finalAmount;

        // Update product quantities and record sale
        for (String id : cart.keySet()) {
            Product p = products.get(id);
            int qty = cart.get(id);
            p.quantity -= qty;
            p.totalSales += qty;
        }

        String billId = "BILL" + System.currentTimeMillis();
        u.history.add(new Purchase(billId, new HashMap<>(cart), total));
        cart.clear();

        System.out.println("Payment successful. Final Amount: ₹" + finalAmount + ", Discount: ₹" + discount);
    }

    // MODULE E: History
    static void viewHistory() {
        User u = users.get(currentUser);
        for (Purchase p : u.history) {
            System.out.println(p.billId + " | " + p.dateTime + " | Total: ₹" + p.totalAmount);
        }
    }

    // MODULE F: Reports
    static void viewReports() {
        System.out.println("1. Low Stock\n2. Unsold Products\n3. Top Customers");
        int ch = Integer.parseInt(sc.nextLine());

        switch (ch) {
            case 1 -> {
                for (Product p : products.values()) {
                    if (p.quantity < 5)
                        System.out.println(p.id + " | " + p.name + " | Qty: " + p.quantity);
                }
            }
            case 2 -> {
                for (Product p : products.values()) {
                    if (p.totalSales == 0)
                        System.out.println(p.id + " | " + p.name);
                }
            }
            case 3 -> {
                users.values().stream()
                        .filter(u -> u.role.equals("customer"))
                        .sorted((a, b) -> {
                            double sumA = a.history.stream().mapToDouble(p -> p.totalAmount).sum();
                            double sumB = b.history.stream().mapToDouble(p -> p.totalAmount).sum();
                            return Double.compare(sumB, sumA);
                        })
                        .limit(5)
                        .forEach(u -> System.out.println(u.email));
            }
        }
    }
}
