package com.projetcerisaie.metiers.Entities;

import javax.persistence.*;

@Entity
@Table(name = "sport", schema = "cerisaie", catalog = "")
public class SportEntity {
    private int codeSport;
    private String libelleSport;
    private String uniteTpsSport;
    private int tarifUnite;

    @Id
    @Column(name = "CodeSport", nullable = false)
    public int getCodeSport() {
        return codeSport;
    }

    public void setCodeSport(int codeSport) {
        this.codeSport = codeSport;
    }

    @Basic
    @Column(name = "LibelleSport", nullable = false, length = 100)
    public String getLibelleSport() {
        return libelleSport;
    }

    public void setLibelleSport(String libelleSport) {
        this.libelleSport = libelleSport;
    }

    @Basic
    @Column(name = "UniteTpsSport", nullable = false, length = 20)
    public String getUniteTpsSport() {
        return uniteTpsSport;
    }

    public void setUniteTpsSport(String uniteTpsSport) {
        this.uniteTpsSport = uniteTpsSport;
    }

    @Basic
    @Column(name = "TarifUnite", nullable = false)
    public int getTarifUnite() {
        return tarifUnite;
    }

    public void setTarifUnite(int tarifUnite) {
        this.tarifUnite = tarifUnite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEntity that = (SportEntity) o;

        if (codeSport != that.codeSport) return false;
        if (tarifUnite != that.tarifUnite) return false;
        if (libelleSport != null ? !libelleSport.equals(that.libelleSport) : that.libelleSport != null) return false;
        if (uniteTpsSport != null ? !uniteTpsSport.equals(that.uniteTpsSport) : that.uniteTpsSport != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeSport;
        result = 31 * result + (libelleSport != null ? libelleSport.hashCode() : 0);
        result = 31 * result + (uniteTpsSport != null ? uniteTpsSport.hashCode() : 0);
        result = 31 * result + tarifUnite;
        return result;
    }
}
