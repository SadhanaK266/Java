package management;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ActionManagement {
    static Scanner sc=new Scanner(System.in);

    public static void showMenu(){
        boolean valid=true;
        while(valid) {
            System.out.println("=".repeat(8) + "Action Dashboard" + "=".repeat(8));
            System.out.println("Choices are\n1. Issue book\n2. Return book\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("=== Issue Book ===");
                    issueBook();
                    break;
                case 2:
                    System.out.println("=== Return Book ====");
                    returnBook();
                    break;
                case 3:
                    valid=false;
                    System.out.println("Exited...");
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
    // 1. Issue book
    public static  void issueBook(){
        try{
            Connection connection= DatabaseConnection.getConnection();
            System.out.print("Enter the user's phone number : ");
            String phoneNumber=sc.nextLine();
            String query1="select id from Users where phone_number=?";
            PreparedStatement ps1=connection.prepareStatement(query1);
            ps1.setString(1,phoneNumber);
            ResultSet rs1=ps1.executeQuery();
            int userID=0;
            if(rs1.next()){
                userID=rs1.getInt("id");
            }

            System.out.print("Enter the book quantity : ");
            int quantity=sc.nextInt();
            sc.nextLine();

            for(int i=0;i<quantity;i++){
                System.out.print("Enter the book "+(i+1)+" isbn number :");
                String isbn=sc.nextLine();
                String query2="select id from Books where isbn_number=?";
                PreparedStatement ps2=connection.prepareStatement(query2);
                ps2.setString(1,isbn);
                ResultSet rs2=ps2.executeQuery();
                int bookID=0;
                if(rs2.next()){
                    bookID=rs2.getInt("id");
                }

                String querySetting="insert into Transactions(book_id,user_id) values(?,?)";
                PreparedStatement ps3=connection.prepareStatement(querySetting);
                ps3.setInt(1,bookID);
                ps3.setInt(2,userID);

                int rowsAffect=ps3.executeUpdate();
                if(rowsAffect>0){
                    System.out.println("Record"+(i+1)+" is added.");
                }
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 2. Return book
    public static void returnBook(){
        try{
            Connection connection=DatabaseConnection.getConnection();
            System.out.print("Enter the phone number : ");
            String phoneNumber=sc.nextLine();
            String query1="""
                select b.title,b.author,b.isbn_number,  t.issued_date,t.due_date
                from Transactions t
                join Users u on t.user_id=u.id
                join Books b on t.book_id=b.id
                where u.phone_number=?
            """;
            PreparedStatement ps1=connection.prepareStatement(query1);
            ps1.setString(1,phoneNumber);
            ResultSet rs1=ps1.executeQuery();
            System.out.println("Title | Author | ISBN Number | Issued on | Due date");
            while (rs1.next()){
                System.out.println(rs1.getString("title")+"|"+
                        rs1.getString("author")+"|"+
                        rs1.getString("isbn_number")+"|"+
                        rs1.getTimestamp("issued_date")+"|"+
                        rs1.getTimestamp("due_date")
                );
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
