import management.ActionManagement;
import management.BooksManagement;
import management.TransactionManagement;
import management.UserManagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("=".repeat(26)+" Welcome to Library management system "+"=".repeat(26));
        boolean valid=true;
        while(valid){
            System.out.println("1. User management\n2. Books management\n3. Transaction management\n4. Action\n5. Exit\nEnter your choice : ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("User management Dashboard");
                    UserManagement.showMenu();
                    break;
                case 2:
                    System.out.println("Books management dashboard");
                    BooksManagement.showMenu();
                    break;
                case 3:
                    System.out.println("Transaction management dashboard");
                    TransactionManagement.showMenu();
                    break;
                case 4:
                    System.out.println("Action Dashboard");
                    ActionManagement.showMenu();
                    break;
                case 5:
                    valid=false;
                    System.out.println("Exited....");
                    break;
                default:
                    System.out.println("Invalid choice. Kindly enter the choice from 1 to 5.");
            }
        }
    }
}