/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package AquaSafeController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AquaSafeController extends Application {
// Anggota Kelompok ByteBandits
// 1. Muhammad Sulthon (22523133)
// 2. Muhammad Daffa Ramadhan (22523024)
// 3. Ryan Pradipta Wicaksono (22523107)
// 4. Habib Al Hafiizh Ramadhan (22523290)
// 5. Mohammad Farid Anshori (22523124)


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/AquaSafeFXML/AquaSafe.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
