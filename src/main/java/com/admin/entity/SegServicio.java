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
@Table(name = "SEG_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegServicio.findAll", query = "SELECT s FROM SegServicio s"),
    @NamedQuery(name = "SegServicio.findByIdservicio", query = "SELECT s FROM SegServicio s WHERE s.idservicio = :idservicio"),
    @NamedQuery(name = "SegServicio.findByNombreservicio", query = "SELECT s FROM SegServicio s WHERE s.nombreservicio = :nombreservicio"),
    @NamedQuery(name = "SegServicio.findByRequisitos", query = "SELECT s FROM SegServicio s WHERE s.requisitos = :requisitos")})
public class SegServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SERVICIO_SEQ")
    @SequenceGenerator(name = "SERVICIO_SEQ", sequenceName = "SQE_IDSERVICIOS", allocationSize = 1)
    @Column(name = "IDSERVICIO")
    private BigDecimal idservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRESERVICIO")
    private String nombreservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REQUISITOS")
    private String requisitos;
    @JoinColumn(name = "IDTIPOSERVICIO", referencedColumnName = "IDTIPOSERVICIO")
    @ManyToOne(optional = false)
    private SegTiposervicio idtiposervicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<SegCompanyxservicio> segCompanyxservicioList;

    public SegServicio() {
    }

    public SegServicio(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public SegServicio(BigDecimal idservicio, String nombreservicio, String requisitos) {
        this.idservicio = idservicio;
        this.nombreservicio = nombreservicio;
        this.requisitos = requisitos;
    }

    public BigDecimal getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public SegTiposervicio getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(SegTiposervicio idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    @XmlTransient
    public List<SegCompanyxservicio> getSegCompanyxservicioList() {
        return segCompanyxservicioList;
    }

    public void setSegCompanyxservicioList(List<SegCompanyxservicio> segCompanyxservicioList) {
        this.segCompanyxservicioList = segCompanyxservicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegServicio)) {
            return false;
        }
        SegServicio other = (SegServicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegServicio[ idservicio=" + idservicio + " ]";
    }
    
}
