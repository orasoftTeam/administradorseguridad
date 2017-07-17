package com.admin.controller;

import com.admin.entity.SegMenusXModulo;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegMenusXModuloFacade;

import java.io.Serializable;
import java.math.BigInteger;
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

@Named("segMenusXModuloController")
@SessionScoped
public class SegMenusXModuloController implements Serializable {

    @EJB
    private com.admin.facade.SegMenusXModuloFacade ejbFacade;
    private List<SegMenusXModulo> items = null;
    private SegMenusXModulo selected;

    public SegMenusXModuloController() {
    }

    public SegMenusXModulo getSelected() {
        return selected;
    }

    public void setSelected(SegMenusXModulo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSegMenusXModuloPK().setIdmodulo(selected.getSegMntoModulos().getIdmodulo());
        selected.getSegMenusXModuloPK().setIdcompany(selected.getSegCompany().getIdcompany().toBigInteger());
    }

    protected void initializeEmbeddableKey() {
        selected.setSegMenusXModuloPK(new com.admin.entity.SegMenusXModuloPK());
    }

    private SegMenusXModuloFacade getFacade() {
        return ejbFacade;
    }

    public SegMenusXModulo prepareCreate() {
        selected = new SegMenusXModulo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegMenusXModuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegMenusXModuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegMenusXModuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegMenusXModulo> getItems() {
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

    public SegMenusXModulo getSegMenusXModulo(com.admin.entity.SegMenusXModuloPK id) {
        return getFacade().find(id);
    }

    public List<SegMenusXModulo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegMenusXModulo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegMenusXModulo.class)
    public static class SegMenusXModuloControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegMenusXModuloController controller = (SegMenusXModuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segMenusXModuloController");
            return controller.getSegMenusXModulo(getKey(value));
        }

        com.admin.entity.SegMenusXModuloPK getKey(String value) {
            com.admin.entity.SegMenusXModuloPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.admin.entity.SegMenusXModuloPK();
            key.setIdcompany(new BigInteger(values[0]));
            key.setIdmodulo(values[1]);
            return key;
        }

        String getStringKey(com.admin.entity.SegMenusXModuloPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdcompany());
            sb.append(SEPARATOR);
            sb.append(value.getIdmodulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegMenusXModulo) {
                SegMenusXModulo o = (SegMenusXModulo) object;
                return getStringKey(o.getSegMenusXModuloPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegMenusXModulo.class.getName()});
                return null;
            }
        }

    }

}
