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
@Table(name = "SEG_COMPANYXDIASFESTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegCompanyxdiasfestivos.findAll", query = "SELECT s FROM SegCompanyxdiasfestivos s"),
    @NamedQuery(name = "SegCompanyxdiasfestivos.findByIdcompanyxdiafestivos", query = "SELECT s FROM SegCompanyxdiasfestivos s WHERE s.idcompanyxdiafestivos = :idcompanyxdiafestivos")})
public class SegCompanyxdiasfestivos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPANYXDIAFESTIVOS")
    private BigDecimal idcompanyxdiafestivos;
    @JoinColumn(name = "IDDIAFESTIVOS", referencedColumnName = "IDDIAFESTIVOS")
    @ManyToOne(optional = false)
    private SegDiasfestivos iddiafestivos;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY")
    @ManyToOne(optional = false)
    private SegCompany idcompany;

    public SegCompanyxdiasfestivos() {
    }

    public SegCompanyxdiasfestivos(BigDecimal idcompanyxdiafestivos) {
        this.idcompanyxdiafestivos = idcompanyxdiafestivos;
    }

    public BigDecimal getIdcompanyxdiafestivos() {
        return idcompanyxdiafestivos;
    }

    public void setIdcompanyxdiafestivos(BigDecimal idcompanyxdiafestivos) {
        this.idcompanyxdiafestivos = idcompanyxdiafestivos;
    }

    public SegDiasfestivos getIddiafestivos() {
        return iddiafestivos;
    }

    public void setIddiafestivos(SegDiasfestivos iddiafestivos) {
        this.iddiafestivos = iddiafestivos;
    }

    public SegCompany getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(SegCompany idcompany) {
        this.idcompany = idcompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompanyxdiafestivos != null ? idcompanyxdiafestivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegCompanyxdiasfestivos)) {
            return false;
        }
        SegCompanyxdiasfestivos other = (SegCompanyxdiasfestivos) object;
        if ((this.idcompanyxdiafestivos == null && other.idcompanyxdiafestivos != null) || (this.idcompanyxdiafestivos != null && !this.idcompanyxdiafestivos.equals(other.idcompanyxdiafestivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegCompanyxdiasfestivos[ idcompanyxdiafestivos=" + idcompanyxdiafestivos + " ]";
    }
    
}
