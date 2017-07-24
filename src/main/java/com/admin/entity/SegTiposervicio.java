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
@Table(name = "SEG_TIPOSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegTiposervicio.findAll", query = "SELECT s FROM SegTiposervicio s"),
    @NamedQuery(name = "SegTiposervicio.findByIdtiposervicio", query = "SELECT s FROM SegTiposervicio s WHERE s.idtiposervicio = :idtiposervicio"),
    @NamedQuery(name = "SegTiposervicio.findByNombretiposervicio", query = "SELECT s FROM SegTiposervicio s WHERE s.nombretiposervicio = :nombretiposervicio")})
public class SegTiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "TIPOSERVICIO_SEQ")
    @SequenceGenerator(name = "TIPOSERVICIO_SEQ", sequenceName = "SQE_IDTIPOSERV", allocationSize = 1)
    @Column(name = "IDTIPOSERVICIO")
    private BigDecimal idtiposervicio;
    //@Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRETIPOSERVICIO")
    private String nombretiposervicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiposervicio")
    private List<SegServicio> segServicioList;

    public SegTiposervicio() {
    }

    public SegTiposervicio(BigDecimal idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public SegTiposervicio(BigDecimal idtiposervicio, String nombretiposervicio) {
        this.idtiposervicio = idtiposervicio;
        this.nombretiposervicio = nombretiposervicio;
    }

    public BigDecimal getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(BigDecimal idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getNombretiposervicio() {
        return nombretiposervicio;
    }

    public void setNombretiposervicio(String nombretiposervicio) {
        this.nombretiposervicio = nombretiposervicio;
    }

    @XmlTransient
    public List<SegServicio> getSegServicioList() {
        return segServicioList;
    }

    public void setSegServicioList(List<SegServicio> segServicioList) {
        this.segServicioList = segServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposervicio != null ? idtiposervicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegTiposervicio)) {
            return false;
        }
        SegTiposervicio other = (SegTiposervicio) object;
        if ((this.idtiposervicio == null && other.idtiposervicio != null) || (this.idtiposervicio != null && !this.idtiposervicio.equals(other.idtiposervicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegTiposervicio[ idtiposervicio=" + idtiposervicio + " ]";
    }
    
}
