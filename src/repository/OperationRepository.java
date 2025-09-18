package repository;

public class OperationRepository {
    private List<Operation> operations = new ArrayList<>();

    private void save(Operation op) {
        operations.add(op);
    }

    public List<Operation> findAll() {
        return operations;
    }
}