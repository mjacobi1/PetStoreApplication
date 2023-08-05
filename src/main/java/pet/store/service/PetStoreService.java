package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
	@Autowired
	private PetStoreDao petStoreDao;

	
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		
		Long petStoreId = petStoreData.getPetStoreId();
		PetStore petStore = findOrCreatePetStore(petStoreId);
		copyPetStoreFields(petStore, petStoreData);
		return new PetStoreData(petStoreDao.save(petStore));
	}
	
		private PetStore findOrCreatePetStore(Long petStoreId) {
			PetStore petStore;
			if(Objects.isNull(petStoreId)) {
				return new PetStore();
			} else {
			return findPetStoreById(petStoreId);
			}
		}
		

		private PetStore findPetStoreById(Long petStoreId) {
			return petStoreDao.findById(petStoreId).orElseThrow(()-> new NoSuchElementException("Pet Store with Id=" + petStoreId + " was not found."));

		}

		
		
		//Matching fields are copied from the PetStoreData object to the PetStore object. Do not copy the customers or employees fields.
		private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
			
			Long petStoreId = petStore.getPetStoreId();
			String petStoreName = petStore.getPetStoreName();
			String petStoreAddress = petStore.getPetStoreAddress();
			String petStoreCity = petStore.getPetStoreCity();
			String petStoreState = petStore.getPetStoreState();
			String petStoreZip = petStore.getPetStoreZip();
			String petStorePhone = petStore.getPetStorePhone();
	}	
}
