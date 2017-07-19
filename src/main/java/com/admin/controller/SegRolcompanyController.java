package com.admin.controller;

import com.admin.entity.SegRolcompany;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegRolcompanyFacade;

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

@Named("segRolcompanyController")
@SessionScoped
public class SegRolcompanyController implements Serializable {

    @EJB
    private com.admin.facade.SegRolcompanyFacade ejbFacade;
    private List<SegRolcompany> items = null;
    private SegRolcompany selected;
    

    public SegRolcompanyController() {
    }

    public SegRolcompany getSelected() {
        return selected;
    }

    public void setSelected(SegRolcompany selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegRolcompanyFacade getFacade() {
        return ejbFacade;
    }

    public SegRolcompany prepareCreate() {
        selected = new SegRolcompany();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegRolcompanyCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegRolcompanyUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegRolcompanyDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegRolcompany> getItems() {
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

    public SegRolcompany getSegRolcompany(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<SegRolcompany> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegRolcompany> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegRolcompany.class)
    public static class SegRolcompanyControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegRolcompanyController controller = (SegRolcompanyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segRolcompanyController");
            return controller.getSegRolcompany(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegRolcompany) {
                SegRolcompany o = (SegRolcompany) object;
                return getStringKey(o.getIdrolcia());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegRolcompany.class.getName()});
                return null;
            }
        }

    }

}
