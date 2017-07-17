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
import javax.validation.constraints.Size;

/**
 *
 * @author LAP
 */
@Embeddable
public class SegMenusXModuloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPANY")
    private BigInteger idcompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "IDMODULO")
    private String idmodulo;

    public SegMenusXModuloPK() {
    }

    public SegMenusXModuloPK(BigInteger idcompany, String idmodulo) {
        this.idcompany = idcompany;
        this.idmodulo = idmodulo;
    }

    public BigInteger getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(BigInteger idcompany) {
        this.idcompany = idcompany;
    }

    public String getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(String idmodulo) {
        this.idmodulo = idmodulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        hash += (idmodulo != null ? idmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenusXModuloPK)) {
            return false;
        }
        SegMenusXModuloPK other = (SegMenusXModuloPK) object;
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        if ((this.idmodulo == null && other.idmodulo != null) || (this.idmodulo != null && !this.idmodulo.equals(other.idmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegMenusXModuloPK[ idcompany=" + idcompany + ", idmodulo=" + idmodulo + " ]";
    }
    
}
