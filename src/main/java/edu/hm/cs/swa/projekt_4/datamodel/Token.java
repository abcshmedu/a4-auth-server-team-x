package edu.hm.cs.swa.projekt_4.datamodel;

import java.util.Date;

public class Token {

	
	
	private String ID;
	private Date created;
	private Date valideUntil;
	
	public Token(){
		
	}
	
	

	public Token(String iD, Date created, Date valideUntil) {
		super();
		ID = iD;
		this.created = created;
		this.valideUntil = valideUntil;
	}



	public String getID() {
		return ID;
	}

	public Date getCreated() {
		return created;
	}

	public Date getValideUntil() {
		return valideUntil;
	}
	
	
}
