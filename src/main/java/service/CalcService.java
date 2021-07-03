package service;

import entity.Operation;
import entity.User;
import storage.OperationStorage;

import java.util.List;

public class CalcService {

    private final OperationStorage operationStorage = new OperationStorage();

    public Operation calc(double a, double b, String operation, User user) {
        switch (operation) {
            case "sum":
                Operation operation1 = new Operation(a, b, operation, a + b, user);
                operationStorage.save(operation1);
                return operation1;
            case "sub":
                Operation operation2 = new Operation(a, b, operation, a - b, user);
                operationStorage.save(operation2);
                return operation2;
            case "multy":
                Operation operation3 = new Operation(a, b, operation, a * b, user);
                operationStorage.save(operation3);
                return operation3;
            case "div":
                Operation operation4 = new Operation(a, b, operation, a / b, user);
                operationStorage.save(operation4);
                return operation4;
        }
        return null;
    }

    public List<Operation> findAll(){

        return operationStorage.getAll();
    }

    public List<Operation> findByUsername(String username){

        return operationStorage.getByUsername(username);
    }
}
