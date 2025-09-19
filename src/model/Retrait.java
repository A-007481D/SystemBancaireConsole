package model;

public class Retrait extends Operation {
    private String destination;

    public Retrait(double montant, String destination) {
        super(montant);
        this.destination = destination == null ? "Inconnu" : destination;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Retrait | Montant: " + montant + " | Destination: " + destination + " | Date: " + date);
    }

    public String getDestination() { return destination; }
}