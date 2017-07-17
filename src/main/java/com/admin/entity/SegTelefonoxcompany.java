/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_TELEFONOXCOMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegTelefonoxcompany.findAll", query = "SELECT s FROM SegTelefonoxcompany s"),
    @NamedQuery(name = "SegTelefonoxcompany.findByIdtelefonoxcompany", query = "SELECT s FROM SegTelefonoxcompany s WHERE s.idtelefonoxcompany = :idtelefonoxcompany"),
    @NamedQuery(name = "SegTelefonoxcompany.findByIdcompany", query = "SELECT s FROM SegTelefonoxcompany s WHERE s.idcompany = :idcompany"),
    @NamedQuery(name = "SegTelefonoxcompany.findByNumerotelefono", query = "SELECT s FROM SegTelefonoxcompany s WHERE s.numerotelefono = :numerotelefono")})
public class SegTelefonoxcompany implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTELEFONOXCOMPANY")
    private BigDecimal idtelefonoxcompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPANY")
    private BigInteger idcompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMEROTELEFONO")
    private String numerotelefono;

    public SegTelefonoxcompany() {
    }

    public SegTelefonoxcompany(BigDecimal idtelefonoxcompany) {
        this.idtelefonoxcompany = idtelefonoxcompany;
    }

    public SegTelefonoxcompany(BigDecimal idtelefonoxcompany, BigInteger idcompany, String numerotelefono) {
        this.idtelefonoxcompany = idtelefonoxcompany;
        this.idcompany = idcompany;
        this.numerotelefono = numerotelefono;
    }

    public BigDecimal getIdtelefonoxcompany() {
        return idtelefonoxcompany;
    }

    public void setIdtelefonoxcompany(BigDecimal idtelefonoxcompany) {
        this.idtelefonoxcompany = idtelefonoxcompany;
    }

    public BigInteger getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(BigInteger idcompany) {
        this.idcompany = idcompany;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefonoxcompany != null ? idtelefonoxcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegTelefonoxcompany)) {
            return false;
        }
        SegTelefonoxcompany other = (SegTelefonoxcompany) object;
        if ((this.idtelefonoxcompany == null && other.idtelefonoxcompany != null) || (this.idtelefonoxcompany != null && !this.idtelefonoxcompany.equals(other.idtelefonoxcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegTelefonoxcompany[ idtelefonoxcompany=" + idtelefonoxcompany + " ]";
    }
    
}
