package metier;

import javax.persistence.*;

@Entity
@Table(name = "type_emplacement", schema = "cerisaie", catalog = "")
public class TypeEmplacementEntity {
    private int codeTypeE;
    private String libtypepl;
    private int tariftypepl;

    @Id
    @Column(name = "CodeTypeE", nullable = false)
    public int getCodeTypeE() {
        return codeTypeE;
    }

    public void setCodeTypeE(int codeTypeE) {
        this.codeTypeE = codeTypeE;
    }

    @Basic
    @Column(name = "LIBTYPEPL", nullable = false, length = 30)
    public String getLibtypepl() {
        return libtypepl;
    }

    public void setLibtypepl(String libtypepl) {
        this.libtypepl = libtypepl;
    }

    @Basic
    @Column(name = "TARIFTYPEPL", nullable = false)
    public int getTariftypepl() {
        return tariftypepl;
    }

    public void setTariftypepl(int tariftypepl) {
        this.tariftypepl = tariftypepl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEmplacementEntity that = (TypeEmplacementEntity) o;

        if (codeTypeE != that.codeTypeE) return false;
        if (tariftypepl != that.tariftypepl) return false;
        if (libtypepl != null ? !libtypepl.equals(that.libtypepl) : that.libtypepl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeTypeE;
        result = 31 * result + (libtypepl != null ? libtypepl.hashCode() : 0);
        result = 31 * result + tariftypepl;
        return result;
    }
}
