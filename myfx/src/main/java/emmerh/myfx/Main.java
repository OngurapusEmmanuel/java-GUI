package emmerh.myfx;


import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static Connection getConnection(){

        try{
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/javafx";
            String username="root";
            String password="";


            Class.forName(driver);

            Connection conn= DriverManager.getConnection(url,username,password);

     if (conn ==null){
         System.out.println("not connected");
     }else {
         System.out.println("connected successfully");
     }


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        getConnection();
    }
}
