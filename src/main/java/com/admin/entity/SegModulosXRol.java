/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "SEG_MODULOS_X_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegModulosXRol.findAll", query = "SELECT s FROM SegModulosXRol s"),
    @NamedQuery(name = "SegModulosXRol.findByIdcompany", query = "SELECT s FROM SegModulosXRol s WHERE s.segModulosXRolPK.idcompany = :idcompany"),
    //@NamedQuery(name = "SegModulosXRol.findByIdrolcia", query = "SELECT s FROM SegModulosXRol s WHERE s.segModulosXRolPK.idrolcia = :idrolcia"),
    @NamedQuery(name = "SegModulosXRol.findByIdmodulo", query = "SELECT s FROM SegModulosXRol s WHERE s.segModulosXRolPK.idmodulo = :idmodulo"),
    @NamedQuery(name = "SegModulosXRol.findBySecuencia", query = "SELECT s FROM SegModulosXRol s WHERE s.secuencia = :secuencia"),
    @NamedQuery(name = "SegModulosXRol.findByNivel", query = "SELECT s FROM SegModulosXRol s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "SegModulosXRol.findByIndforma", query = "SELECT s FROM SegModulosXRol s WHERE s.indforma = :indforma"),
    @NamedQuery(name = "SegModulosXRol.findByOpcion", query = "SELECT s FROM SegModulosXRol s WHERE s.opcion = :opcion"),
    @NamedQuery(name = "SegModulosXRol.findByCodaplic", query = "SELECT s FROM SegModulosXRol s WHERE s.codaplic = :codaplic")})
public class SegModulosXRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegModulosXRolPK segModulosXRolPK;
    @Column(name = "SECUENCIA")
    private BigInteger secuencia;
    @Column(name = "NIVEL")
    private BigInteger nivel;
    @Size(max = 1)
    @Column(name = "INDFORMA")
    private String indforma;
    @Size(max = 8)
    @Column(name = "OPCION")
    private String opcion;
    @Size(max = 30)
    @Column(name = "CODAPLIC")
    private String codaplic;
    @JoinColumn(name = "IDROL", referencedColumnName = "IDROL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegRol segRol;
    @JoinColumn(name = "IDMODULO", referencedColumnName = "IDMODULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegMntoModulos segMntoModulos;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegCompany segCompany;

    public SegModulosXRol() {
    }

    public SegModulosXRol(SegModulosXRolPK segModulosXRolPK) {
        this.segModulosXRolPK = segModulosXRolPK;
    }

    public SegModulosXRol(BigInteger idcompany, BigDecimal idrol, String idmodulo) {
        this.segModulosXRolPK = new SegModulosXRolPK(idcompany, idrol, idmodulo);
    }

    public SegModulosXRolPK getSegModulosXRolPK() {
        return segModulosXRolPK;
    }

    public void setSegModulosXRolPK(SegModulosXRolPK segModulosXRolPK) {
        this.segModulosXRolPK = segModulosXRolPK;
    }

    public BigInteger getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigInteger secuencia) {
        this.secuencia = secuencia;
    }

    public BigInteger getNivel() {
        return nivel;
    }

    public void setNivel(BigInteger nivel) {
        this.nivel = nivel;
    }

    public String getIndforma() {
        return indforma;
    }

    public void setIndforma(String indforma) {
        this.indforma = indforma;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getCodaplic() {
        return codaplic;
    }

    public void setCodaplic(String codaplic) {
        this.codaplic = codaplic;
    }

    public SegRol getSegRol() {
        return segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
    }

    public SegMntoModulos getSegMntoModulos() {
        return segMntoModulos;
    }

    public void setSegMntoModulos(SegMntoModulos segMntoModulos) {
        this.segMntoModulos = segMntoModulos;
    }

    public SegCompany getSegCompany() {
        return segCompany;
    }

    public void setSegCompany(SegCompany segCompany) {
        this.segCompany = segCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segModulosXRolPK != null ? segModulosXRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulosXRol)) {
            return false;
        }
        SegModulosXRol other = (SegModulosXRol) object;
        if ((this.segModulosXRolPK == null && other.segModulosXRolPK != null) || (this.segModulosXRolPK != null && !this.segModulosXRolPK.equals(other.segModulosXRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegModulosXRol[ segModulosXRolPK=" + segModulosXRolPK + " ]";
    }
    
}
