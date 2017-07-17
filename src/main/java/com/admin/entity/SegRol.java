/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "SEG_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRol.findAll", query = "SELECT s FROM SegRol s"),
    @NamedQuery(name = "SegRol.findByIdrol", query = "SELECT s FROM SegRol s WHERE s.idrol = :idrol"),
    @NamedQuery(name = "SegRol.findByNombrerol", query = "SELECT s FROM SegRol s WHERE s.nombrerol = :nombrerol")})
public class SegRol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROL")
    private BigDecimal idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREROL")
    private String nombrerol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrol")
    private List<SegRolusuario> segRolusuarioList;

    public SegRol() {
    }

    public SegRol(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public SegRol(BigDecimal idrol, String nombrerol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
    }

    public BigDecimal getIdrol() {
        return idrol;
    }

    public void setIdrol(BigDecimal idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    @XmlTransient
    public List<SegRolusuario> getSegRolusuarioList() {
        return segRolusuarioList;
    }

    public void setSegRolusuarioList(List<SegRolusuario> segRolusuarioList) {
        this.segRolusuarioList = segRolusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRol)) {
            return false;
        }
        SegRol other = (SegRol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegRol[ idrol=" + idrol + " ]";
    }
    
}
