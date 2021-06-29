package com.tms.service;

import com.tms.entity.Operation;
import com.tms.entity.User;
import com.tms.storage.OperationStorage;

import java.util.ArrayList;
import java.util.List;

public class CalcService {

	private final OperationStorage operationStorage = new OperationStorage();

	public Operation calc(double a, double b, String operation, User user) {
		switch (operation) {
			case "sum":
				Operation sum = new Operation(a, b, operation, a + b, user);
				operationStorage.save(sum);
				return sum;
			case "sub":
				Operation sub = new Operation(a, b, operation, a - b, user);
				operationStorage.save(sub);
				return sub;
			case "multi":
				Operation multi = new Operation(a, b, operation, a * b, user);
				operationStorage.save(multi);
				return multi;
			case "div":
				if (b != 0){
					Operation div = new Operation(a, b, operation, a / b, user);
					operationStorage.save(div);
					return div;
				}
		}
		return null;
	}

	public List<Operation> findAllByUser(User user){
		List<Operation> operationList = new ArrayList<>();
		for (Operation operation : operationStorage.getAll()){
			if (operation.getUser().getUsername().equals(user.getUsername())){
				operationList.add(operation);
			}
		}
		return operationList;
	}
}
