package com.projetcerisaie.metiers.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emplacement", schema = "cerisaie", catalog = "")
public class EmplacementEntity {
    private int numEmpl;
    private int surfaceEmpl;
    private int nbPersMaxEmpl;

    private TypeEmplacementEntity typeEmplacementEntity;

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
    public int getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(int surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    @Basic
    @Column(name = "NbPersMaxEmpl", nullable = false)
    public int getNbPersMaxEmpl() {
        return nbPersMaxEmpl;
    }

    public void setNbPersMaxEmpl(int nbPersMaxEmpl) {
        this.nbPersMaxEmpl = nbPersMaxEmpl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmplacementEntity that = (EmplacementEntity) o;
        return numEmpl == that.numEmpl &&
                surfaceEmpl == that.surfaceEmpl &&
                nbPersMaxEmpl == that.nbPersMaxEmpl;
    }

    @ManyToOne
    @JoinColumn(name = "CodeTypeE",referencedColumnName = "CodeTypeE",nullable = false)
    public TypeEmplacementEntity getTypeEmplacementEntity() {
        return typeEmplacementEntity;
    }

    public void setTypeEmplacementEntity(TypeEmplacementEntity typeEmplacementEntity) {
        this.typeEmplacementEntity = typeEmplacementEntity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(numEmpl, surfaceEmpl, nbPersMaxEmpl);
    }
}
