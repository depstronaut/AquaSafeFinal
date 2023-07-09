/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AquaSafeController;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class OpenScene {
    private Pane halaman;
    
    public Pane getPane (String namaFile) {
        try{
            URL fileHalaman = AquaSafeController.class.getResource("/AquaSafeFXML/"+namaFile+".fxml");
            
            if (fileHalaman==null){
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            halaman = FXMLLoader.load(fileHalaman);
        } catch (Exception e){
            System.out.println("Terjadi error di dashboard");
        }
        return halaman;
    }
    
}
