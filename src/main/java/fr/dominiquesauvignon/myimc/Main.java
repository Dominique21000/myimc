package fr.dominiquesauvignon.myimc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Main extends Application 
{
	@Override
    public void start(Stage primaryStage) throws IOException {
        // Chargement du fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imc-view.fxml"));
        
        VBox root = loader.load();

        Scene scene = new Scene(root, 400, 350);
        
        // Chargement du CSS
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("Calculateur IMC - by Dominique SAUVIGNON");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
