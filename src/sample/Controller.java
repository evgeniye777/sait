package sample;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane window;

    @FXML
    private TextField pole;
    @FXML
    private TextField pole2;

    @FXML
    private Label metka2;

    @FXML
    private Label metka1;

    @FXML
    private Button but;
    @FXML
    private Button buts;

    @FXML
    void initialize() {
        buts.setOnAction(event -> {
            String loginT = pole.getText().trim();
            String passT = pole2.getText().trim();
            if (!loginT.equals("")&&!passT.equals("")) {loginUser(loginT,passT);}
        });
but.setOnAction(event -> {
    but.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample3.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    );

    }

    private void loginUser(String loginT, String passT) {
    }
}
