package com.admin.controller;

import com.admin.entity.SegUsuarioXCia;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegUsuarioXCiaFacade;

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

@Named("segUsuarioXCiaController")
@SessionScoped
public class SegUsuarioXCiaController implements Serializable {

    @EJB
    private com.admin.facade.SegUsuarioXCiaFacade ejbFacade;
    private List<SegUsuarioXCia> items = null;
    private SegUsuarioXCia selected;

    public SegUsuarioXCiaController() {
    }

    public SegUsuarioXCia getSelected() {
        return selected;
    }

    public void setSelected(SegUsuarioXCia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSegUsuarioXCiaPK().setIdcompany(selected.getSegCompany().getIdcompany().toBigInteger());
        selected.getSegUsuarioXCiaPK().setIdusuario(selected.getSegUsuario().getIdusuario().toBigInteger());
    }

    protected void initializeEmbeddableKey() {
        selected.setSegUsuarioXCiaPK(new com.admin.entity.SegUsuarioXCiaPK());
    }

    private SegUsuarioXCiaFacade getFacade() {
        return ejbFacade;
    }

    public SegUsuarioXCia prepareCreate() {
        selected = new SegUsuarioXCia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegUsuarioXCiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegUsuarioXCiaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegUsuarioXCiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegUsuarioXCia> getItems() {
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

    public SegUsuarioXCia getSegUsuarioXCia(com.admin.entity.SegUsuarioXCiaPK id) {
        return getFacade().find(id);
    }

    public List<SegUsuarioXCia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegUsuarioXCia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegUsuarioXCia.class)
    public static class SegUsuarioXCiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegUsuarioXCiaController controller = (SegUsuarioXCiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segUsuarioXCiaController");
            return controller.getSegUsuarioXCia(getKey(value));
        }

        com.admin.entity.SegUsuarioXCiaPK getKey(String value) {
            com.admin.entity.SegUsuarioXCiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.admin.entity.SegUsuarioXCiaPK();
            key.setIdcompany(new BigInteger(values[0]));
            key.setIdusuario(new BigInteger(values[1]));
            return key;
        }

        String getStringKey(com.admin.entity.SegUsuarioXCiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdcompany());
            sb.append(SEPARATOR);
            sb.append(value.getIdusuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegUsuarioXCia) {
                SegUsuarioXCia o = (SegUsuarioXCia) object;
                return getStringKey(o.getSegUsuarioXCiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegUsuarioXCia.class.getName()});
                return null;
            }
        }

    }

}
