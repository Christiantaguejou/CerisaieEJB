package com.projetcerisaie.metiers.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "sejours_reserves", schema = "cerisaie", catalog = "")
public class SejoursReservesEntity implements Serializable{
    private int numResa;
    private SejoursProposesEntity sejoursProposesEntity;
    private ClientEntity clientEntity;
    private Date datedebSej;
    private Date dateFinSej;
    private int nbPersonnes;
    private int numCarteCredit;
    private String typeCarteCredit;
    private Date dateExpirationCarte;
    private int totalTtc;

    @Id
    @Column(name = "numResa", nullable = false)
    public int getNumResa() {
        return numResa;
    }

    public void setNumResa(int numResa) {
        this.numResa = numResa;
    }

    @Basic
    @Column(name = "DatedebSej", nullable = false)
    public Date getDatedebSej() {
        return datedebSej;
    }

    public void setDatedebSej(Date datedebSej) {
        this.datedebSej = datedebSej;
    }

    @Basic
    @Column(name = "DateFinSej", nullable = true)
    public Date getDateFinSej() {
        return dateFinSej;
    }

    public void setDateFinSej(Date dateFinSej) {
        this.dateFinSej = dateFinSej;
    }

    @Basic
    @Column(name = "NbPersonnes", nullable = false)
    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SejoursReservesEntity that = (SejoursReservesEntity) o;

        if (numResa != that.numResa) return false;
        if (nbPersonnes != that.nbPersonnes) return false;
        if (datedebSej != null ? !datedebSej.equals(that.datedebSej) : that.datedebSej != null) return false;
        if (dateFinSej != null ? !dateFinSej.equals(that.dateFinSej) : that.dateFinSej != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numResa;
        result = 31 * result + (datedebSej != null ? datedebSej.hashCode() : 0);
        result = 31 * result + (dateFinSej != null ? dateFinSej.hashCode() : 0);
        result = 31 * result + nbPersonnes;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NumCli", referencedColumnName = "NumCli", nullable = false)
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @ManyToOne
    @JoinColumn(name = "NumSej", referencedColumnName = "NumSej", nullable = false)
    public SejoursProposesEntity getSejoursProposesEntity() {
        return sejoursProposesEntity;
    }

    public void setSejoursProposesEntity(SejoursProposesEntity sejoursProposesEntity) {
        this.sejoursProposesEntity = sejoursProposesEntity;
    }


    @Basic
    @Column(name = "NumCarteCredit", nullable = false)
    public int getNumCarteCredit() {
        return numCarteCredit;
    }

    public void setNumCarteCredit(int numCarteCredit) {
        this.numCarteCredit = numCarteCredit;
    }

    @Basic
    @Column(name = "TypeCarteCredit", nullable = false, length = 20)
    public String getTypeCarteCredit() {
        return typeCarteCredit;
    }

    public void setTypeCarteCredit(String typeCarteCredit) {
        this.typeCarteCredit = typeCarteCredit;
    }

    @Basic
    @Column(name = "DateExpirationCarte", nullable = false)
    public Date getDateExpirationCarte() {
        return dateExpirationCarte;
    }

    public void setDateExpirationCarte(Date dateExpirationCarte) {
        this.dateExpirationCarte = dateExpirationCarte;
    }

    @Basic
    @Column(name = "TotalTtc", nullable = false)
    public int getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(int totalTtc) {
        this.totalTtc = totalTtc;
    }
}
