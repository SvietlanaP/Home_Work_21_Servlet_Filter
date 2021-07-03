package storage;


import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationStorage {

    private static List<Operation> operationList = new ArrayList<>();

    public void save(Operation o){
        operationList.add(o);
    }

    public List<Operation> getAll(){

        return new ArrayList<>(operationList);
    }

    public List<Operation> getByUsername(String username){

        List<Operation> userOper = new ArrayList<>();

        for (Operation operation : operationList){
            if (operation.getUser().getUsername().equals(username)){
                userOper.add(operation);
            }
        }
        return userOper;
    }

}
