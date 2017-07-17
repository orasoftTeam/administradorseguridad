/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_USUARIO_X_CIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuarioXCia.findAll", query = "SELECT s FROM SegUsuarioXCia s"),
    @NamedQuery(name = "SegUsuarioXCia.findByIdcompany", query = "SELECT s FROM SegUsuarioXCia s WHERE s.segUsuarioXCiaPK.idcompany = :idcompany"),
    @NamedQuery(name = "SegUsuarioXCia.findByIdusuario", query = "SELECT s FROM SegUsuarioXCia s WHERE s.segUsuarioXCiaPK.idusuario = :idusuario"),
    @NamedQuery(name = "SegUsuarioXCia.findByNombreUsuario", query = "SELECT s FROM SegUsuarioXCia s WHERE s.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "SegUsuarioXCia.findByStatus", query = "SELECT s FROM SegUsuarioXCia s WHERE s.status = :status")})
public class SegUsuarioXCia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegUsuarioXCiaPK segUsuarioXCiaPK;
    @Size(max = 100)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegCompany segCompany;

    public SegUsuarioXCia() {
    }

    public SegUsuarioXCia(SegUsuarioXCiaPK segUsuarioXCiaPK) {
        this.segUsuarioXCiaPK = segUsuarioXCiaPK;
    }

    public SegUsuarioXCia(BigInteger idcompany, BigInteger idusuario) {
        this.segUsuarioXCiaPK = new SegUsuarioXCiaPK(idcompany, idusuario);
    }

    public SegUsuarioXCiaPK getSegUsuarioXCiaPK() {
        return segUsuarioXCiaPK;
    }

    public void setSegUsuarioXCiaPK(SegUsuarioXCiaPK segUsuarioXCiaPK) {
        this.segUsuarioXCiaPK = segUsuarioXCiaPK;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegCompany getSegCompany() {
        return segCompany;
    }

    public void setSegCompany(SegCompany segCompany) {
        this.segCompany = segCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioXCiaPK != null ? segUsuarioXCiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioXCia)) {
            return false;
        }
        SegUsuarioXCia other = (SegUsuarioXCia) object;
        if ((this.segUsuarioXCiaPK == null && other.segUsuarioXCiaPK != null) || (this.segUsuarioXCiaPK != null && !this.segUsuarioXCiaPK.equals(other.segUsuarioXCiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegUsuarioXCia[ segUsuarioXCiaPK=" + segUsuarioXCiaPK + " ]";
    }
    
}
