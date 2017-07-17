package com.admin.controller;

import com.admin.entity.SegCompanyxdiasfestivos;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegCompanyxdiasfestivosFacade;

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

@Named("segCompanyxdiasfestivosController")
@SessionScoped
public class SegCompanyxdiasfestivosController implements Serializable {

    @EJB
    private com.admin.facade.SegCompanyxdiasfestivosFacade ejbFacade;
    private List<SegCompanyxdiasfestivos> items = null;
    private SegCompanyxdiasfestivos selected;

    public SegCompanyxdiasfestivosController() {
    }

    public SegCompanyxdiasfestivos getSelected() {
        return selected;
    }

    public void setSelected(SegCompanyxdiasfestivos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegCompanyxdiasfestivosFacade getFacade() {
        return ejbFacade;
    }

    public SegCompanyxdiasfestivos prepareCreate() {
        selected = new SegCompanyxdiasfestivos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegCompanyxdiasfestivosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegCompanyxdiasfestivosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegCompanyxdiasfestivosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegCompanyxdiasfestivos> getItems() {
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

    public SegCompanyxdiasfestivos getSegCompanyxdiasfestivos(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegCompanyxdiasfestivos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegCompanyxdiasfestivos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegCompanyxdiasfestivos.class)
    public static class SegCompanyxdiasfestivosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegCompanyxdiasfestivosController controller = (SegCompanyxdiasfestivosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segCompanyxdiasfestivosController");
            return controller.getSegCompanyxdiasfestivos(getKey(value));
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
            if (object instanceof SegCompanyxdiasfestivos) {
                SegCompanyxdiasfestivos o = (SegCompanyxdiasfestivos) object;
                return getStringKey(o.getIdcompanyxdiafestivos());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegCompanyxdiasfestivos.class.getName()});
                return null;
            }
        }

    }

}
