package metier;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sejours_proposes", schema = "cerisaie", catalog = "")
public class SejoursProposesEntity {
    private int numSej;
    private Date dateFinOffre;
    private EmplacementEntity emplacementEntity;

    @Id
    @Column(name = "NumSej", nullable = false)
    public int getNumSej() {
        return numSej;
    }

    public void setNumSej(int numSej) {
        this.numSej = numSej;
    }

    @Basic
    @Column(name = "DateFinOffre", nullable = false)
    public Date getDateFinOffre() {
        return dateFinOffre;
    }

    public void setDateFinOffre(Date dateFinOffre) {
        this.dateFinOffre = dateFinOffre;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SejoursProposesEntity that = (SejoursProposesEntity) o;

        if (numSej != that.numSej) return false;
        if (dateFinOffre != null ? !dateFinOffre.equals(that.dateFinOffre) : that.dateFinOffre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numSej;
        result = 31 * result + (dateFinOffre != null ? dateFinOffre.hashCode() : 0);
        return result;
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
