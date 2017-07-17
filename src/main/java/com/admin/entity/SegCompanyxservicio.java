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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_COMPANYXSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegCompanyxservicio.findAll", query = "SELECT s FROM SegCompanyxservicio s"),
    @NamedQuery(name = "SegCompanyxservicio.findByIdcompanyxservicio", query = "SELECT s FROM SegCompanyxservicio s WHERE s.idcompanyxservicio = :idcompanyxservicio"),
    @NamedQuery(name = "SegCompanyxservicio.findByPreciocomxservicio", query = "SELECT s FROM SegCompanyxservicio s WHERE s.preciocomxservicio = :preciocomxservicio"),
    @NamedQuery(name = "SegCompanyxservicio.findByHorariocomxservicio", query = "SELECT s FROM SegCompanyxservicio s WHERE s.horariocomxservicio = :horariocomxservicio"),
    @NamedQuery(name = "SegCompanyxservicio.findByEstadoservicio", query = "SELECT s FROM SegCompanyxservicio s WHERE s.estadoservicio = :estadoservicio")})
public class SegCompanyxservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPANYXSERVICIO")
    private BigDecimal idcompanyxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOCOMXSERVICIO")
    private BigDecimal preciocomxservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "HORARIOCOMXSERVICIO")
    private String horariocomxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOSERVICIO")
    private Character estadoservicio;
    @JoinColumn(name = "IDSERVICIO", referencedColumnName = "IDSERVICIO")
    @ManyToOne(optional = false)
    private SegServicio idservicio;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY")
    @ManyToOne(optional = false)
    private SegCompany idcompany;

    public SegCompanyxservicio() {
    }

    public SegCompanyxservicio(BigDecimal idcompanyxservicio) {
        this.idcompanyxservicio = idcompanyxservicio;
    }

    public SegCompanyxservicio(BigDecimal idcompanyxservicio, BigDecimal preciocomxservicio, String horariocomxservicio, Character estadoservicio) {
        this.idcompanyxservicio = idcompanyxservicio;
        this.preciocomxservicio = preciocomxservicio;
        this.horariocomxservicio = horariocomxservicio;
        this.estadoservicio = estadoservicio;
    }

    public BigDecimal getIdcompanyxservicio() {
        return idcompanyxservicio;
    }

    public void setIdcompanyxservicio(BigDecimal idcompanyxservicio) {
        this.idcompanyxservicio = idcompanyxservicio;
    }

    public BigDecimal getPreciocomxservicio() {
        return preciocomxservicio;
    }

    public void setPreciocomxservicio(BigDecimal preciocomxservicio) {
        this.preciocomxservicio = preciocomxservicio;
    }

    public String getHorariocomxservicio() {
        return horariocomxservicio;
    }

    public void setHorariocomxservicio(String horariocomxservicio) {
        this.horariocomxservicio = horariocomxservicio;
    }

    public Character getEstadoservicio() {
        return estadoservicio;
    }

    public void setEstadoservicio(Character estadoservicio) {
        this.estadoservicio = estadoservicio;
    }

    public SegServicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(SegServicio idservicio) {
        this.idservicio = idservicio;
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
        hash += (idcompanyxservicio != null ? idcompanyxservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegCompanyxservicio)) {
            return false;
        }
        SegCompanyxservicio other = (SegCompanyxservicio) object;
        if ((this.idcompanyxservicio == null && other.idcompanyxservicio != null) || (this.idcompanyxservicio != null && !this.idcompanyxservicio.equals(other.idcompanyxservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegCompanyxservicio[ idcompanyxservicio=" + idcompanyxservicio + " ]";
    }
    
}
