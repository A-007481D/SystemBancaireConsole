package model;

public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(String code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    public void retirer(double montant) {
        if(solde - montant < -decouvert) {
            throw new IllegalArgumentException("7dek tma, rak fetty limite!");
        }
        solde -= montant;
    }


    public double calculerInteret() {
        return 0.0;
    }

    public void afficherDetailes() {
        System.out.println("Compte courant:" + code + " | Solde : " + solde + " | Decouvert : " + decouvert);
    }


    public double getDecouvert() {
        return decouvert;
    }




}