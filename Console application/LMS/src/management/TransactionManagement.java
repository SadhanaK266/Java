package management;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TransactionManagement {
    static Scanner sc=new Scanner(System.in);

    public static void showMenu(){
        boolean valid=true;
        while(valid) {
            System.out.println("=".repeat(8) + "Transaction Management" + "=".repeat(8));
            System.out.println("\n1. View Transaction by user\n2. View Transaction by book\n3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== View Transaction by user ===");
                    viewByUser();
                    break;
                case 2:
                    System.out.println("=== View Transaction By Book ===");
                    viewByBook();
                    break;
                case 3:
                    valid = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    // 1. View transaction by user
    public static void viewByUser(){
        try{
            System.out.print("Enter the User's phone number : ");
            String phoneNumber=sc.nextLine();
            Connection connection= DatabaseConnection.getConnection();
            String query="""
                SELECT t.id,u.user_name,b.title,t.issued_date,t.due_date 
                from Transactions t 
                JOIN Users u on t.user_id=u.id 
                join Books b on t.book_id=b.id 
                where u.phone_number=?""";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,phoneNumber);

            ResultSet rs=ps.executeQuery();
            boolean found=false;
            System.out.println("\nTransactionID | UserName | BookTitle | IssuedDate | DueDate");
            System.out.println("-".repeat(30));

            while(rs.next()){
                found=true;
                System.out.println(rs.getInt("id")+"|"+
                        rs.getString("user_name")+"|"+
                        rs.getString("title")+"|"+
                        rs.getTimestamp("issued_date")+"|"+
                        rs.getTimestamp("due_date")+"|"
                );
            }
            if(!found){
                System.out.println("No transaction available for this user");
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //2. View transaction by book
    public static void viewByBook(){
        try {
            System.out.println("Enter the isbn number");
            String isbn = sc.nextLine();
            Connection connection = DatabaseConnection.getConnection();

            String query = """
                    select t.id,u.user_name,b.title,t.issued_date,t.due_date
                    from Transactions t
                    join Users u ON t.user_id=u.id
                    join Books b on t.book_id=b.id
                    where b.isbn_number=?
                    """;
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,isbn);

            ResultSet rs=ps.executeQuery();
            System.out.println("\nTransactionID | UserName | BookTitle | IssuedDate | DueDate");
            System.out.println("-".repeat(30));

            boolean found=false;
            while (rs.next()){
                found=true;
                System.out.println(rs.getInt("id")+"|"+
                        rs.getString("user_name")+"|"+
                        rs.getString("title")+"|"+
                        rs.getTimestamp("issued_date")+"|"+
                        rs.getTimestamp("due_date"));
            }
            System.out.println("-".repeat(30));
            if(!found){
                System.out.println("No transaction available for this book");
            }
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
