package AquaSafeFXML;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;
import javafx.scene.Node;

public class ControllerProfileDLH  {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label lblNama;

    @FXML
    private Label lblKA;

    @FXML
    private Label lblTL;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPass;

    @FXML
    private Button butToKembali;


    public void setUserData(User user) {
        UserDataHolder.getInstance().setUser(user);
        updateLabels();
    }

    private void updateLabels() {
        User userData = UserDataHolder.getInstance().getUser();
        if (userData != null) {
            lblNama.setText(userData.getFullname());
            lblKA.setText(userData.getKartuanggota());
            lblTL.setText(userData.getTanggalLahir());
            lblEmail.setText(userData.getEmail());
            lblPass.setText(userData.getPassword());
        } else {
            lblNama.setText("");
            lblKA.setText("");
            lblTL.setText("");
            lblEmail.setText("");
            lblPass.setText("");
        }
    }

    @FXML
    public void ToKembali(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeDLH.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 
}

