package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Compte {
    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;

    public Compte(String code, double solde) {
        if (code == null || !Pattern.matches("CPT-\\d{5}", code)) {
            throw new IllegalArgumentException("Invalid account code format");
        }
        this.code = code;
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public abstract void retirer(double montant);

    public abstract double calculerInteret();

    public abstract void afficherDetails();

    public void ajouterOperation(Operation op) {
        listeOperations.add(op);
    }

    public String getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }
}
