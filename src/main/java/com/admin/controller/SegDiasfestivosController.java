package com.admin.controller;

import com.admin.entity.SegDiasfestivos;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegDiasfestivosFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("segDiasfestivosController")
@SessionScoped
public class SegDiasfestivosController implements Serializable {

    @EJB
    private com.admin.facade.SegDiasfestivosFacade ejbFacade;
    private List<SegDiasfestivos> items = null;
    private SegDiasfestivos selected;

    public SegDiasfestivosController() {
    }

    public SegDiasfestivos getSelected() {
        return selected;
    }

    public void setSelected(SegDiasfestivos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegDiasfestivosFacade getFacade() {
        return ejbFacade;
    }

    public SegDiasfestivos prepareCreate() {
        selected = new SegDiasfestivos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegDiasfestivosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegDiasfestivosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegDiasfestivosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegDiasfestivos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public SegDiasfestivos getSegDiasfestivos(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegDiasfestivos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegDiasfestivos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegDiasfestivos.class)
    public static class SegDiasfestivosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegDiasfestivosController controller = (SegDiasfestivosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segDiasfestivosController");
            return controller.getSegDiasfestivos(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegDiasfestivos) {
                SegDiasfestivos o = (SegDiasfestivos) object;
                return getStringKey(o.getIddiafestivos());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegDiasfestivos.class.getName()});
                return null;
            }
        }

    }

}
