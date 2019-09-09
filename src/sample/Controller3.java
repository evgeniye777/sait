package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane window;

    @FXML
    private TextField name;

    @FXML
    private TextField firstname;

    @FXML
    private TextField Pas;

    @FXML
    private TextField log;

    @FXML
    private TextField Conf;

    @FXML
    private CheckBox Checman;

    @FXML
    private CheckBox ChecWoman;

    @FXML
    private Label metka1;
    @FXML
    private Button butreq;

    @FXML
    void initialize() {
        butreq.setOnAction(event -> {
            DataBaseHandler db = new DataBaseHandler();
            String gender;
            if (Checman.isSelected()) {gender = "Мужской";}
            else {gender = "Женский";}
            User user = new User(name.getText(),firstname.getText(),log.getText()
                    ,Pas.getText(),Conf.getText(),gender);
            db.signUpuser(user);
        });

    }
}
