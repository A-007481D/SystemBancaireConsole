package model;

public class Versement extends Operation {

    private String source;

    public Versement(double montant, String source) {
        super(montant);
        this.source = source;
    }

    @Override
    public void afficherDetails() {
        System.out.println("vcersement : " + montant + " | source : " + source + " | date : " + date );
    }
}