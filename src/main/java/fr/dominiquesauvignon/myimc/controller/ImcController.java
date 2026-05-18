package fr.dominiquesauvignon.myimc.controller;

import fr.dominiquesauvignon.myimc.model.ImcResult;
import fr.dominiquesauvignon.myimc.service.ImcService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ImcController {

	@FXML
	private TextField weightField;

	@FXML
	private TextField heightField;

	@FXML
	private Button calculateButton;

	@FXML
	private Label resultLabel;

	@FXML
	private Label categoryLabel;

	@FXML
	private Label messageLabel;

	private final ImcService imcService;

	public ImcController() {
        this.imcService = new ImcService();
    }

	@FXML
    private void handleCalculate() {
        try {
            // Nettoyage des entrées (accepte virgule ou point)
            String weightText = weightField.getText().replace(',', '.');
            String heightText = heightField.getText().replace(',', '.');

            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText);

            ImcResult result;
			try {
				result = ImcService.calculateImc(weight, height);
				resultLabel.setText(String.format("Votre IMC est de : %.1f", result.getValue()));
	            categoryLabel.setText("Catégorie : " + result.getCategory());
	            messageLabel.setText(result.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            

            // Gestion des styles via CSS
            resultLabel.getStyleClass().removeAll("error");
            resultLabel.getStyleClass().add("success");

        } catch (NumberFormatException e) {
            showError("Veuillez entrer des nombres valides (ex: 70.5 ou 70,5).");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Une erreur inattendue est survenue.");
        }
	}

	private void showError(String message) {
		resultLabel.setText("Erreur");
		categoryLabel.setText("");
		messageLabel.setText(message);
		resultLabel.getStyleClass().removeAll("success");
		resultLabel.getStyleClass().add("error");
	}
}
