package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Employee;

@Data
@NoArgsConstructor
public class PetStoreEmployee {
	private Long employeeId; 
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeJobTitle;
	private String employeePhoneNumber;
	private Long petStoreId;
	public PetStoreEmployee (Employee employee) {
		employeeId = employee.getEmployeeId(); 
		employeeFirstName = employee.getEmployeeFirstName();
		employeeLastName = employee.getEmployeeLastName();
		employeeJobTitle = employee.getEmployeeJobTitle();
		employeePhoneNumber = employee.getEmployeePhoneNumber();
	}
}
