/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "SEG_COMPANY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegCompany.findAll", query = "SELECT s FROM SegCompany s"),
    @NamedQuery(name = "SegCompany.findByIdcompany", query = "SELECT s FROM SegCompany s WHERE s.idcompany = :idcompany"),
    @NamedQuery(name = "SegCompany.findByNombrecompany", query = "SELECT s FROM SegCompany s WHERE s.nombrecompany = :nombrecompany"),
    @NamedQuery(name = "SegCompany.findByDireccioncompany", query = "SELECT s FROM SegCompany s WHERE s.direccioncompany = :direccioncompany"),
    @NamedQuery(name = "SegCompany.findByCorreocompany", query = "SELECT s FROM SegCompany s WHERE s.correocompany = :correocompany"),
    @NamedQuery(name = "SegCompany.findByPaginaweb", query = "SELECT s FROM SegCompany s WHERE s.paginaweb = :paginaweb"),
    @NamedQuery(name = "SegCompany.findByNivelcompany", query = "SELECT s FROM SegCompany s WHERE s.nivelcompany = :nivelcompany"),
    @NamedQuery(name = "SegCompany.findByNumerocompany", query = "SELECT s FROM SegCompany s WHERE s.numerocompany = :numerocompany"),
    @NamedQuery(name = "SegCompany.findByRutalogocompany", query = "SELECT s FROM SegCompany s WHERE s.rutalogocompany = :rutalogocompany"),
    @NamedQuery(name = "SegCompany.findByLatitudcompany", query = "SELECT s FROM SegCompany s WHERE s.latitudcompany = :latitudcompany"),
    @NamedQuery(name = "SegCompany.findByLongitudcompany", query = "SELECT s FROM SegCompany s WHERE s.longitudcompany = :longitudcompany"),
    @NamedQuery(name = "SegCompany.findByDiainiciocompany", query = "SELECT s FROM SegCompany s WHERE s.diainiciocompany = :diainiciocompany"),
    @NamedQuery(name = "SegCompany.findByDiafincompany", query = "SELECT s FROM SegCompany s WHERE s.diafincompany = :diafincompany"),
    @NamedQuery(name = "SegCompany.findByHorainiciocompany", query = "SELECT s FROM SegCompany s WHERE s.horainiciocompany = :horainiciocompany"),
    @NamedQuery(name = "SegCompany.findByHorafincompany", query = "SELECT s FROM SegCompany s WHERE s.horafincompany = :horafincompany"),
    @NamedQuery(name = "SegCompany.findByHorainicio2company", query = "SELECT s FROM SegCompany s WHERE s.horainicio2company = :horainicio2company"),
    @NamedQuery(name = "SegCompany.findByHorafin2company", query = "SELECT s FROM SegCompany s WHERE s.horafin2company = :horafin2company"),
    @NamedQuery(name = "SegCompany.findByEstadocompany", query = "SELECT s FROM SegCompany s WHERE s.estadocompany = :estadocompany")})
public class SegCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONSULTORIO_SEQ")
    @SequenceGenerator(name = "CONSULTORIO_SEQ", sequenceName = "SQE_IDCONSULTORIO", allocationSize = 1)
    @Column(name = "IDCOMPANY")
    private BigDecimal idcompany;
//    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRECOMPANY")
    private String nombrecompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCIONCOMPANY")
    private String direccioncompany;
    @Size(max = 100)
    @Column(name = "CORREOCOMPANY")
    private String correocompany;
    @Size(max = 100)
    @Column(name = "PAGINAWEB")
    private String paginaweb;
    @Column(name = "NIVELCOMPANY")
    private BigInteger nivelcompany;
    @Size(max = 5)
    @Column(name = "NUMEROCOMPANY")
    private String numerocompany;
    @Size(max = 255)
    @Column(name = "RUTALOGOCOMPANY")
    private String rutalogocompany;
    @Column(name = "LATITUDCOMPANY")
    private BigDecimal latitudcompany;
    @Column(name = "LONGITUDCOMPANY")
    private BigDecimal longitudcompany;
    @Column(name = "DIAINICIOCOMPANY")
    private BigInteger diainiciocompany;
    @Column(name = "DIAFINCOMPANY")
    private BigInteger diafincompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAINICIOCOMPANY")
    private BigInteger horainiciocompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAFINCOMPANY")
    private BigInteger horafincompany;
    @Column(name = "HORAINICIO2COMPANY")
    private BigInteger horainicio2company;
    @Column(name = "HORAFIN2COMPANY")
    private BigInteger horafin2company;
    @Column(name = "ESTADOCOMPANY")
    private Character estadocompany;
    @Lob
    @Column(name = "VISIONCOMPANY")
    private String visioncompany;
    @Lob
    @Column(name = "MISIONCOMPANY")
    private String misioncompany;
    @Lob
    @Column(name = "DESCRIPCIONCOMPANY")
    private String descripcioncompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcompany")
    private List<SegCompanyxdiasfestivos> segCompanyxdiasfestivosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcompany")
    private List<SegRolcompany> segRolcompanyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segCompany")
    private List<SegUsuarioXCia> segUsuarioXCiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segCompany")
    private List<SegMenusXModulo> segMenusXModuloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segCompany")
    private List<SegModulosXRol> segModulosXRolList;
    @JoinColumn(name = "IDRUBRO", referencedColumnName = "IDRUBRO")
    @ManyToOne(optional = false)
    private SegRubro idrubro;
    @JoinColumn(name = "IDMUNICIPIO", referencedColumnName = "IDMUNICIPIO")
    @ManyToOne(optional = false)
    private SegMunicipio idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcompany")
    private List<SegCompanyxservicio> segCompanyxservicioList;

    public SegCompany() {
    }

    public SegCompany(BigDecimal idcompany) {
        this.idcompany = idcompany;
    }

    public SegCompany(BigDecimal idcompany, String nombrecompany, String direccioncompany, BigInteger horainiciocompany, BigInteger horafincompany) {
        this.idcompany = idcompany;
        this.nombrecompany = nombrecompany;
        this.direccioncompany = direccioncompany;
        this.horainiciocompany = horainiciocompany;
        this.horafincompany = horafincompany;
    }

    public BigDecimal getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(BigDecimal idcompany) {
        this.idcompany = idcompany;
    }

    public String getNombrecompany() {
        return nombrecompany;
    }

    public void setNombrecompany(String nombrecompany) {
        this.nombrecompany = nombrecompany;
    }

    public String getDireccioncompany() {
        return direccioncompany;
    }

    public void setDireccioncompany(String direccioncompany) {
        this.direccioncompany = direccioncompany;
    }

    public String getCorreocompany() {
        return correocompany;
    }

    public void setCorreocompany(String correocompany) {
        this.correocompany = correocompany;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public BigInteger getNivelcompany() {
        return nivelcompany;
    }

    public void setNivelcompany(BigInteger nivelcompany) {
        this.nivelcompany = nivelcompany;
    }

    public String getNumerocompany() {
        return numerocompany;
    }

    public void setNumerocompany(String numerocompany) {
        this.numerocompany = numerocompany;
    }

    public String getRutalogocompany() {
        return rutalogocompany;
    }

    public void setRutalogocompany(String rutalogocompany) {
        this.rutalogocompany = rutalogocompany;
    }

    public BigDecimal getLatitudcompany() {
        return latitudcompany;
    }

    public void setLatitudcompany(BigDecimal latitudcompany) {
        this.latitudcompany = latitudcompany;
    }

    public BigDecimal getLongitudcompany() {
        return longitudcompany;
    }

    public void setLongitudcompany(BigDecimal longitudcompany) {
        this.longitudcompany = longitudcompany;
    }

    public BigInteger getDiainiciocompany() {
        return diainiciocompany;
    }

    public void setDiainiciocompany(BigInteger diainiciocompany) {
        this.diainiciocompany = diainiciocompany;
    }

    public BigInteger getDiafincompany() {
        return diafincompany;
    }

    public void setDiafincompany(BigInteger diafincompany) {
        this.diafincompany = diafincompany;
    }

    public BigInteger getHorainiciocompany() {
        return horainiciocompany;
    }

    public void setHorainiciocompany(BigInteger horainiciocompany) {
        this.horainiciocompany = horainiciocompany;
    }

    public BigInteger getHorafincompany() {
        return horafincompany;
    }

    public void setHorafincompany(BigInteger horafincompany) {
        this.horafincompany = horafincompany;
    }

    public BigInteger getHorainicio2company() {
        return horainicio2company;
    }

    public void setHorainicio2company(BigInteger horainicio2company) {
        this.horainicio2company = horainicio2company;
    }

    public BigInteger getHorafin2company() {
        return horafin2company;
    }

    public void setHorafin2company(BigInteger horafin2company) {
        this.horafin2company = horafin2company;
    }

    public Character getEstadocompany() {
        return estadocompany;
    }

    public void setEstadocompany(Character estadocompany) {
        this.estadocompany = estadocompany;
    }

    public String getVisioncompany() {
        return visioncompany;
    }

    public void setVisioncompany(String visioncompany) {
        this.visioncompany = visioncompany;
    }

    public String getMisioncompany() {
        return misioncompany;
    }

    public void setMisioncompany(String misioncompany) {
        this.misioncompany = misioncompany;
    }

    public String getDescripcioncompany() {
        return descripcioncompany;
    }

    public void setDescripcioncompany(String descripcioncompany) {
        this.descripcioncompany = descripcioncompany;
    }

    @XmlTransient
    public List<SegCompanyxdiasfestivos> getSegCompanyxdiasfestivosList() {
        return segCompanyxdiasfestivosList;
    }

    public void setSegCompanyxdiasfestivosList(List<SegCompanyxdiasfestivos> segCompanyxdiasfestivosList) {
        this.segCompanyxdiasfestivosList = segCompanyxdiasfestivosList;
    }

    @XmlTransient
    public List<SegRolcompany> getSegRolcompanyList() {
        return segRolcompanyList;
    }

    public void setSegRolcompanyList(List<SegRolcompany> segRolcompanyList) {
        this.segRolcompanyList = segRolcompanyList;
    }

    @XmlTransient
    public List<SegUsuarioXCia> getSegUsuarioXCiaList() {
        return segUsuarioXCiaList;
    }

    public void setSegUsuarioXCiaList(List<SegUsuarioXCia> segUsuarioXCiaList) {
        this.segUsuarioXCiaList = segUsuarioXCiaList;
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

    public SegRubro getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(SegRubro idrubro) {
        this.idrubro = idrubro;
    }

    public SegMunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(SegMunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
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
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegCompany)) {
            return false;
        }
        SegCompany other = (SegCompany) object;
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.entity.SegCompany[ idcompany=" + idcompany + " ]";
    }
    
}
