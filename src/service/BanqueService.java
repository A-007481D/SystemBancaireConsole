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

}