package AquaSafeFXML;
import model.HSSungai;
import model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerUnggahHasil {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button butDashboard;

    @FXML
    private Button butHasilPengamatan;

    @FXML
    private Button butUnggahHasil;

    @FXML
    private Button butProfile;

    @FXML
    private Button butKeluar;

    @FXML
    private TextField tFBOD;

    @FXML
    private TextField tFCOD;

    @FXML
    private TextField tFDO;

    @FXML
    private TextField tFTSS;

    @FXML
    private TextField tFalamatSungai;

    @FXML
    private TextField tFnamaPenelitian;

    @FXML
    private TextField tFpH;

    @FXML
    private DatePicker tanggalPenelitianPicker;

    @FXML
    private ChoiceBox<String> listSungai;

    @FXML
    private Button unggah;

    @FXML
    public void initialize() {
        ObservableList<String> sungaiList = FXCollections.observableArrayList(
            "Sungai Winongo", "Sungai Code", "Sungai Gajahwong"); // Replace with your sungai data

        listSungai.setItems(sungaiList);
    }

    @FXML
    public void ToUnggahHasil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UnggahHasil.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ToDashboard(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeDLH.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ToHasilPengamatan(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HasilPengamatanDLH.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ToProfile(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileDLH.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void keluar(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AquaSafe.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Unggah(ActionEvent event) {
        String namaSungai = listSungai.getValue();
        String alamatSungai = tFalamatSungai.getText();
        String namaPenelitian = tFnamaPenelitian.getText();
        String tanggalPenelitian = tanggalPenelitianPicker.getValue().toString();
        double pH = Double.parseDouble(tFpH.getText());
        double Do = Double.parseDouble(tFDO.getText());
        double BOD = Double.parseDouble(tFBOD.getText());
        double TSS = Double.parseDouble(tFTSS.getText());
        double COD = Double.parseDouble(tFCOD.getText());


        XStream xStream = new XStream(new DomDriver());
        xStream.addPermission(AnyTypePermission.ANY);
        ArrayList<HSSungai> listOfSungai = new ArrayList<>();// kita inisialisasi dulu arraylist kosong buat nanti diisi pas ngambil dari xml

        HSSungai sungai = new HSSungai(namaSungai, alamatSungai, namaPenelitian, tanggalPenelitian, pH, Do, BOD, TSS, COD);

        String xml = "";
        boolean isFileExist = true;//flag buat ngecek file nya udah ada belum
        try {
            File file = new File("sungai.xml");//ngambil file person xml
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            xml = new String(data, StandardCharsets.UTF_8);
            listOfSungai = (ArrayList<HSSungai>) xStream.fromXML(xml);
            } catch (FileNotFoundException err) {// eksekusi kalo file person.xml ga ketemu
            System.out.println("file not found");
            isFileExist = false;//flag kita set ke false menandakan kalau file nya ga ketemu, biasanya pas awal run program kan gaada filenya atau file nya kehapus
            listOfSungai.add(sungai);//nambahin data ke arraylist dari inputan di textfield
            saveToXml(listOfSungai);//datanya kita save ke xml
            } catch (IOException e) {
            System.out.println(e.getMessage());
            }
             if(isFileExist) {// kalo file nya ada kita tambahkan user ke arraylist trus kita save ke xml, kita cek pake flag biar ga dieksekusi dua kali saat file nya ga ketemu (FileNotFoundExecption)
            listOfSungai.add(sungai);
            saveToXml(listOfSungai);
            }
            }
            private void saveToXml(ArrayList<HSSungai> listOfSungai) {
                    XStream xStream = new XStream(new StaxDriver());
                    String xml = xStream.toXML(listOfSungai);

                    try {
                    FileWriter fileWriter = new FileWriter("sungai.xml");
                    fileWriter.write(xml);
                    fileWriter.close();
                    System.out.println("Arraylist saved to xml successfully");
                    } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}