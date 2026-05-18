package fr.dominiquesauvignon.myimc.service;

import fr.dominiquesauvignon.myimc.model.ImcResult;

public class ImcService {

	public static ImcResult calculateImc(double weightKg, double heightM) {
		// Validation des entrées
		if (weightKg <= 0 || heightM <= 0) {
			throw new IllegalArgumentException("Le poids et la taille doivent être supérieurs à 0.");
		}
		if (heightM > 3.0) {
			throw new IllegalArgumentException(
					"La taille semble erronée ( > 3m ). Vérifiez si vous n'avez pas mis des cm.");
		}

		// Calcul
		double imcValue = weightKg / (heightM * heightM);
		imcValue = Math.round(imcValue * 10.0) / 10.0; // Arrondi 1 décimale

		// Interprétation (Standards OMS)
		String category;
		String message;

		if (imcValue < 18.5) {
			category = "Insuffisance pondérale";
			message = "Il est recommandé de consulter un nutritionniste pour un bilan.";
		} else if (imcValue < 25.0) {
			category = "Poids normal";
			message = "Bravo ! Continuez à maintenir une alimentation équilibrée.";
		} else if (imcValue < 30.0) {
			category = "Surpoids";
			message = "Une activité physique régulière et un rééquilibrage alimentaire sont conseillés.";
		} else {
			category = "Obésité";
			message = "Il est fortement recommandé de consulter un professionnel de santé.";
		}

		return new ImcResult(imcValue, category, message);
	}
}
