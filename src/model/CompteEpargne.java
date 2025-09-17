package model;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String code, double solde, double tauxInteret){
        super(code, solde);
        this.tauxInteret = tauxInteret;
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
    public double calculerInteret() {return solde * tauxInteret;}









}