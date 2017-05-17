package edu.hm.cs.swa.projekt_4.datamodel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import net.bytebuddy.utility.RandomString;

public class TokenFactory {
	
	private final int VALIDITY_IN_MINUTES = 30;
	private final int ID_LENGHT = 12;

	public static TokenFactory INSTANCE = new TokenFactory();
	
	protected TokenFactory(){
		
	}
	
	public Token createToken(){
		
		Date creationDate = new Date();
		
		GregorianCalendar valideUntil = new GregorianCalendar();
		valideUntil.add(Calendar.MINUTE, VALIDITY_IN_MINUTES);
		
		String id = createID(12);
		
	}
	
	private String createID(int lenght){
		
		return RandomString.make(lenght);
	}
	
}
