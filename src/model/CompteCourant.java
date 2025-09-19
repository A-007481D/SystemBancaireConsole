package model;

public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(String code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(double montant) {
        if (montant <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (solde - montant < -decouvert) {
            throw new IllegalArgumentException("Withdrawal denied: exceeds overdraft limit");
        }
        solde -= montant;
    }

    @Override
    public double calculerInteret() {
        return 0.0;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Courant " + code + " | Solde: " + solde + " | Découvert: " + decouvert);
    }

    public double getDecouvert() {
        return decouvert;
    }
}