package com.projetcerisaie.metiers.Entities;

import java.io.Serializable;
import java.sql.Date;

public class Activite implements Serializable {
    public Activite() {
    }

    private int codeSport;

    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
    }

    public int getNbLoc() {
        return nbLoc;
    }

    public void setNbLoc(int nbLoc) {
        this.nbLoc = nbLoc;
    }

    private Date dateJour;
    private int numSej;
    private int nbLoc;
}
