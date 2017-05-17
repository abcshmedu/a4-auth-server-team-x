package edu.hm.cs.swa.projekt_4.datamodel;

import net.bytebuddy.utility.RandomString;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TokenFactory {

    private final int VALIDITY_IN_MINUTES = 30;
    private final int ID_LENGHT = 12;

    public static TokenFactory INSTANCE = new TokenFactory();

    protected TokenFactory() {

    }

    public Token createToken() {

        Date creationDate = new Date();

        GregorianCalendar valideUntil = new GregorianCalendar();
        valideUntil.add(Calendar.MINUTE, VALIDITY_IN_MINUTES);

        String id = createID(12);
        return new Token(id, creationDate, valideUntil.getTime());
    }

    private String createID(int lenght) {

        return RandomString.make(lenght);
    }

}
