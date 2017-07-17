/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
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
@Table(name = "SEG_MENUS_X_MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegMenusXModulo.findAll", query = "SELECT s FROM SegMenusXModulo s"),
    @NamedQuery(name = "SegMenusXModulo.findByIdcompany", query = "SELECT s FROM SegMenusXModulo s WHERE s.segMenusXModuloPK.idcompany = :idcompany"),
    @NamedQuery(name = "SegMenusXModulo.findByIdmodulo", query = "SELECT s FROM SegMenusXModulo s WHERE s.segMenusXModuloPK.idmodulo = :idmodulo"),
    @NamedQuery(name = "SegMenusXModulo.findByNombremenu", query = "SELECT s FROM SegMenusXModulo s WHERE s.nombremenu = :nombremenu"),
    @NamedQuery(name = "SegMenusXModulo.findByEstadomenu", query = "SELECT s FROM SegMenusXModulo s WHERE s.estadomenu = :estadomenu"),
    @NamedQuery(name = "SegMenusXModulo.findByNivel", query = "SELECT s FROM SegMenusXModulo s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "SegMenusXModulo.findBySecuencia", query = "SELECT s FROM SegMenusXModulo s WHERE s.secuencia = :secuencia"),
    @NamedQuery(name = "SegMenusXModulo.findByOpcion", query = "SELECT s FROM SegMenusXModulo s WHERE s.opcion = :opcion"),
    @NamedQuery(name = "SegMenusXModulo.findByIndforma", query = "SELECT s FROM SegMenusXModulo s WHERE s.indforma = :indforma"),
    @NamedQuery(name = "SegMenusXModulo.findByCodaplic", query = "SELECT s FROM SegMenusXModulo s WHERE s.codaplic = :codaplic"),
    @NamedQuery(name = "SegMenusXModulo.findByIndaplica", query = "SELECT s FROM SegMenusXModulo s WHERE s.indaplica = :indaplica")})
public class SegMenusXModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegMenusXModuloPK segMenusXModuloPK;
    @Size(max = 60)
    @Column(name = "NOMBREMENU")
    private String nombremenu;
    @Size(max = 1)
    @Column(name = "ESTADOMENU")
    private String estadomenu;
    @Column(name = "NIVEL")
    private BigInteger nivel;
    @Column(name = "SECUENCIA")
    private BigInteger secuencia;
    @Size(max = 30)
    @Column(name = "OPCION")
    private String opcion;
    @Size(max = 30)
    @Column(name = "INDFORMA")
    private String indforma;
    @Size(max = 30)
    @Column(name = "CODAPLIC")
    private String codaplic;
    @Size(max = 30)
    @Column(name = "INDAPLICA")
    private String indaplica;
    @JoinColumn(name = "IDMODULO", referencedColumnName = "IDMODULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegMntoModulos segMntoModulos;
    @JoinColumn(name = "IDCOMPANY", referencedColumnName = "IDCOMPANY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegCompany segCompany;

    public SegMenusXModulo() {
    }

    public SegMenusXModulo(SegMenusXModuloPK segMenusXModuloPK) {
        this.segMenusXModuloPK = segMenusXModuloPK;
    }

    public SegMenusXModulo(BigInteger idcompany, String idmodulo) {
        this.segMenusXModuloPK = new SegMenusXModuloPK(idcompany, idmodulo);
    }

    public SegMenusXModuloPK getSegMenusXModuloPK() {
        return segMenusXModuloPK;
    }

    public void setSegMenusXModuloPK(SegMenusXModuloPK segMenusXModuloPK) {
        this.segMenusXModuloPK = segMenusXModuloPK;
    }

    public String getNombremenu() {
        return nombremenu;
    }

    public void setNombremenu(String nombremenu) {
        this.nombremenu = nombremenu;
    }

    public String getEstadomenu() {
        return estadomenu;
    }

    public void setEstadomenu(String estadomenu) {
        this.estadomenu = estadomenu;
    }

    public BigInteger getNivel() {
        return nivel;
    }

    public void setNivel(BigInteger nivel) {
        this.nivel = nivel;
    }

    public BigInteger getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(BigInteger secuencia) {
        this.secuencia = secuencia;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getIndforma() {
        return indforma;
    }

    public void setIndforma(String indforma) {
        this.indforma = indforma;
    }

    public String getCodaplic() {
        return codaplic;
    }

    public void setCodaplic(String codaplic) {
        this.codaplic = codaplic;
    }

    public String getIndaplica() {
        return indaplica;
    }

    public void setIndaplica(String indaplica) {
        this.indaplica = indaplica;
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
        hash += (segMenusXModuloPK != null ? segMenusXModuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenusXModulo)) {
            return false;
        }
        SegMenusXModulo other = (SegMenusXModulo) object;
        if ((this.segMenusXModuloPK == null && other.segMenusXModuloPK != null) || (this.segMenusXModuloPK != null && !this.segMenusXModuloPK.equals(other.segMenusXModuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegMenusXModulo[ segMenusXModuloPK=" + segMenusXModuloPK + " ]";
    }
    
}
