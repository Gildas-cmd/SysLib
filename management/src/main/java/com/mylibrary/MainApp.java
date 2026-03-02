package com.mylibrary;



import com.database.DatabaseLib;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DatabaseLib.init(); // Création de la table au démarrage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Library Manager Pro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) { launch(args); }
}