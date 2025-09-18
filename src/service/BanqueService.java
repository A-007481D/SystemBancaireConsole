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

    public Compte c createAccountFlow() {

    }

}