/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hanan
 */
@Entity
@Table(name = "PULJER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puljer.findAll", query = "SELECT p FROM Puljer p"),
    @NamedQuery(name = "Puljer.findByValgfagid", query = "SELECT p FROM Puljer p WHERE p.valgfagid = :valgfagid"),
    @NamedQuery(name = "Puljer.findByPulje", query = "SELECT p FROM Puljer p WHERE p.pulje = :pulje")})
public class Puljer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALGFAGID")
    private Integer valgfagid;
    @Size(max = 20)
    @Column(name = "PULJE")
    private String pulje;
    @JoinColumn(name = "VALGFAGID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Valgfag valgfag;

    public Puljer() {
    }

    public Puljer(Integer valgfagid, String pulje) {
        this.valgfagid = valgfagid;
        this.pulje = pulje;
    }

    
    public Puljer(Integer valgfagid) {
        this.valgfagid = valgfagid;
    }

    public Integer getValgfagid() {
        return valgfagid;
    }

    public void setValgfagid(Integer valgfagid) {
        this.valgfagid = valgfagid;
    }

    public String getPulje() {
        return pulje;
    }

    public void setPulje(String pulje) {
        this.pulje = pulje;
    }

    public Valgfag getValgfag() {
        return valgfag;
    }

    public void setValgfag(Valgfag valgfag) {
        this.valgfag = valgfag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valgfagid != null ? valgfagid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puljer)) {
            return false;
        }
        Puljer other = (Puljer) object;
        if ((this.valgfagid == null && other.valgfagid != null) || (this.valgfagid != null && !this.valgfagid.equals(other.valgfagid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Puljer[ valgfagid=" + valgfagid + " ]";
    }
    
}
