/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.facade;
import com.admin.entity.SegMunicipio;
import com.admin.entity.SegDepartamento;
import com.admin.form.MunicipioForm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
@Stateless
public class SegMunicipioFacade extends AbstractFacade<SegMunicipio> {

    private @Getter @Setter SegDepartamento dep;
    
    
    @PersistenceContext(unitName = "seguridadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegMunicipioFacade() {
        super(SegMunicipio.class);
    }
    
    public boolean agregarMuni(MunicipioForm mnp) {
        boolean flag = true;
        try {
            if (mnp == null) {
                flag = false;
            } else if (mnp.getIdmunicipio()== null) {
                SegMunicipio muni = new SegMunicipio();
                muni.setIddepartamento(dep);
                muni.setNombremunicipio(mnp.getNombremunicipio().toUpperCase());
                create(muni);
                //flag = false;
            } else {
                SegMunicipio Mun = find(new BigDecimal(mnp.getIdmunicipio()));
                Mun.setNombremunicipio(mnp.getNombremunicipio().toUpperCase());
                edit(Mun);
                //getEntityManager().merge(pais);
                // create(pais);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
   
}
