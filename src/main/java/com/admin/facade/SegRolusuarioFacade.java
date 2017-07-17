/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.facade;

import com.admin.entity.SegRolusuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAP
 */
@Stateless
public class SegRolusuarioFacade extends AbstractFacade<SegRolusuario> {

    @PersistenceContext(unitName = "seguridadPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegRolusuarioFacade() {
        super(SegRolusuario.class);
    }
    
}
