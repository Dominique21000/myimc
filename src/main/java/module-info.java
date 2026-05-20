module fr.dominiquesauvignon.myimc {
	requires javafx.controls;
	requires javafx.fxml;

	// Ouvre les packages pour la réflexion FXML
    opens fr.dominiquesauvignon.myimc to javafx.fxml;
    opens fr.dominiquesauvignon.myimc.controller to javafx.fxml;

    // Exporte le package principal pour qu'il soit accessible par d'autres modules si nécessaire
    // (Utiles pour les tests ou une future architecture multi-modules)
    exports fr.dominiquesauvignon.myimc;
    
    // Si vous avez des interfaces ou classes publiques dans le package controller à exporter :
    // exports fr.dominiquesauvignon.myimc.controller; 
}