/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
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
@Table(name = "SEG_MNTO_MODULOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegMntoModulos.findAll", query = "SELECT s FROM SegMntoModulos s"),
    @NamedQuery(name = "SegMntoModulos.findByIdmodulo", query = "SELECT s FROM SegMntoModulos s WHERE s.idmodulo = :idmodulo"),
    @NamedQuery(name = "SegMntoModulos.findByNombremodulo", query = "SELECT s FROM SegMntoModulos s WHERE s.nombremodulo = :nombremodulo"),
    @NamedQuery(name = "SegMntoModulos.findByEstadomodulo", query = "SELECT s FROM SegMntoModulos s WHERE s.estadomodulo = :estadomodulo")})
public class SegMntoModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MODULOS_SEQ")
    @SequenceGenerator(name = "MODULOS_SEQ", sequenceName = "SQE_IDMODULO", allocationSize = 1)
    @Column(name = "IDMODULO")
    private String idmodulo;
    @Size(max = 60)
    @Column(name = "NOMBREMODULO")
    private String nombremodulo;
    @Size(max = 1)
    @Column(name = "ESTADOMODULO")
    private String estadomodulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMntoModulos")
    private List<SegMenusXModulo> segMenusXModuloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMntoModulos")
    private List<SegModulosXRol> segModulosXRolList;
    
    public SegMntoModulos() {
    }

    public SegMntoModulos(String idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(String idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getNombremodulo() {
        return nombremodulo;
    }

    public void setNombremodulo(String nombremodulo) {
        this.nombremodulo = nombremodulo;
    }

    public String getEstadomodulo() {
        return estadomodulo;
    }

    public void setEstadomodulo(String estadomodulo) {
        this.estadomodulo = estadomodulo;
    }

    @XmlTransient
    public List<SegMenusXModulo> getSegMenusXModuloList() {
        return segMenusXModuloList;
    }

    public void setSegMenusXModuloList(List<SegMenusXModulo> segMenusXModuloList) {
        this.segMenusXModuloList = segMenusXModuloList;
    }

    @XmlTransient
    public List<SegModulosXRol> getSegModulosXRolList() {
        return segModulosXRolList;
    }

    public void setSegModulosXRolList(List<SegModulosXRol> segModulosXRolList) {
        this.segModulosXRolList = segModulosXRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodulo != null ? idmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMntoModulos)) {
            return false;
        }
        SegMntoModulos other = (SegMntoModulos) object;
        if ((this.idmodulo == null && other.idmodulo != null) || (this.idmodulo != null && !this.idmodulo.equals(other.idmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegMntoModulos[ idmodulo=" + idmodulo + " ]";
    }
    
}
