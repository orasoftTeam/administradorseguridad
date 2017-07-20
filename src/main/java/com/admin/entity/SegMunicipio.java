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
@Table(name = "SEG_MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegMunicipio.findAll", query = "SELECT s FROM SegMunicipio s"),
    @NamedQuery(name = "SegMunicipio.findByIdmunicipio", query = "SELECT s FROM SegMunicipio s WHERE s.idmunicipio = :idmunicipio"),
    @NamedQuery(name = "SegMunicipio.findByNombremunicipio", query = "SELECT s FROM SegMunicipio s WHERE s.nombremunicipio = :nombremunicipio")})
public class SegMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
//    @Basic(optional = false)
//    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MUNICIPIO_SEQ")
    @SequenceGenerator(name = "MUNICIPIO_SEQ", sequenceName = "SQE_IDMUNICIPIO", allocationSize = 1)
    @Column(name = "IDMUNICIPIO")
    private BigDecimal idmunicipio;
//    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREMUNICIPIO")
    private String nombremunicipio;
    @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO")
    @ManyToOne(optional = false)
    private SegDepartamento iddepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<SegCompany> segCompanyList;

    public SegMunicipio() {
    }

    public SegMunicipio(BigDecimal idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public SegMunicipio(BigDecimal idmunicipio, String nombremunicipio) {
        this.idmunicipio = idmunicipio;
        this.nombremunicipio = nombremunicipio;
    }

    public BigDecimal getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(BigDecimal idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    public SegDepartamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(SegDepartamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @XmlTransient
    public List<SegCompany> getSegCompanyList() {
        return segCompanyList;
    }

    public void setSegCompanyList(List<SegCompany> segCompanyList) {
        this.segCompanyList = segCompanyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMunicipio)) {
            return false;
        }
        SegMunicipio other = (SegMunicipio) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegMunicipio[ idmunicipio=" + idmunicipio + " ]";
    }
    
}
