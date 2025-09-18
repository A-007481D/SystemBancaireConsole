package controller;

import model.Compte;
import service.BanqueService;
import repository.CompteRepository;
import repository.OperationRepository;
import view.ConsoleView;
import util.AccountCodeGenerator;
import java.util.regex.Pattern;

public class BanqueController {
    private CompteRepository compteRepo;
    private OperationRepository operationRepo;
    private BanqueService banqueService;
    private ConsoleView view;



    public BanqueController(CompteRepository compteRepo, OperationRepository operationRep, ConsoleView consoleView) {
        this.compteRepo = compteRepo;
        this.operationRepo = operationRep;
        this.banqueService = new BanqueService(compteRepo, OperationRepo);
        this.view = view;

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
        view.showMessage("\ncreer compte");
        String code = AccountCodeGenerator.nextCode();
        view.ShowMessage("code generé : " + code);
        int type = view.readInt("Type (1 = courant, 2 = epargne): ");
        double initial = view.readDouble("balance initial (>=0): ");
        if (initial < 0) { view.showMessage("balance khasso ykon >= 0"); return; }

        try {
            if (type == 1) {
                double dec = view.readDouble("ch7al max dyal -solde: ");
                banqueService.createCompteCourant(code, initial, dec);
            } else if (type == 2) {
                double taux = view.readDouble("dkhel percentage d riba: ");
                banqueService.createCompteEpargne(code, initial, taux);
            } else {
                view.showMessage("ma3ndnach had type dl comptes");
                return;
            }
            view.showMessage("merhba bik m3ana: " + code);
        } catch (Exception e) {
            view.showMessage("walo compte mabghach yt9ad lik: " + e.getMessage());
        }
    }
    private void selectAccountFlow() {
        String code = view.readLine("dkhel nmra dlcompte : ").toUpperCase();
        if (!Pattern.matches("CPT-\\d{5}", code)) {
            view.showMessage("machy hakak, nmra khas tkon CPT-00001 matalan");
            return;
        }
        Compte compte = compteRepo.findByCode(code).orElse(null);
        if (compte == null) {
            view.showMessage("ma3ndnach chi hsab bhad nmra : " + code);
            return;
        }

        while (true) {
            int choice = view.showAccountMenu(code);
            try {
                switch (choice) {
                    case 1:
                        double m = view.readDouble("chhal bghiti t7ett 3ndna : ");
                        if (m <= 0) { view.showMessage("wach nta hmar"); break; }
                        String src = view.readLine("source: ");
                        banqueService.effectuerVersement(compte, m, src);
                        view.showMessage("safi versiti " + m);
                        break;
                    case 2:
                        double mr = view.readDouble("chhal tbghi tirer: ");
                        if (mr <= 0) { view.showMessage("Amount must be positive"); break; }
                        String dest = view.readLine("fin bghiti tirehom: ");
                        banqueService.effectuerRetrait(compte, mr, dest);
                        view.showMessage("sf tiriti " + mr);
                        break;
                    case 3:
                        String destCode = view.readLine("dkhel lmem ghatsifthom: ").toUpperCase();
                        if (!Pattern.matches("CPT-\\d{5}", destCode)) { view.showMessage("nmra dlcomte machy hiya hadik"); break; }
                        Compte destCompte = compteRepo.findByCode(destCode).orElse(null);
                        if (destCompte == null) { view.showMessage("ma3ndnach had lhsab"); break; }
                        double mt = view.readDouble("chhal atsift: ");
                        banqueService.effectuerVirement(compte, destCompte, mt);
                        view.showMessage("sifetty " + mt + " l " + destCode);
                        break;
                    case 4:
                        view.showMessage("solde dyalk: " + banqueService.consulterSolde(compte));
                        break;
                    case 5:
                        banqueService.listerOperations(compte);
                        break;
                    case 0:
                        return;
                    default:
                        view.showMessage("3awd khtar");
                }
            } catch (Exception e) {
                view.showMessage("Error: " + e.getMessage());
            }
        }
    }

    private void listAllAccounts() {
        view.showMessage("\nga3 lhsabat:");
        compteRepo.findAll().forEach(c -> c.afficherDetails());
    }
}