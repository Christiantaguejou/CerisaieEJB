package Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sejour", schema = "cerisaie", catalog = "")
public class SejourEntity {
    private int numSej;
    private Date datedebSej;
    private Date dateFinSej;
    private int nbPersonnes;

    private ClientEntity clientEntity;
    private EmplacementEntity emplacementEntity;

    public SejourEntity(Date datedebSej, Date dateFinSej, int nbPersonnes,ClientEntity clientEntity,EmplacementEntity emplacementEntity) {
        this.datedebSej = datedebSej;
        this.dateFinSej = dateFinSej;
        this.nbPersonnes = nbPersonnes;
        this.clientEntity=clientEntity;
        this.emplacementEntity=emplacementEntity;
    }
//TODO effectuer le mapping des clés etrangères
    public SejourEntity() {
    }

    @Id
    @Column(name = "NumSej", nullable = false)
    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
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
        SejourEntity that = (SejourEntity) o;
        return numSej == that.numSej &&
                nbPersonnes == that.nbPersonnes &&
                Objects.equals(datedebSej, that.datedebSej) &&
                Objects.equals(dateFinSej, that.dateFinSej);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numSej, datedebSej, dateFinSej, nbPersonnes);
    }

    @ManyToOne
    @JoinColumn(name = "NumCli",referencedColumnName = "NumCli",nullable = false)
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @ManyToOne
    @JoinColumn(name = "NumEmpl",referencedColumnName = "NumEmpl",nullable = false)
    public EmplacementEntity getEmplacementEntity() {
        return emplacementEntity;
    }

    public void setEmplacementEntity(EmplacementEntity emplacementEntity) {
        this.emplacementEntity = emplacementEntity;
    }

}
