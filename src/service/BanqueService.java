package service;

import model.*;
import repository.CompteRepository;
import repository.OperationRepository;

public class BanqueService {
    private CompteRepository compteRepo;
    private OperationRepository operationRepo;

    public BanqueService(CompteRepository compteRepo, OperationRepository operationRepo) {
        this.compteRepo = compteRepo;
        this.operationRepo = operationRepo;
    }

    public Compte createCompteCourant(String code, double initial, double decouvert) {
        Compte c = new CompteCourant(code, initial, decouvert);
        compteRepo.save(c);
        return c;
    }

    public Compte createCompteEpargne(String code, double initial, double taux) {
        Compte c = new CompteEpargne(code, initial, taux);
        compteRepo.save(c);
        return c;
    }

    public void effectuerVersement(Compte compte, double montant, String source) {
        Versement v = new Versement(montant, source);
        compte.setSolde(compte.getSolde() + montant);
        compte.ajouterOperation(v);
        operationRepo.save(v);
    }

    public void effectuerRetrait(Compte compte, double montant, String destination) {
        compte.retirer(montant);
        Retrait r = new Retrait(montant, destination);
        compte.ajouterOperation(r);
        operationRepo.save(r);
    }

    public void effectuerVirement(Compte src, Compte dest, double montant) {
        src.retirer(montant);
        Retrait r = new Retrait(montant, "Virement vers " + dest.getCode());
        src.ajouterOperation(r);
        operationRepo.save(r);

        Versement v = new Versement(montant, "Virement de " + src.getCode());
        dest.setSolde(dest.getSolde() + montant);
        dest.ajouterOperation(v);
        operationRepo.save(v);
    }

    public double consulterSolde(Compte compte) { return compte.getSolde(); }

    public void listerOperations(Compte compte) {
        if (compte.getListeOperations().isEmpty()) {
            System.out.println("No operations found for " + compte.getCode());
        } else {
            compte.getListeOperations().forEach(Operation::afficherDetails);
        }
    }
}