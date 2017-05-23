package edu.hm.cs.swa.projekt_4.logic;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ValidationResult {
    CREATE_USER,
    AUTHORIZATION_OK,
    AUTHORIZATION_MISSING,
    TOKEN_EXPRIED,
    TOKEN_INVALIDE

}
