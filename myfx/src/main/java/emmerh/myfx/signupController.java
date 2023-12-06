package emmerh.myfx;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class signupController implements Initializable {

    private HelloApplication mainApp;
    @FXML
    private TextField nametxt;

    @FXML
    private TextField emailtxt;

    @FXML
    private PasswordField passwordtxt;
    @FXML
    private Button submit;

    @FXML
    private Button signin;



    @Override
    public void initialize(URL location, ResourceBundle resource){

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!nametxt.getText().trim().isEmpty() || !emailtxt.getText().trim().isEmpty() || !passwordtxt.getText().trim().isEmpty()) {
                    DBUtils.signupUser(nametxt.getText(), emailtxt.getText(), passwordtxt.getText());
                    nametxt.setText("");
                    emailtxt.setText("");
                    passwordtxt.setText("");
                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information");
                    alert.show();
                }
            }
        });
//        public void setMainApp(HelloApplication mainApp) {
//            this.mainApp = mainApp;

        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelloApplication.showLoginScene();
            }
        });
    }
}




