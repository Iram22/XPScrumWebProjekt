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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "VALGFAG")
@XmlRootElement
//@SequenceGenerator(name = "VFSEQ", sequenceName = "valgfag_number_seq", allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "Valgfag.findAll", query = "SELECT v FROM Valgfag v"),
    @NamedQuery(name = "Valgfag.findById", query = "SELECT v FROM Valgfag v WHERE v.id = :id"),
    @NamedQuery(name = "Valgfag.findByFag", query = "SELECT v FROM Valgfag v WHERE v.fag = :fag"),
    @NamedQuery(name = "Valgfag.findByUnderviser", query = "SELECT v FROM Valgfag v WHERE v.underviser = :underviser"),
    @NamedQuery(name = "Valgfag.findByBeskrivelse", query = "SELECT v FROM Valgfag v WHERE v.beskrivelse = :beskrivelse")})

public class Valgfag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(generator = "VFSEQ", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 20)
    @Column(name = "FAG")
    private String fag;
    @Size(max = 30)
    @Column(name = "UNDERVISER")
    private String underviser;
    @Size(max = 500)
    @Column(name = "BESKRIVELSE")
    private String beskrivelse;

    public Valgfag() {
    }
    
    public Valgfag(int id, String titel, String underviser, String beskrivelse){
        this.id = id;
        this.fag = titel;
        this.underviser = underviser;
        this.beskrivelse = beskrivelse;
        
    }

    public Valgfag(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFag() {
        return fag;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }

    public String getUnderviser() {
        return underviser;
    }

    public void setUnderviser(String underviser) {
        this.underviser = underviser;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valgfag)) {
            return false;
        }
        Valgfag other = (Valgfag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Valgfag[ id=" + id + " ]";
    }
    
}
