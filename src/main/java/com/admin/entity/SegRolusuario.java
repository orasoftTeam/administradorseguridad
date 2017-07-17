/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_ROLUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRolusuario.findAll", query = "SELECT s FROM SegRolusuario s"),
    @NamedQuery(name = "SegRolusuario.findByIdrolusuario", query = "SELECT s FROM SegRolusuario s WHERE s.idrolusuario = :idrolusuario")})
public class SegRolusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROLUSUARIO")
    private BigDecimal idrolusuario;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private SegUsuario idusuario;
    @JoinColumn(name = "IDROL", referencedColumnName = "IDROL")
    @ManyToOne(optional = false)
    private SegRol idrol;

    public SegRolusuario() {
    }

    public SegRolusuario(BigDecimal idrolusuario) {
        this.idrolusuario = idrolusuario;
    }

    public BigDecimal getIdrolusuario() {
        return idrolusuario;
    }

    public void setIdrolusuario(BigDecimal idrolusuario) {
        this.idrolusuario = idrolusuario;
    }

    public SegUsuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(SegUsuario idusuario) {
        this.idusuario = idusuario;
    }

    public SegRol getIdrol() {
        return idrol;
    }

    public void setIdrol(SegRol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolusuario != null ? idrolusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRolusuario)) {
            return false;
        }
        SegRolusuario other = (SegRolusuario) object;
        if ((this.idrolusuario == null && other.idrolusuario != null) || (this.idrolusuario != null && !this.idrolusuario.equals(other.idrolusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegRolusuario[ idrolusuario=" + idrolusuario + " ]";
    }
    
}
