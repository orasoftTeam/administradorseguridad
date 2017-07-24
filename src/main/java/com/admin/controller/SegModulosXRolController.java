package com.admin.controller;

import com.admin.entity.SegModulosXRol;
import com.admin.util.JsfUtil;
import com.admin.util.JsfUtil.PersistAction;
import com.admin.facade.SegModulosXRolFacade;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Named("segModulosXRolController")
@SessionScoped
public class SegModulosXRolController implements Serializable {

    @EJB
    private com.admin.facade.SegModulosXRolFacade ejbFacade;
    private List<SegModulosXRol> items = null;
    private SegModulosXRol selected;

    public SegModulosXRolController() {
    }

    public SegModulosXRol getSelected() {
        return selected;
    }

    public void setSelected(SegModulosXRol selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSegModulosXRolPK().setIdmodulo(selected.getSegMntoModulos().getIdmodulo());
        selected.getSegModulosXRolPK().setIdcompany(selected.getSegCompany().getIdcompany().toBigInteger());
        selected.getSegModulosXRolPK().setIdrol(selected.getSegRol().getIdrol());
    }

    protected void initializeEmbeddableKey() {
        selected.setSegModulosXRolPK(new com.admin.entity.SegModulosXRolPK());
    }

    private SegModulosXRolFacade getFacade() {
        return ejbFacade;
    }

    public SegModulosXRol prepareCreate() {
        selected = new SegModulosXRol();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegModulosXRolCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegModulosXRolUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegModulosXRolDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegModulosXRol> getItems() {
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

    public SegModulosXRol getSegModulosXRol(com.admin.entity.SegModulosXRolPK id) {
        return getFacade().find(id);
    }

    public List<SegModulosXRol> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegModulosXRol> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegModulosXRol.class)
    public static class SegModulosXRolControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegModulosXRolController controller = (SegModulosXRolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segModulosXRolController");
            return controller.getSegModulosXRol(getKey(value));
        }

        com.admin.entity.SegModulosXRolPK getKey(String value) {
            com.admin.entity.SegModulosXRolPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.admin.entity.SegModulosXRolPK();
            key.setIdcompany(new BigInteger(values[0]));
            key.setIdrol(new BigDecimal(values[1]));
            key.setIdmodulo(values[2]);
            return key;
        }

        String getStringKey(com.admin.entity.SegModulosXRolPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdcompany());
            sb.append(SEPARATOR);
            sb.append(value.getIdrol());
            sb.append(SEPARATOR);
            sb.append(value.getIdmodulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegModulosXRol) {
                SegModulosXRol o = (SegModulosXRol) object;
                return getStringKey(o.getSegModulosXRolPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegModulosXRol.class.getName()});
                return null;
            }
        }

    }

}