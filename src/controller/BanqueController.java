package controller;

import model.Compte;
import service.BanqueService;
import repository.CompteRepository;
import repository.OperationRepository;
import view.ConsoleView

public class BanqueController {
    private CompteRepository compteRepo;
    private OperationRepository operationRepo;
    private BanqueService banqueService;
    private ConsoleView view;



    public BanqueController(CompteRepository compteRepo, OperationRepository operationRep, ConsoleView consoleView) {
        this.compteRepo = compteRepo;
        this.operationRepo = operationRep;
        this.banqueService = new BanqueService(compteRepo, OperationRepo);
        this.view;

    }

    public void start() {
        while(true) {
            int choice = view.showMainMenu();
            switch(choice) {
                case 1: createAccountFlow(); break;
                case 2: selectAccountFlow(); break;
                case 3: listAllAccounts(); break;
                case 0: view.showMessage("Thella!"); break;
                default: view.showMessage("3awd khtar!");
            }
        }
    }

    public void createAccountFlow() {
        view.showMessage("\nCreer compte");
        String code = AccountCodeGenerator.nextCode();
        view.ShowMessage("code generé : " + code);
    }



}