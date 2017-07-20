/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.facade;

import com.admin.entity.SegCompany;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAP
 */
@Stateless
public class SegCompanyFacade extends AbstractFacade<SegCompany> {

    @PersistenceContext(unitName = "seguridadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegCompanyFacade() {
        super(SegCompany.class);
    }
    
    public List<SegCompany> obtenerCompanys(){
        Query q= getEntityManager().createNativeQuery("select * from seg_company where estadocompany=?", SegCompany.class);
        q.setParameter(1, 'A');
        List<SegCompany> listTmp= q.getResultList();
        return listTmp.isEmpty()? new ArrayList<SegCompany>(): listTmp;
    }
    
}
