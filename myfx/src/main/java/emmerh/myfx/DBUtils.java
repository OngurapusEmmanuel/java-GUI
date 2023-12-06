package emmerh.myfx;

import java.sql.*;

import javafx.scene.control.Alert;

 public class DBUtils {
    public static void signupUser(String name,String email,String password){
        Connection connection=null;
        PreparedStatement ps=null;
        PreparedStatement checkUser=null;
        ResultSet rs=null;
        String dburl="jdbc:mysql://localhost:3306/javafx";
        String username="root";
        String dbpassword="";
        try {
//            try {
////                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
            connection=DriverManager.getConnection(dburl,username,dbpassword);

            checkUser=connection.prepareStatement("SELECT * FROM user WHERE name=?");
            checkUser.setString(1,name);
            rs=checkUser.executeQuery();

            if (rs.isBeforeFirst()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User with the name already exists!!");
                alert.show();
            }else {
                ps= connection.prepareStatement("INSERT INTO user(name,email,password) VALUES(?,?,?)");
                ps.setString(1,name);
                ps.setString(2,email);
                ps.setString(3,password);
                ps.executeUpdate();

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("User "+name+" created successfully!");
                alert.show();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (rs !=null)
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            if (ps !=null)
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            if(checkUser !=null)
                try {
                    checkUser.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (connection !=null)
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
        }

    }

    public static void loginUser(String name, String password) throws ClassNotFoundException {
//        String driver = "com.mysql.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/javafx";
        String username = "root";
        String dbpassword = "";
        ResultSet rs= null;
        PreparedStatement ps= null;
        Connection connection= null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dburl, username, dbpassword);
            ps = connection.prepareStatement("SELECT password FROM user WHERE name=?");
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User with the credentials not found!!");
                alert.show();
            } else {
                while (rs.next()) {
                    String retrievedPassword = rs.getString("password");
                    if (retrievedPassword.equals(password)) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText( name+" logged in successfully");
                        alert.show();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password did not match!!");
                        alert.show();
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps !=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection !=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}

