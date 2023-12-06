package emmerh.myfx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;
    @FXML
    private Label welcomeText;

    @FXML

    public void initialize(URL location, ResourceBundle resource){

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!username.getText().trim().isEmpty()|| !password.getText().trim().isEmpty()) {
                    try {
                        DBUtils.loginUser(username.getText(), password.getText());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    username.setText("");
                    password.setText("");
                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information");
                    alert.show();
                }
            }

        });

    }


}
