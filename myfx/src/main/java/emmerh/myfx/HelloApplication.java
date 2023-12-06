package emmerh.myfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 515);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showLoginScene() {
        try {
            Stage stage=new Stage();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 510);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
//            start.fxmlLoader("loginController");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//   public static void showLoginScene() {
//        try {
//            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
//            Parent loginRoot = loader.load();
//
//            // Replace the content of the existing scene with the login page content
//            stage.getScene().setRoot(loginRoot);
//
//            // Optional: You can set the title and other properties for the login scene
//            stage.setTitle("Login");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        launch();
    }
}