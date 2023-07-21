package AquaSafeFXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.HSSungai;

public class ControllerDaftarSungai {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button ButSungaiBedog;

    @FXML
    private Button ButSungaiCode;

    @FXML
    private Button ButSungaiGajahWong;

    @FXML
    private Button ButSungaiKonteng;

    @FXML
    private Button ButSungaiKuning;

    @FXML
    private Button ButSungaiOyo;

    @FXML
    private Button ButSungaiTambakbayan;

    @FXML
    private Button ButSungaiWinongo;

    @FXML
    private Button butDashboard;

    @FXML
    private Button butKeluar;

     @FXML
    private BorderPane inputHasil;

    @FXML
    private Label alamatSungaiLabel;

    @FXML
    private Label namaPenelitiLabel;

    @FXML
    private Label namaSungaiLabel;

    @FXML
    private Label tanggalPenelitiLabel;

    @FXML
    private TableView<HSSungai> tableView;

    @FXML
    private TableColumn<HSSungai, Double> bodKolom;
    
    @FXML
    private TableColumn<HSSungai, Double> codKolom;
    
    @FXML
    private TableColumn<HSSungai, Double> doKolom;
    
    @FXML
    private TableColumn<HSSungai, Double> pHKolom;
    
    @FXML
    private TableColumn<HSSungai, Double> tssKolom;

    @FXML
    private TableColumn<HSSungai, String>tanggalPenelitianKolom;
    

    private Pane pane;

    @FXML
    public void sungaiWinongo(ActionEvent event) throws IOException {
        outputTable("Sungai Winongo");
    }
    
    @FXML
    public void sungaiCode(ActionEvent event) throws IOException{
        outputTable("Sungai Code");
    }

    @FXML
    public void sungaiGajahwong(ActionEvent event) throws IOException{
        outputTable("Sungai Gajahwong");
    }

    @FXML
    public void sungaiBedog(ActionEvent event) throws IOException{
        outputTable("Sungai Bedog");
    }

    @FXML
    public void sungaiKonteng(ActionEvent event) throws IOException{
        outputTable("Sungai Konteng");
    }

    @FXML
    public void sungaiKuning(ActionEvent event) throws IOException{
        outputTable("Sungai Kuning");
    }

    @FXML
    public void sungaiOyo(ActionEvent event) throws IOException{
        outputTable("Sungai Oyo");
    }

    @FXML
    public void sungaiTambakbayan(ActionEvent event) throws IOException{
        outputTable("Sungai Tambakbayan");
    }


    private ArrayList<HSSungai> getDataFromXml() {
        XStream xStream = new XStream(new DomDriver());
        xStream.addPermission(AnyTypePermission.ANY);
        ArrayList<HSSungai> listOfSungai = new ArrayList<>();
    
        try {
            File file = new File("sungai.xml");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            String xml = new String(data, StandardCharsets.UTF_8);
            listOfSungai = (ArrayList<HSSungai>) xStream.fromXML(xml);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    
        return listOfSungai;
    }

    
    public Pane getPane(String filename){
        try {
            URL file = getClass().getResource(filename);
            if (file == null){
            throw new java.io.FileNotFoundException("tifak");
            }
            pane = FXMLLoader.load(file);
        } catch (Exception e) {
            System.out.println();
            // TODO: handle exception
        }
        return pane;
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

    public void outputTable(String s) throws IOException {
        inputHasil.setCenter(getPane("Table.fxml"));
        String namaSungaiS = s;
        ArrayList<HSSungai> sungaiList = getDataFromXml();
    
        
        sungaiList.sort(Comparator.comparing(HSSungai::getTanggalPenelitian).reversed());
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Table.fxml"));
        pane = loader.load();
        tableView = (TableView<HSSungai>) pane.lookup("#tableView"); 
    
        
        bodKolom = (TableColumn<HSSungai, Double>) tableView.getColumns().get(2);
        codKolom = (TableColumn<HSSungai, Double>) tableView.getColumns().get(3);
        doKolom = (TableColumn<HSSungai, Double>) tableView.getColumns().get(1);
        pHKolom = (TableColumn<HSSungai, Double>) tableView.getColumns().get(0);
        tssKolom = (TableColumn<HSSungai, Double>) tableView.getColumns().get(4);
        tanggalPenelitianKolom = (TableColumn<HSSungai, String>) tableView.getColumns().get(5); 
    
        bodKolom.setCellValueFactory(new PropertyValueFactory<>("BOD"));
        codKolom.setCellValueFactory(new PropertyValueFactory<>("COD"));
        doKolom.setCellValueFactory(new PropertyValueFactory<>("Do"));
        pHKolom.setCellValueFactory(new PropertyValueFactory<>("PH"));
        tssKolom.setCellValueFactory(new PropertyValueFactory<>("TSS"));
        tanggalPenelitianKolom.setCellValueFactory(new PropertyValueFactory<>("tanggalPenelitian"));
    
        ArrayList<HSSungai> matchedSungaiList = sungaiList.stream()
                .filter(sungai -> sungai.getNamaSungai().equals(namaSungaiS))
                .collect(Collectors.toCollection(ArrayList::new));
    
       
        tableView.getItems().addAll(matchedSungaiList);
    
       
        namaSungaiLabel = (Label) pane.lookup("#namaSungaiLabel");
        alamatSungaiLabel = (Label) pane.lookup("#alamatSungaiLabel");
        namaPenelitiLabel = (Label) pane.lookup("#namaPenelitiLabel");
        tanggalPenelitiLabel = (Label) pane.lookup("#tanggalPenelitiLabel");
    
        if (!matchedSungaiList.isEmpty()) {
            HSSungai latestSungai = matchedSungaiList.get(0); 
            namaSungaiLabel.setText(latestSungai.getNamaSungai());
            alamatSungaiLabel.setText(latestSungai.getAlamatSungai());
            namaPenelitiLabel.setText(latestSungai.getNamaPeneliti());
            tanggalPenelitiLabel.setText(latestSungai.getTanggalPenelitian());
        }
    
        inputHasil.setCenter(pane);
    }
    
}


