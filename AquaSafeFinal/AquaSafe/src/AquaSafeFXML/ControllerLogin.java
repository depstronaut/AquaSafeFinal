package AquaSafeFXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.awt.Desktop;
import javafx.scene.Node;

public class ControllerLogin {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginButton;

    @FXML
    private Button butToDaftar;

    @FXML
    private Button butToKembali;

    @FXML
    private Button butToGoogle;

    @FXML
    private TextField tFemail;

    @FXML
    private PasswordField tFpassword;

    @FXML
    public void ToDaftar(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ToKembali(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AquaSafe.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginGoogle(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://accounts.google.com/signin/v2/identifier?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2F%3Futm_source%3Dsign_in_no_continue%26pli%3D1&ec=GAlAwAE&flowName=GlifWebSignIn&flowEntry=AddSession"));
    }


    @FXML
    public void login(ActionEvent event) {
    String email = tFemail.getText();
    String password = tFpassword.getText();

    XStream xStream = new XStream(new DomDriver());
    xStream.addPermission(AnyTypePermission.ANY);
    ArrayList<User> listOfUser = new ArrayList<>();

    try {
        File file = new File("person.xml");
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            String xml = new String(data, StandardCharsets.UTF_8);
            listOfUser = (ArrayList<User>) xStream.fromXML(xml);

            for (User user : listOfUser) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeDLH.fxml"));
                    Parent root = loader.load();
                    ControllerHomeDLH home = loader.getController();

                
                    home.setUserData(user);


                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                    System.out.println("Login successful");
                    return;
                }
            }
            
            System.out.println("Invalid email or password");
        } else {
            System.out.println("No user data found");
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}

}
