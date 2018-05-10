package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "activite", schema = "cerisaie", catalog = "")
@IdClass(ActiviteEntityPK.class)
public class ActiviteEntity implements Serializable {
    private static final long serialVersionUID = -4534403211896089134L;
    private int codeSport;
    private Date dateJour;
    private int numSej;
    private short nbLoc;

    @Id
    @Column(name = "CodeSport", nullable = false)
    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    @Id
    @Column(name = "DateJour", nullable = false)
    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
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
    @Column(name = "NbLoc", nullable = false)
    public short getNbLoc() {
        return nbLoc;
    }

    public void setNbLoc(short nbLoc) {
        this.nbLoc = nbLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiviteEntity that = (ActiviteEntity) o;
        return codeSport == that.codeSport &&
                numSej == that.numSej &&
                nbLoc == that.nbLoc &&
                Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeSport, dateJour, numSej, nbLoc);
    }
}
