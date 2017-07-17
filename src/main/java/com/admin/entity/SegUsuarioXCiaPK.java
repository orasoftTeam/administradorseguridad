/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LAP
 */
@Embeddable
public class SegUsuarioXCiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPANY")
    private BigInteger idcompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigInteger idusuario;

    public SegUsuarioXCiaPK() {
    }

    public SegUsuarioXCiaPK(BigInteger idcompany, BigInteger idusuario) {
        this.idcompany = idcompany;
        this.idusuario = idusuario;
    }

    public BigInteger getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(BigInteger idcompany) {
        this.idcompany = idcompany;
    }

    public BigInteger getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigInteger idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioXCiaPK)) {
            return false;
        }
        SegUsuarioXCiaPK other = (SegUsuarioXCiaPK) object;
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegUsuarioXCiaPK[ idcompany=" + idcompany + ", idusuario=" + idusuario + " ]";
    }
    
}
