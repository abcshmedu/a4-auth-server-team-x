package edu.hm.cs.swa.projekt_4.logic;

import edu.hm.cs.swa.projekt_4.datamodel.User;
import edu.hm.cs.swa.projekt_4.persistence.DataStore;

public class ValidationServiceImpl implements IValidationService {

	@Override
	public ValidationResult validateToke(String tokenID, String authorizationID) {

		ValidationResult result = null;
		
		User user =	DataStore.INSTANCE.getUserForToken(tokenID);
		
		if(user == null){
			result = ValidationResult.TOKEN_INVALIDE;
		}
		
		if(user != null){
			boolean authorized = user.hasAuthorization(authorizationID);
			
			if(authorized){
				result = ValidationResult.AUTHORIZATION_OK;
			}
			else{
				result = ValidationResult.AUTHORIZATION_MISSING;
			}
		}
		
		return result;
	}



}
