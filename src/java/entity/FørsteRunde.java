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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Iram
 */
@Entity
@Table(name = "F\u00d8RSTE_RUNDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FørsteRunde.findAll", query = "SELECT f FROM FørsteRunde f"),
     @NamedQuery(name = "FørsteRunde.findCount1", query = "Select distinct((Select count(r.førstePrioriteta) from FørsteRunde r where r.førstePrioriteta = :førstePrioriteta )+ (Select count(r.førstePrioritetb) from FørsteRunde r where r.førstePrioritetb = :førstePrioriteta)) from FørsteRunde r"),
    @NamedQuery(name = "FørsteRunde.findCount2", query = "Select distinct((Select count(r.andenPrioriteta) from FørsteRunde r where r.andenPrioriteta = :andenPrioriteta )+ (Select count(r.andenPrioritetb) from FørsteRunde r where r.andenPrioritetb = :andenPrioriteta)) from FørsteRunde r"),
    @NamedQuery(name = "FørsteRunde.findByStudentid", query = "SELECT f FROM FørsteRunde f WHERE f.studentid = :studentid")})
public class FørsteRunde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private Integer studentid;
    @JoinColumn(name = "F\u00d8RSTE_PRIORITETA", referencedColumnName = "ID")
    @ManyToOne
    private Valgfag førstePrioriteta;
    @JoinColumn(name = "ANDEN_PRIORITETA", referencedColumnName = "ID")
    @ManyToOne
    private Valgfag andenPrioriteta;
    @JoinColumn(name = "F\u00d8RSTE_PRIORITETB", referencedColumnName = "ID")
    @ManyToOne
    private Valgfag førstePrioritetb;
    @JoinColumn(name = "ANDEN_PRIORITETB", referencedColumnName = "ID")
    @ManyToOne
    private Valgfag andenPrioritetb;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Student student;

    public FørsteRunde() {
    }

    public FørsteRunde(Integer studentid) {
        this.studentid = studentid;
    }

    public FørsteRunde(Integer studentid, Valgfag førstePrioriteta, Valgfag andenPrioriteta, Valgfag førstePrioritetb, Valgfag andenPrioritetb)
    {
        this.studentid = studentid;
        this.førstePrioriteta = førstePrioriteta;
        this.andenPrioriteta = andenPrioriteta;
        this.førstePrioritetb = førstePrioritetb;
        this.andenPrioritetb = andenPrioritetb;
    }
    
    
    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Valgfag getFørstePrioriteta() {
        return førstePrioriteta;
    }

    public void setFørstePrioriteta(Valgfag førstePrioriteta) {
        this.førstePrioriteta = førstePrioriteta;
    }

    public Valgfag getAndenPrioriteta() {
        return andenPrioriteta;
    }

    public void setAndenPrioriteta(Valgfag andenPrioriteta) {
        this.andenPrioriteta = andenPrioriteta;
    }

    public Valgfag getFørstePrioritetb() {
        return førstePrioritetb;
    }

    public void setFørstePrioritetb(Valgfag førstePrioritetb) {
        this.førstePrioritetb = førstePrioritetb;
    }

    public Valgfag getAndenPrioritetb() {
        return andenPrioritetb;
    }

    public void setAndenPrioritetb(Valgfag andenPrioritetb) {
        this.andenPrioritetb = andenPrioritetb;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FørsteRunde)) {
            return false;
        }
        FørsteRunde other = (FørsteRunde) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.F\u00f8rsteRunde[ studentid=" + studentid + " ]";
    }
    
}
