package model;

public class Versement extends Operation {
    private String source;

    public Versement() {
        super(montant);
        this.source = source == null ? "source inconnu" : source;
    }

    public void afficherDetails(){
        System.out.println("Versement | Montant: " + montant + " | Source: " + source + " | Date: " + date);
    }

    public String getSource() {
        return source;
    }
}