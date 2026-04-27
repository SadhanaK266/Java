package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String url="jdbc:mysql://localhost:3306/lsm_db";
    private static final String userName="root";
    private static final String password="admin123";

//    Creates connection
    public static Connection getConnection(){
         Connection connection=null;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection= DriverManager.getConnection(url,userName,password);
//             System.out.println("DataBase connected Successfully!...");
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return connection;
    }

//    To close connection
    public static void closeConnection(Connection connection){
        if(connection!=null){
            try{
                connection.close();
                System.out.println("DataBase Closed successfully");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
