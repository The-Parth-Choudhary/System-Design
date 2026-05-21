package AmazonLocker;

import java.sql.Timestamp;

public class AccessToken {
    private String code;
    private Timestamp expiration;
    private Compartment compartment;

    public boolean isExpired(){
        return false;
    }

    public Compartment getCompartment(){
        return this.compartment;
    }

    public String getCode(){
        return this.code;
    }
}
