package Entities;

import javax.persistence.*;

@Entity
@Table(name = "emplacement", schema = "cerisaie", catalog = "")
public class EmplacementEntity {
    private int numEmpl;
    private short surfaceEmpl;
    private short nbPersMaxEmpl;

    @Id
    @Column(name = "NumEmpl", nullable = false)
    public int getNumEmpl() {
        return numEmpl;
    }

    public void setNumEmpl(int numEmpl) {
        this.numEmpl = numEmpl;
    }

    @Basic
    @Column(name = "SurfaceEmpl", nullable = false)
    public short getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(short surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    @Basic
    @Column(name = "NbPersMaxEmpl", nullable = false)
    public short getNbPersMaxEmpl() {
        return nbPersMaxEmpl;
    }

    public void setNbPersMaxEmpl(short nbPersMaxEmpl) {
        this.nbPersMaxEmpl = nbPersMaxEmpl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplacementEntity that = (EmplacementEntity) o;

        if (numEmpl != that.numEmpl) return false;
        if (surfaceEmpl != that.surfaceEmpl) return false;
        if (nbPersMaxEmpl != that.nbPersMaxEmpl) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numEmpl;
        result = 31 * result + (int) surfaceEmpl;
        result = 31 * result + (int) nbPersMaxEmpl;
        return result;
    }
}
