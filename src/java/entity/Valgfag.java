/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hanan
 */
@Entity
@Table(name = "VALGFAG")
@XmlRootElement
@SequenceGenerator(name = "VFSEQ", sequenceName = "valgfag_number_seq")
@NamedQueries(
        {
            @NamedQuery(name = "Valgfag.findAll", query = "SELECT v FROM Valgfag v"),
            @NamedQuery(name = "Valgfag.findById", query = "SELECT v FROM Valgfag v WHERE v.id = :id"),
            @NamedQuery(name = "Valgfag.findByFag", query = "SELECT v FROM Valgfag v WHERE v.fag = :fag"),
            @NamedQuery(name = "Valgfag.findByPrioriteter", query = "SELECT v FROM Valgfag v WHERE v.fag IN :fag")})
public class Valgfag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "VFSEQ", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "FAG")
    private String fag;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "valgfag")
    private Puljer puljer;
    @OneToMany(mappedBy = "f\u00f8rstePrioriteta")
    private Collection<FørsteRunde> førsteRundeCollection;
    @OneToMany(mappedBy = "andenPrioriteta")
    private Collection<FørsteRunde> førsteRundeCollection1;
    @OneToMany(mappedBy = "f\u00f8rstePrioritetb")
    private Collection<FørsteRunde> førsteRundeCollection2;
    @OneToMany(mappedBy = "andenPrioritetb")
    private Collection<FørsteRunde> førsteRundeCollection3;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "valgfag")
    private Udvalgtefag1runde udvalgtefag1runde;
    @OneToMany(mappedBy = "f\u00f8rstePrioriteta")
    private Collection<AndenRunde> andenRundeCollection;
    @OneToMany(mappedBy = "andenPrioriteta")
    private Collection<AndenRunde> andenRundeCollection1;
    @OneToMany(mappedBy = "f\u00f8rstePrioritetb")
    private Collection<AndenRunde> andenRundeCollection2;
    @OneToMany(mappedBy = "andenPrioritetb")
    private Collection<AndenRunde> andenRundeCollection3;

    public Valgfag() {
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

    public Puljer getPuljer() {
        return puljer;
    }

    public void setPuljer(Puljer puljer) {
        this.puljer = puljer;
    }

    @XmlTransient
    public Collection<FørsteRunde> getFørsteRundeCollection() {
        return førsteRundeCollection;
    }

    public void setFørsteRundeCollection(Collection<FørsteRunde> førsteRundeCollection) {
        this.førsteRundeCollection = førsteRundeCollection;
    }

    @XmlTransient
    public Collection<FørsteRunde> getFørsteRundeCollection1() {
        return førsteRundeCollection1;
    }

    public void setFørsteRundeCollection1(Collection<FørsteRunde> førsteRundeCollection1) {
        this.førsteRundeCollection1 = førsteRundeCollection1;
    }

    @XmlTransient
    public Collection<FørsteRunde> getFørsteRundeCollection2() {
        return førsteRundeCollection2;
    }

    public void setFørsteRundeCollection2(Collection<FørsteRunde> førsteRundeCollection2) {
        this.førsteRundeCollection2 = førsteRundeCollection2;
    }

    @XmlTransient
    public Collection<FørsteRunde> getFørsteRundeCollection3() {
        return førsteRundeCollection3;
    }

    public void setFørsteRundeCollection3(Collection<FørsteRunde> førsteRundeCollection3) {
        this.førsteRundeCollection3 = førsteRundeCollection3;
    }

    public Udvalgtefag1runde getUdvalgtefag1runde() {
        return udvalgtefag1runde;
    }

    public void setUdvalgtefag1runde(Udvalgtefag1runde udvalgtefag1runde) {
        this.udvalgtefag1runde = udvalgtefag1runde;
    }

    @XmlTransient
    public Collection<AndenRunde> getAndenRundeCollection() {
        return andenRundeCollection;
    }

    public void setAndenRundeCollection(Collection<AndenRunde> andenRundeCollection) {
        this.andenRundeCollection = andenRundeCollection;
    }

    @XmlTransient
    public Collection<AndenRunde> getAndenRundeCollection1() {
        return andenRundeCollection1;
    }

    public void setAndenRundeCollection1(Collection<AndenRunde> andenRundeCollection1) {
        this.andenRundeCollection1 = andenRundeCollection1;
    }

    @XmlTransient
    public Collection<AndenRunde> getAndenRundeCollection2() {
        return andenRundeCollection2;
    }

    public void setAndenRundeCollection2(Collection<AndenRunde> andenRundeCollection2) {
        this.andenRundeCollection2 = andenRundeCollection2;
    }

    @XmlTransient
    public Collection<AndenRunde> getAndenRundeCollection3() {
        return andenRundeCollection3;
    }

    public void setAndenRundeCollection3(Collection<AndenRunde> andenRundeCollection3) {
        this.andenRundeCollection3 = andenRundeCollection3;
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
