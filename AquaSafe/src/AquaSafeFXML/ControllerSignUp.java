// package AquaSafeFXML;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import com.thoughtworks.xstream.XStream;
// import com.thoughtworks.xstream.io.xml.StandardStaxDriver;
// import com.thoughtworks.xstream.io.xml.StaxDriver;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;
// import model.User;
// import javafx.scene.Node;

// public class ControllerSignUp {
//     private Stage stage;
//     private Scene scene;
//     private Parent root;

//     @FXML
//     private TextField tf1;

//     @FXML
//     private TextField tf2;

//     @FXML
//     private TextField tf3;

//     @FXML
//     private TextField tf4;

//     @FXML
//     private TextField tf5;

//     @FXML
//     private TextField tf6;

//     @FXML
//     private Button butToKembali;

//     @FXML
//     private Button butToLogin;

//     @FXML
//     private Button butToRegister;


    
//     @FXML
//     public void ToKembali(ActionEvent event) throws IOException{
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("AquaSafe.fxml"));
//         root = loader.load();
//         stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();
//     }

//     @FXML
//     public void ToLogin(ActionEvent event) throws IOException{
//         FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
//         root = loader.load();
//         stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();
//     }

//     @FXML
//     public void ToRegister(ActionEvent event) throws IOException{
//         String fullname = tf1.getText();
//         String kartuanggota = tf2.getText();
//         String tanggalLahir = tf3.getText();
//         String email = tf4.getText();
//         String pass = tf5.getText();

//         User userRegister = new User(fullname, email, kartuanggota, pass, tanggalLahir);
        
//         XStream xstream = new XStream(new StaxDriver());


//         FileInputStream f = null;
    
//         try {
//             f = new FileInputStream("person.xml");
//             int isi;
//             char c;
//             String sxml="";

//             while ((isi=f.read()) != -1) {
//                 c = (char) isi;
//                 sxml = sxml+c;
//             }

//             ArrayList<User> userListLama = (ArrayList<User>)xstream.fromXML(sxml);
//             userListLama.add(userRegister);
//             String s = xstream.toXML(userListLama);

//             FileOutputStream h = null;

//             try {
//                h = new FileOutputStream("person.xml");

//             byte[]bytes = sxml.getBytes("UTF-8");
//             h.write(bytes);

//             } catch (Exception e) {
//                 // TODO: handle exception
//             }
//         } catch (Exception e) {
//             // TODO: handle exception
//         }

        
    

       
        


//     }


// }

package AquaSafeFXML;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.TypePermission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import model.User;

public class ControllerSignUp {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button butToKembali;

    @FXML
    private Button butRegister;

    @FXML
    private Button butToLogin;

    @FXML
    private TextField tFfullName;

    @FXML
    private TextField tFemail;

    @FXML
    private TextField tFkartuAnggota;

    @FXML
    private TextField tFpassword;

    @FXML
    private TextField tFtglLahir;

    @FXML
    private TextField tfPasswordConfirm;

    @FXML
    public void ToKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AquaSafe.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void register(ActionEvent event) {
        String fullName = tFfullName.getText();
        String email = tFemail.getText();
        String kartuAnggota = tFkartuAnggota.getText();
        String password = tFpassword.getText();
        String tglLahir = tFtglLahir.getText();
        String passwordConfirmation = tfPasswordConfirm.getText();

        XStream xStream = new XStream(new DomDriver());
        xStream.addPermission(AnyTypePermission.ANY);
        ArrayList<User> listOfUser = new ArrayList<>();// kita inisialisasi dulu arraylist kosong buat nanti diisi pas ngambil dari xml

        User user = new User(fullName, email, kartuAnggota, password, tglLahir);
// ...
        //
        String xml = "";
        boolean isFileExist = true;//flag buat ngecek file nya udah ada belum
        try {
            File file = new File("person.xml");//ngambil file person xml
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            xml = new String(data, StandardCharsets.UTF_8);
            listOfUser = (ArrayList<User>) xStream.fromXML(xml);
        } catch (FileNotFoundException err) {// eksekusi kalo file person.xml ga ketemu
            System.out.println("file not found");
            isFileExist = false;//flag kita set ke false menandakan kalau file nya ga ketemu, biasanya pas awal run program kan gaada filenya atau file nya kehapus
            listOfUser.add(user);//nambahin data ke arraylist dari inputan di textfield
            saveToXml(listOfUser);//datanya kita save ke xml
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if(isFileExist) {// kalo file nya ada kita tambahkan user ke arraylist trus kita save ke xml, kita cek pake flag biar ga dieksekusi dua kali saat file nya ga ketemu (FileNotFoundExecption)
            listOfUser.add(user);
            saveToXml(listOfUser);
        }
    }

    //fungsi buat ngesave arraylist ke xml
    private void saveToXml(ArrayList<User> listOfUser) {
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(listOfUser);

        try {
            FileWriter fileWriter = new FileWriter("person.xml");
            fileWriter.write(xml);
            fileWriter.close();
            System.out.println("Arraylist saved to xml successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}