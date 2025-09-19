package model;

public class CompteEpargne extends Compte {
    private double tauxInteret = 0.06;
    private long dernierDepot;

    public CompteEpargne(String code, double solde, double tauxInteret){
        super(code, solde);
        this.tauxInteret = tauxInteret;
        this.dernierDepot = System.currentTimeMillis();
    }

    @Override
    public void retirer(double montant) {
        if(solde < montant ) {
            throw new IllegalArgumentException("interdit tirer daba, 3mmer lcompte b3da");
        }
        solde -=montant;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte epargne :" + code + " | solde : " + solde + " | taux : " + tauxInteret);
    }
    @Override
    public double calculerInteret() {
        long now = System.currentTimeMillis();
        long diff = now - dernierDepot;
        if(diff >= 5000){
            double interet = solde * tauxInteret;
            solde += interet;
            dernierDepot = now;
            return interet;
        }
        return 0;
    }









}