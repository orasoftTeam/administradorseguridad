/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.facade;

import com.admin.entity.SegMenusXModulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAP
 */
@Stateless
public class SegMenusXModuloFacade extends AbstractFacade<SegMenusXModulo> {

    @PersistenceContext(unitName = "seguridadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegMenusXModuloFacade() {
        super(SegMenusXModulo.class);
    }
    
}
