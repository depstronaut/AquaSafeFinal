package AquaSafeFXML;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.awt.Desktop;



public class ControllerHome {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button butTopH;

    @FXML
    private Button butToDO;

    @FXML
    private Button butToBOD;

    @FXML
    private Button butToCOD;

    @FXML
    private Button butToTSS;

    @FXML
    private Button butToBerita1;

    @FXML
    private Button butToBerita2;

    @FXML
    private Button butToBerita3;

    @FXML
    private Button butToBerita4;

    @FXML
    private Button butHasilPengamatan;

    @FXML
    private Button butDashboard;

    @FXML
    private Button butKeluar;

    @FXML
    private Button butEdukasi1;

    @FXML
    private Button butEdukasi2;


    @FXML
    void topH(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://id.wikipedia.org/wiki/PH"));
    }

    @FXML
    void toDO(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://id.wikipedia.org/wiki/Oksigen_terlarut"));
    }

    @FXML
    void toBOD(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://bpusdataru-bk.jatengprov.go.id/index.php/informasi-sda/kualitas-air/93-das/kualitas-air/156-bod#:~:text=BOD%20adalah%20suatu%20pengukuran%20pendekatan,mengoksidasi%20menjadi%20bahan%20an%20organic."));
    }

    @FXML
    void toCOD(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://bpusdataru-bk.jatengprov.go.id/index.php/informasi-sda/kualitas-air/93-das/kualitas-air/155-cod-chemical-oxygen-demand#:~:text=Chemical%20Oxygen%20Demand%20adalah%20pengukuran,yang%20kuat%20seperti%20misal%20bichromat."));
    }

    @FXML
    void toTSS(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://waterpedia.co.id/analisis-tss/"));
    }

    @FXML
    void toBerita1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://warta.jogjakota.go.id/detail/index/23777"));
    }

    @FXML
    void toBerita2(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://rejogja.republika.co.id/berita/rudux2291/dlh-sebut-solusi-atasi-pencemaran-air-sumur-dan-sungai-di-yogyakarta"));
    }

    @FXML
    void toBerita3(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://jogjapolitan.harianjogja.com/read/2022/10/14/510/1114516/dlh-nilai-semua-sungai-di-jogja-tercemar-ini-jenis-pencemarannya"));
    }

    @FXML
    void toBerita4(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://jogja.solopos.com/ini-sungai-di-jogja-yang-tercemar-paling-parah-airnya-mengandung-zat-berbahaya-1612542"));
    }

    @FXML
    void toEdukasi2(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.gramedia.com/literasi/penyebab-pencemaran-air/"));
    }

    @FXML
    void toEdukasi1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.cleanipedia.com/id/cara-mengatasi-pencemaran-air.html"));
    }

    @FXML
    public void hasilpengamatan(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DaftarSungai.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void dashboard(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
}

