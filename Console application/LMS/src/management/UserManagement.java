package management;

import db.DatabaseConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserManagement {
    static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        boolean looping=true;
        while(looping){
        System.out.println("=".repeat(8)+"User Management"+"=".repeat(8));
        System.out.println("Choices are\n1. Add User\n2. Remove User\n3. Update User\n4. View User\n5. Search User\n6. Exit");

        int choice=sc.nextInt();
        sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("=== Add User ===");
                    addUser();
                    break;
                case 2:
                    System.out.println("=== Remove User ===");
                    removeUser();
                    break;
                case 3:
                    System.out.println("=== Update User ===");
                    updateUser();
                    break;
                case 4:
                    System.out.println("=== View User ===");
                    viewUser();
                    break;
                case 5:
                    System.out.println("=== Search User ===");
                    searchUser();
                    break;
                case 6:
                    System.out.println("Exited...");
                    looping=false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }

    }

    // 1. Add user
    public static void addUser(){
        try{
            System.out.print("Enter your name : ");
            String name=sc.nextLine();
            System.out.print("Enter your Phone number : ");
            String phoneNumber=sc.nextLine();

            User user=new User(name,phoneNumber,null);
            Connection connection= DatabaseConnection.getConnection();
            String query="insert into Users(user_name,phone_number) values(?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,phoneNumber);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("User added successfully...");
            }
            else{
                System.out.println("Invalid data(s)");
            }
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    // 2. Remove user
    public static void removeUser() {
        try {
            System.out.print("Enter user's phone number to delete : ");
            String phoneNumber = sc.nextLine();

            Connection connection = DatabaseConnection.getConnection();
            String query = "delete from Users1 where phone_number=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, phoneNumber);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("User deleted successfully...");
            }
            else{
                System.out.println("User not found");
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    // 3. Update user
    public static void updateUser(){
        try {
            Connection connection= DatabaseConnection.getConnection();

            System.out.print("Enter the phone number of an user : ");
            String phoneNumber=sc.nextLine();
            String Query="select * from Users where phone_number=?";
            PreparedStatement prs=connection.prepareStatement(Query);
            prs.setString(1,phoneNumber);
            ResultSet rs=prs.executeQuery();
            while (rs.next()){
                System.out.println("User ="+rs.getString("user_name")+
                        "Phone Number = "+rs.getString("phone_number")+
                        "Date and Time = "+rs.getTimestamp("date_time")
                );
            }

            System.out.print("Enter the new name : ");
            String name=sc.nextLine();
            System.out.print("Enter the new Phone number : ");
            String newPhoneNumber=sc.nextLine();

            String query="Update Users set user_name=?,phone_number=? where phone_number=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,newPhoneNumber);
            ps.setString(3,phoneNumber);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("User updated successfully...");
            }
            else{
                System.out.println("User not found");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 4. View User
    public static void viewUser(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("1. View particular user\n2. View all users");
            int viewOption=sc.nextInt();
            sc.nextLine();
            if(viewOption==1) {
                System.out.print("Enter your phone number : ");
                String phoneNumber=sc.nextLine();
                String query1 = "select * from Users where phone_number=?";
                PreparedStatement prs = connection.prepareStatement(query1);
                prs.setString(1,phoneNumber);
                ResultSet rs1=prs.executeQuery();
                System.out.println("\nID|Name|Phone|Created At");
                while (rs1.next()) {
                    System.out.println(rs1.getInt("id")+"|"+
                            rs1.getString("user_name")+"|"+
                            rs1.getString("phone_number")+"|"+
                            rs1.getString("date_time")
                    );
                }
            }
            else if (viewOption==2) {
                String query2 = "select * from Users";
                PreparedStatement ps = connection.prepareStatement(query2);
                ResultSet rs = ps.executeQuery();
                System.out.println("\nS.No |Name |ID |Phone Number |Created At ");
                System.out.println("-".repeat(30));
                int count=1;
                while (rs.next()) {
                    System.out.println(count+"|"+
                            rs.getString("user_name")+"|"+
                            rs.getInt("id")+"|"+
                            rs.getString("phone_number")+"|"+
                            rs.getString("date_time")
                    );
                    count++;
                }
            }
            else{
                System.out.println("Invalid input");
            }
            System.out.println("-".repeat(30));
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //5 .Search User
    public static void searchUser() {
        try {
            System.out.println("Enter user's Phone number :");
            String phoneNumber=sc.nextLine();

            Connection connection=DatabaseConnection.getConnection();
            String query="select * from Users where phone_number=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,phoneNumber);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("\nUser found");
                System.out.println(rs.getInt("id")+"|"+
                        rs.getString("user_name")+"|"+
                        rs.getString("phone_number")+"|"+
                        rs.getString("date_time")
                );
            }
            else{
                System.out.println("User not found");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
