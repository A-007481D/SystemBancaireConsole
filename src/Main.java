import controller.BanqueController;
import repository.OperationRepository;
import repository.CompteRepository;


public class Main {
    public static void main(String[] args) {
        CompteRepository compteRepo = new CompteRepository();
        OperationRepository opRepo = new OperationRepository();
        BanqueController banqueController = new BanqueController(compteRepo, opRepo);
        controller.start();
    }
}