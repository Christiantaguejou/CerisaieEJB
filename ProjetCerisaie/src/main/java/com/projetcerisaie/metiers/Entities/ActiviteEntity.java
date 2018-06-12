package com.projetcerisaie.metiers.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "activite", schema = "cerisaie", catalog = "")
public class ActiviteEntity implements Serializable{
    private int numInscription;
    private SportEntity sport;
    private Date dateJour;
    private int nbLoc;
    private SejoursReservesEntity sejoursReservesEntity;


    @Id
    @Column(name = "NumInscription", nullable = false)
    public int getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(int numInscription) {
        this.numInscription = numInscription;
    }

    @Basic
    @Column(name = "DateJour", nullable = false)
    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    @Basic
    @Column(name = "NbLoc", nullable = false)
    public int getNbLoc() {
        return nbLoc;
    }

    public void setNbLoc(int nbLoc) {
        this.nbLoc = nbLoc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiviteEntity that = (ActiviteEntity) o;

        if (numInscription != that.numInscription) return false;
        if (nbLoc != that.nbLoc) return false;
        if (dateJour != null ? !dateJour.equals(that.dateJour) : that.dateJour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numInscription;
        result = 31 * result + (dateJour != null ? dateJour.hashCode() : 0);
        result = 31 * result + nbLoc;
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "CodeSport",referencedColumnName = "CodeSport",nullable = false)
    public SportEntity getSport() {
        return sport;
    }

    public void setSport(SportEntity sport) {
        this.sport = sport;
    }

    @ManyToOne
    @JoinColumn(name = "NumResa",referencedColumnName = "NumResa",nullable = false)
    public SejoursReservesEntity getSejoursReservesEntity() {
        return sejoursReservesEntity;
    }

    public void setSejoursReservesEntity(SejoursReservesEntity sejoursReservesEntity) {
        this.sejoursReservesEntity = sejoursReservesEntity;
    }


}
