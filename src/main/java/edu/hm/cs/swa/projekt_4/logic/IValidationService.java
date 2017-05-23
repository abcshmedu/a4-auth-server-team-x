package edu.hm.cs.swa.projekt_4.logic;

public interface IValidationService {

	public ValidationResult validateToke(String tokenID, String authorizationID);
}
