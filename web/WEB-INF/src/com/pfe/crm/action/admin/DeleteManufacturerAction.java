package com.pfe.crm.action.admin;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.dao.admin.ManufacturerDAO;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.Manufacturer;

/**
 * DeleteManufacturerAction.java
 * 
 * Delete or de-activate the manufacturer.
 * 
 * @author Ben Northrop Jun 6, 2007
 * 
 */
public class DeleteManufacturerAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        int manufacturerId = getMap().getInt("manufacturerId");
        FireExtinguisherDAO fireExtinguisherDAO = new FireExtinguisherDAO(
                getSession());
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO(getSession());
        Manufacturer manufacturer = manufacturerDAO.get(manufacturerId);

        Collection<FireExtinguisher> fireExtinguishers = fireExtinguisherDAO
                .retrieveFireExtinguishersForManufacturer(manufacturer);
        if (fireExtinguishers == null || fireExtinguishers.isEmpty()) {
            manufacturerDAO.delete(manufacturer);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deleted manufacturer: "
                            + manufacturer.getName());
            saveActionLog("Deleted manufacturer: " + manufacturer.getName());
        } else {
            manufacturer.setIsActive(Boolean.FALSE);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deactivated manufacturer: "
                            + manufacturer.getName());
            saveActionLog("Deactivated manufacturer: " + manufacturer.getName());
        }
        ListManager.getInstance().refreshManufacturers();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}
