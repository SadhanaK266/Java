package management;

import db.DatabaseConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BooksManagement {
    static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        boolean valid=true;
        while(valid) {
            System.out.println("=".repeat(8) + "Books Management" + "=".repeat(8));
            System.out.println("Choices are\n1. Add book\n2. Remove book\n3. Update Book\n4. View Book\n5. Search Book\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== Add Book ===");
                    addBook();
                    break;
                case 2:
                    System.out.println("=== Remove Book ===");
                    removeBook();
                    break;
                case 3:
                    System.out.println("=== Update Book ===");
                    updateBook();
                    break;
                case 4:
                    System.out.println("=== View Books ===");
                    viewBook();
                    break;
                case 5:
                    System.out.println("=== Search book ===");
                    searchBook();
                    break;
                case 6:
                    System.out.println("Exited...");
                    valid = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
    // 1. Add Book
    public static void addBook(){
        try{
            System.out.print("Enter the title : ");
            String title=sc.nextLine();
            System.out.print("Enter the author's name : ");
            String author=sc.nextLine();
            System.out.print("Enter the isbn number : ");
            String isbnNumber=sc.nextLine();

            Book book=new Book(title,author,isbnNumber);
            Connection connection= DatabaseConnection.getConnection();
            String query="insert into Books(title,author,isbn_number) values(?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,book.getBookTitle());
            ps.setString(2,book.getBookAuthor());
            ps.setString(3,book.getIsbnNumber());

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Book added successfully...");
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 2. Remove book
    public static void removeBook(){
        try{
            System.out.print("Enter the book isbn number : ");
            String bookISBN_number=sc.nextLine();

            Connection connection=DatabaseConnection.getConnection();
            String query="delete from Books where isbn_number=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,bookISBN_number);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Book removed successfully...");
            }
            else{
                System.out.println("Book not found");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 3. Update book
    public static void updateBook(){
        try{
            System.out.print("Enter ISBN number of the book to update : ");
            String isbn=sc.nextLine();

            System.out.print("Enter the new title : ");
            String newTitle=sc.nextLine();
            System.out.print("Enter the new Author name : ");
            String newAuthor=sc.nextLine();
            System.out.print("Enter the new ISBN number : ");
            String newISBN_number=sc.nextLine();

            Connection connection=DatabaseConnection.getConnection();
            String query="Update Books set title=?,author=?,isbn_number=? where isbn_number=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,newTitle);
            ps.setString(2,newAuthor);
            ps.setString(3,newISBN_number);
            ps.setString(4,isbn);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.print("Book updated successfully...");
            }
            else{
                System.out.print("Book not found");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //4. View Book
    public static void viewBook(){
        try{
            Connection connection=DatabaseConnection.getConnection();
            System.out.println("1.View a particular book\n2. View all books");
            int viewOption=sc.nextInt();
            sc.nextLine();
            if(viewOption==1){
                System.out.print("Enter the isbn number of the book : ");
                String isbn=sc.nextLine();

                String query1="Select * from Books where isbn_number=?";
                PreparedStatement prs=connection.prepareStatement(query1);
                prs.setString(1,isbn);
                ResultSet rs1=prs.executeQuery();
                System.out.print("\n S.No.| Title| ID | Author | ISBN_Number ");
                System.out.println("-".repeat(30));
                int count=1;
                while (rs1.next()) {
                    System.out.println(
                            count + "|" +
                                    rs1.getString("title") + "|" +
                                    rs1.getInt("id") + "|" +
                                    rs1.getString("author") + "|" +
                                    rs1.getString("isbn_number")
                    );
                    count++;
                }

            } else if (viewOption==2) {
                String query="SELECT * from Books";
                PreparedStatement ps=connection.prepareStatement(query);
                ResultSet rs=ps.executeQuery();

                System.out.print("\n S.No.| Title| ID | Author | ISBN_Number ");
                System.out.println("-".repeat(30));
                int count=1;
                while (rs.next()) {
                    System.out.println(
                            count + "|" +
                                    rs.getString("title") + "|" +
                                    rs.getInt("id") + "|" +
                                    rs.getString("author") + "|" +
                                    rs.getString("isbn_number")
                    );
                    count++;
                }
            }
            else{
                System.out.println("Invalid choice");
            }

            System.out.println("-".repeat(30));
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //5. Search books
    public static void searchBook(){
        try{
            System.out.print("Enter the Isbn Number : ");
            String isbn=sc.nextLine();

            Connection connection=DatabaseConnection.getConnection();
            String query="select * from Books where isbn_number=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,isbn);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                System.out.println(rs.getInt("id")+"|"+
                        rs.getString("title")+"|"+
                        rs.getString("author")+"|"+
                        rs.getString("isbn_number")
                );
            }else{
                System.out.println("Search not found.");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
