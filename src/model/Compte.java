package model;
import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;

    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public abstract void afficherDetails();
    public abstract void retier(double solde);
    public abstract double calculerInteret();

    public double getSolde() {
        return solde;
    }
    public String getCode() {
        return code;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }
}