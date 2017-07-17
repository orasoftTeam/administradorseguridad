package com.admin.controller;

import com.admin.entity.SegTelefonoxcompany;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegTelefonoxcompanyFacade;

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

@Named("segTelefonoxcompanyController")
@SessionScoped
public class SegTelefonoxcompanyController implements Serializable {

    @EJB
    private com.admin.facade.SegTelefonoxcompanyFacade ejbFacade;
    private List<SegTelefonoxcompany> items = null;
    private SegTelefonoxcompany selected;

    public SegTelefonoxcompanyController() {
    }

    public SegTelefonoxcompany getSelected() {
        return selected;
    }

    public void setSelected(SegTelefonoxcompany selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegTelefonoxcompanyFacade getFacade() {
        return ejbFacade;
    }

    public SegTelefonoxcompany prepareCreate() {
        selected = new SegTelefonoxcompany();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegTelefonoxcompanyCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegTelefonoxcompanyUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegTelefonoxcompanyDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegTelefonoxcompany> getItems() {
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

    public SegTelefonoxcompany getSegTelefonoxcompany(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegTelefonoxcompany> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegTelefonoxcompany> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegTelefonoxcompany.class)
    public static class SegTelefonoxcompanyControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegTelefonoxcompanyController controller = (SegTelefonoxcompanyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segTelefonoxcompanyController");
            return controller.getSegTelefonoxcompany(getKey(value));
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
            if (object instanceof SegTelefonoxcompany) {
                SegTelefonoxcompany o = (SegTelefonoxcompany) object;
                return getStringKey(o.getIdtelefonoxcompany());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegTelefonoxcompany.class.getName()});
                return null;
            }
        }

    }

}
