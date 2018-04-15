/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AdiRahmad
 */
@Entity
@Table(name = "DETAIL_KARYAWAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailKaryawan.findAll", query = "SELECT d FROM DetailKaryawan d")
    , @NamedQuery(name = "DetailKaryawan.findByNik", query = "SELECT d FROM DetailKaryawan d WHERE d.nik = :nik")})
public class DetailKaryawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @JoinColumn(name = "ID_JABATAN", referencedColumnName = "ID_JABATAN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jabatan idJabatan;

    public DetailKaryawan() {
    }

    public DetailKaryawan(String nik) {
        this.nik = nik;
    }

    public DetailKaryawan(String nik, Jabatan idJabatan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Jabatan getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(Jabatan idJabatan) {
        this.idJabatan = idJabatan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailKaryawan)) {
            return false;
        }
        DetailKaryawan other = (DetailKaryawan) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailKaryawan[ nik=" + nik + " ]";
    }
    
}
