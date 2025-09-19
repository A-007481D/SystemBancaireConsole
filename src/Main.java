import controller.BanqueController;
import repository.CompteRepository;
import repository.OperationRepository;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        CompteRepository compteRepo = new CompteRepository();
        OperationRepository opRepo = new OperationRepository();
        ConsoleView view = new ConsoleView();
        BanqueController controller = new BanqueController(compteRepo, opRepo, view);
        controller.start();
    }
}