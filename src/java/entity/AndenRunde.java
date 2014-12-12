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
 * @author Hanan
 */
@Entity
@Table(name = "ANDEN_RUNDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AndenRunde.findAll", query = "SELECT a FROM AndenRunde a"),
    @NamedQuery(name = "AndenRunde.findByStudentid", query = "SELECT a FROM AndenRunde a WHERE a.studentid = :studentid")})
public class AndenRunde implements Serializable {
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

    public AndenRunde() {
    }

    public AndenRunde(Integer studentid) {
        this.studentid = studentid;
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
        if (!(object instanceof AndenRunde)) {
            return false;
        }
        AndenRunde other = (AndenRunde) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AndenRunde[ studentid=" + studentid + " ]";
    }
    
}
