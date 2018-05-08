package com.projetcerisaie.metiers.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ActiviteEntityPK implements Serializable {
    private int codeSport;
    private Date dateJour;
    private int numSej;

    @Column(name = "CodeSport", nullable = false)
    @Id
    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    @Column(name = "DateJour", nullable = false)
    @Id
    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    @Column(name = "NumSej", nullable = false)
    @Id
    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiviteEntityPK that = (ActiviteEntityPK) o;
        return codeSport == that.codeSport &&
                numSej == that.numSej &&
                Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeSport, dateJour, numSej);
    }
}
