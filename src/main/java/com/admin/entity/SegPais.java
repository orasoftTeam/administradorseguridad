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
@Table(name = "SEG_PAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPais.findAll", query = "SELECT s FROM SegPais s"),
    @NamedQuery(name = "SegPais.findByIdpais", query = "SELECT s FROM SegPais s WHERE s.idpais = :idpais"),
    @NamedQuery(name = "SegPais.findByNombrepais", query = "SELECT s FROM SegPais s WHERE s.nombrepais = :nombrepais")})
public class SegPais implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPAIS")
    private BigDecimal idpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREPAIS")
    private String nombrepais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpais")
    private List<SegDepartamento> segDepartamentoList;

    public SegPais() {
    }

    public SegPais(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public SegPais(BigDecimal idpais, String nombrepais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
    }

    public BigDecimal getIdpais() {
        return idpais;
    }

    public void setIdpais(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @XmlTransient
    public List<SegDepartamento> getSegDepartamentoList() {
        return segDepartamentoList;
    }

    public void setSegDepartamentoList(List<SegDepartamento> segDepartamentoList) {
        this.segDepartamentoList = segDepartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPais)) {
            return false;
        }
        SegPais other = (SegPais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegPais[ idpais=" + idpais + " ]";
    }
    
}
