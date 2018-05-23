package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "activite", schema = "cerisaie", catalog = "")
@IdClass(ActiviteEntityPK.class)
public class ActiviteEntity implements Serializable {
    //private static final long serialVersionUID = -4534403211896089134L;
    private int codeSport;
    private Date dateJour;
    private int numSej;
    private int nbLoc;

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

        if (codeSport != that.codeSport) return false;
        if (numSej != that.numSej) return false;
        if (nbLoc != that.nbLoc) return false;
        if (dateJour != null ? !dateJour.equals(that.dateJour) : that.dateJour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeSport;
        result = 31 * result + (dateJour != null ? dateJour.hashCode() : 0);
        result = 31 * result + numSej;
        result = 31 * result + nbLoc;
        return result;
    }
}
