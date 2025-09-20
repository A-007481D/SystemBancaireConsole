package model;

public class CompteEpargne extends Compte {
    private double tauxInteret = 0.03;
    private long dernierDepot;

    public CompteEpargne(String code, double solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
        this.dernierDepot = System.currentTimeMillis();
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
        long now = System.currentTimeMillis();
        long diff = now - dernierDepot;
        if(diff >= 5000) {
            double interet = solde * tauxInteret;
            solde += interet;
            dernierDepot = now;
            return interet;
        }
        return 0;
    }

    public void deposer(double montant) {
        solde += montant;
        dernierDepot = System.currentTimeMillis();
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte Epargne " + code + " | Solde: " + solde + " | Taux: " + tauxInteret);
    }

    public double getTauxInteret() { return tauxInteret; }
}


