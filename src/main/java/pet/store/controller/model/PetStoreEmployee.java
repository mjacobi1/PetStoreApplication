package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreEmployee {
	private Long employeeId; 
	private String employeeName;
	private String employeeEmail;
	private PetStore petStore;
}
