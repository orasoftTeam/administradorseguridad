/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByIdusuario", query = "SELECT s FROM SegUsuario s WHERE s.idusuario = :idusuario"),
    @NamedQuery(name = "SegUsuario.findByNombreusuario", query = "SELECT s FROM SegUsuario s WHERE s.nombreusuario = :nombreusuario"),
    @NamedQuery(name = "SegUsuario.findByContrausuario", query = "SELECT s FROM SegUsuario s WHERE s.contrausuario = :contrausuario"),
    @NamedQuery(name = "SegUsuario.findByCorreousuario", query = "SELECT s FROM SegUsuario s WHERE s.correousuario = :correousuario"),
    @NamedQuery(name = "SegUsuario.findByFechacreacion", query = "SELECT s FROM SegUsuario s WHERE s.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "SegUsuario.findByEstadousuario", query = "SELECT s FROM SegUsuario s WHERE s.estadousuario = :estadousuario"),
    @NamedQuery(name = "SegUsuario.findByFechafinusuario", query = "SELECT s FROM SegUsuario s WHERE s.fechafinusuario = :fechafinusuario")})
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigDecimal idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CONTRAUSUARIO")
    private String contrausuario;
    @Size(max = 100)
    @Column(name = "CORREOUSUARIO")
    private String correousuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOUSUARIO")
    private Character estadousuario;
    @Column(name = "FECHAFINUSUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<SegRolusuario> segRolusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<SegUsuarioXCia> segUsuarioXCiaList;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public SegUsuario(BigDecimal idusuario, String nombreusuario, String contrausuario, Date fechacreacion, Character estadousuario) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contrausuario = contrausuario;
        this.fechacreacion = fechacreacion;
        this.estadousuario = estadousuario;
    }

    public BigDecimal getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrausuario() {
        return contrausuario;
    }

    public void setContrausuario(String contrausuario) {
        this.contrausuario = contrausuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Character getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(Character estadousuario) {
        this.estadousuario = estadousuario;
    }

    public Date getFechafinusuario() {
        return fechafinusuario;
    }

    public void setFechafinusuario(Date fechafinusuario) {
        this.fechafinusuario = fechafinusuario;
    }

    @XmlTransient
    public List<SegRolusuario> getSegRolusuarioList() {
        return segRolusuarioList;
    }

    public void setSegRolusuarioList(List<SegRolusuario> segRolusuarioList) {
        this.segRolusuarioList = segRolusuarioList;
    }

    @XmlTransient
    public List<SegUsuarioXCia> getSegUsuarioXCiaList() {
        return segUsuarioXCiaList;
    }

    public void setSegUsuarioXCiaList(List<SegUsuarioXCia> segUsuarioXCiaList) {
        this.segUsuarioXCiaList = segUsuarioXCiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
