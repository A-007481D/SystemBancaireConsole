package model;

public class CompteEpargne extends Compte {
    private double tauxInteret = 0.03;

    public CompteEpargne(String code, double solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void retirer(double montant) {
        if (montant <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (solde < montant) {
            throw new IllegalArgumentException("Withdrawal denied: insufficient funds (no overdraft)");
        }
        solde -= montant;
    }

    @Override
    public double calculerInteret() {
        return solde * tauxInteret;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Epargne " + code + " | Solde: " + solde + " | Taux: " + tauxInteret);
    }

    public double getTauxInteret() { return tauxInteret; }
}


