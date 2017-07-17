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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SEG_DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegDepartamento.findAll", query = "SELECT s FROM SegDepartamento s"),
    @NamedQuery(name = "SegDepartamento.findByIddepartamento", query = "SELECT s FROM SegDepartamento s WHERE s.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "SegDepartamento.findByNombredepartamento", query = "SELECT s FROM SegDepartamento s WHERE s.nombredepartamento = :nombredepartamento")})
public class SegDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDEPARTAMENTO")
    private BigDecimal iddepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREDEPARTAMENTO")
    private String nombredepartamento;
    @JoinColumn(name = "IDPAIS", referencedColumnName = "IDPAIS")
    @ManyToOne(optional = false)
    private SegPais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartamento")
    private List<SegMunicipio> segMunicipioList;

    public SegDepartamento() {
    }

    public SegDepartamento(BigDecimal iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public SegDepartamento(BigDecimal iddepartamento, String nombredepartamento) {
        this.iddepartamento = iddepartamento;
        this.nombredepartamento = nombredepartamento;
    }

    public BigDecimal getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(BigDecimal iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public SegPais getIdpais() {
        return idpais;
    }

    public void setIdpais(SegPais idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public List<SegMunicipio> getSegMunicipioList() {
        return segMunicipioList;
    }

    public void setSegMunicipioList(List<SegMunicipio> segMunicipioList) {
        this.segMunicipioList = segMunicipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegDepartamento)) {
            return false;
        }
        SegDepartamento other = (SegDepartamento) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegDepartamento[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
