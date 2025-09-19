package service;

import model.*;
import repository.*;


public class BanqueService {
    private CompteRepository compteRepo;
    private OperationRepository operationRepo;

    public BanqueService(CompteRepository compteRepo, OperationRepo operationRepo) {
        this.compteRepo = compteRepo;
        this.operationRepo = operationRepo;

    }

    public Compte createCompteCourant(String code, double initial, double decouvert) {
        Compte c = new CompteCourant(code, initial, decouvert);
        compteRepo.save(c);
        return c;

    }

    public Compte createCompteEpargne(String code, double initial, double taux) {
        Comtpe c = new CompteEpargne(code, initial,taux);
        compteRepo.save(c);
        return c;
    }

    public void effectuerVersement(Compte, double montant, String source){
        Versement v = new Versement(montant, source);
        compte.setSolde(compte.getSolde() + montant);
        compte.ajouterOperation(v);
        operationRepo.save(v);
    }

    public void effectuerRetraite(Compte, double montant, String destination){
        compte.retirer(montant)
        Retrait r = new Retrait(montant, destination);
        compte.ajouterOperation(r);
        operationRepo.save(r);
    }

    public void effectuerVirement(Compte src, Compte dest, double montant){
        src.retirer(montant);
        Retrait r = new Retrait(montant, "Virement vers " + dest.getCode());
        src.ajouterOperation(r);
        operationRepo.save(r);

        Versement v = new Versement(montant, "Virement de " + src.getCode());
        dest.setSolde(dest.getSolde() + montant);
        dest.ajouterOperation(v);
        operationRepo.save(v);
    }

    public double consulterSolde(Compte compte) {
        return compte.getSolde();
    }

    public void listerOperations(Compte compte) {
        if (compte.getListOperation().isEmpty()) {
            System.out.println("pas d'operations trouve pour " + compte.getCode());
        } else {
            compte.getListOperations().forEach(Operation::afficherDetails);
        }
    }



}