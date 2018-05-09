package com.projetcerisaie.metiers.meserreurs;

public class MonException  extends Exception  {
    private static final long serialVersionUID = -7947971170732873718L;
    private String message;
    private String type;

    public MonException() {
    }

    public MonException( String libelle,  String type) {
        this.message = libelle;
        this.type = type;
    }

    public MonException( String libelle) {
        this.message = libelle;
       
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String libelle) {
        this.message = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
