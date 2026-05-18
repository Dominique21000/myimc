package fr.dominiquesauvignon.myimc.model;

public class ImcResult {

	private final double value;
    private final String category;
    private final String message;

    public ImcResult(double value, String category, String message) {
        this.value = value;
        this.category = category;
        this.message = message;
    }

    public double getValue() { return value; }
    public String getCategory() { return category; }
    public String getMessage() { return message; }
}
