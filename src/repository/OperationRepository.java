package repository;

import model.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationRepository {
    private List<Operation> operations = new ArrayList<>();

    public void save(Operation op) { operations.add(op); }

    public List<Operation> findAll() { return operations; }
}