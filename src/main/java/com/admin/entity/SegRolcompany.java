/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_ROLCOMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRolcompany.findAll", query = "SELECT s FROM SegRolcompany s"),
    @NamedQuery(name = "SegRolcompany.findByIdrolcia", query = "SELECT s FROM SegRolcompany s WHERE s.idrolcia = :idrolcia"),
    @NamedQuery(name = "SegRolcompany.findByNombrerolcia", query = "SELECT s FROM SegRolcompany s WHERE s.nombrerolcia = :nombrerolcia"),
    @NamedQuery(name = "SegRolcompany.findByEstadorolcia", query = "SELECT s FROM SegRolcompany s WHERE s.estadorolcia = :estadorolcia")})
public class SegRolcompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ROLCOMPANY_SEQ")
    @SequenceGenerator(name = "ROLCOMPANY_SEQ", sequenceName = "sqe_idrolcompany", allocationSize = 1)
    @Column(name = "IDROLCIA")
    private String idrolcia;
    @Size(max = 60)
    @Column(name = "NOMBREROLCIA")
    private String nombrerolcia;
    @Size(max = 1)
    @Column(name = "ESTADOROLCIA")
    private String estadorolcia;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY")
    @ManyToOne(optional = false)
    private SegCompany idcompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segRolcompany")
    private List<SegModulosXRol> segModulosXRolList;

    public SegRolcompany() {
    }

    public SegRolcompany(String idrolcia) {
        this.idrolcia = idrolcia;
    }

    public String getIdrolcia() {
        return idrolcia;
    }

    public void setIdrolcia(String idrolcia) {
        this.idrolcia = idrolcia;
    }

    public String getNombrerolcia() {
        return nombrerolcia;
    }

    public void setNombrerolcia(String nombrerolcia) {
        this.nombrerolcia = nombrerolcia;
    }

    public String getEstadorolcia() {
        return estadorolcia;
    }

    public void setEstadorolcia(String estadorolcia) {
        this.estadorolcia = estadorolcia;
    }

    public SegCompany getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(SegCompany idcompany) {
        this.idcompany = idcompany;
    }

    @XmlTransient
    public List<SegModulosXRol> getSegModulosXRolList() {
        return segModulosXRolList;
    }

    public void setSegModulosXRolList(List<SegModulosXRol> segModulosXRolList) {
        this.segModulosXRolList = segModulosXRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolcia != null ? idrolcia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRolcompany)) {
            return false;
        }
        SegRolcompany other = (SegRolcompany) object;
        if ((this.idrolcia == null && other.idrolcia != null) || (this.idrolcia != null && !this.idrolcia.equals(other.idrolcia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegRolcompany[ idrolcia=" + idrolcia + " ]";
    }
    
}
