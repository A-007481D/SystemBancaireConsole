package controller;

import model.Compte;
import repository.CompteRepository;
import repository.OperationRepository;
import service.BanqueService;
import util.AccountCodeGenerator;
import view.ConsoleView;
import java.util.regex.Pattern;

public class BanqueController {
    private CompteRepository compteRepo;
    private OperationRepository operationRepo;
    private BanqueService banqueService;
    private ConsoleView view;

    public BanqueController(CompteRepository compteRepo, OperationRepository operationRepo, ConsoleView view) {
        this.compteRepo = compteRepo;
        this.operationRepo = operationRepo;
        this.banqueService = new BanqueService(compteRepo, operationRepo);
        this.view = view;
    }

    public void start() {
        while (true) {
            int choice = view.showMainMenu();
            switch (choice) {
                case 1:
                    createAccountFlow();
                    break;
                case 2:
                    selectAccountFlow();
                    break;
                case 3:
                    listAllAccounts();
                    break;
                case 0:
                    view.showMessage("Thella!");
                    return;
                default:
                    view.showMessage("choix invalid");
            }
        }
    }

    private void createAccountFlow() {
        view.showMessage("\nCreer compte:");
        String code = AccountCodeGenerator.nextCode();
        view.showMessage("code generé: " + code);
        int type = view.readInt("Type (1 = courant, 2 = epargne): ");
        double initial = view.readDouble("balance initial (>=0): ");
        if (initial < 0) { view.showMessage("balance khasso ykon >= 0"); return; }

        try {
            if (type == 1) {
                double dec = view.readDouble("Overdraft limit (positive): ");
                banqueService.createCompteCourant(code, initial, dec);
            } else if (type == 2) {
                double taux = view.readDouble("Interest rate (e.g. 0.03): ");
                banqueService.createCompteEpargne(code, initial, taux);
            } else {
                view.showMessage("Invalid type");
                return;
            }
            view.showMessage("Account created: " + code);
        } catch (Exception e) {
            view.showMessage("Error creating account: " + e.getMessage());
        }
    }

    private void selectAccountFlow() {
        String code = view.readLine("Enter account code (format CPT-00001): ").toUpperCase();
        if (!Pattern.matches("CPT-\\d{5}", code)) {
            view.showMessage("Invalid code format");
            return;
        }
        Compte compte = compteRepo.findByCode(code).orElse(null);
        if (compte == null) {
            view.showMessage("Account not found: " + code);
            return;
        }

        while (true) {
            int choice = view.showAccountMenu(code);
            try {
                switch (choice) {
                    case 1:
                        double m = view.readDouble("Amount to deposit: ");
                        if (m <= 0) { view.showMessage("Amount must be positive"); break; }
                        String src = view.readLine("Source: ");
                        banqueService.effectuerVersement(compte, m, src);
                        view.showMessage("Deposited " + m);
                        break;
                    case 2:
                        double mr = view.readDouble("Amount to withdraw: ");
                        if (mr <= 0) { view.showMessage("Amount must be positive"); break; }
                        String dest = view.readLine("Destination: ");
                        banqueService.effectuerRetrait(compte, mr, dest);
                        view.showMessage("Withdrew " + mr);
                        break;
                    case 3:
                        String destCode = view.readLine("Destination account code: ").toUpperCase();
                        if (!Pattern.matches("CPT-\\d{5}", destCode)) { view.showMessage("Invalid code format"); break; }
                        Compte destCompte = compteRepo.findByCode(destCode).orElse(null);
                        if (destCompte == null) { view.showMessage("Destination not found"); break; }
                        double mt = view.readDouble("Amount to transfer: ");
                        banqueService.effectuerVirement(compte, destCompte, mt);
                        view.showMessage("Transferred " + mt + " to " + destCode);
                        break;
                    case 4:
                        double solde = banqueService.consulterSolde(compte);
                        view.showMessage("Balance: " + String.format("%.2f", solde));
                        break;
                    case 5:
                        banqueService.listerOperations(compte);
                        break;
                    case 0:
                        return;
                    default:
                        view.showMessage("Invalid choice");
                }
            } catch (Exception e) {
                view.showMessage("Error: " + e.getMessage());
            }
        }
    }

    private void listAllAccounts() {
        view.showMessage("\nAll accounts:");
        compteRepo.findAll().forEach(c -> c.afficherDetails());
    }
}