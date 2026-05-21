module fr.dominiquesauvignon.myimc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens fr.dominiquesauvignon.myimc to javafx.fxml, javafx.graphics;
    opens fr.dominiquesauvignon.myimc.controller to javafx.fxml;
}