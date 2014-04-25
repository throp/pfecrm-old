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
import com.pfe.crm.dao.admin.ChemicalDAO;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.domain.entity.Chemical;
import com.pfe.crm.domain.entity.FireExtinguisher;

/**
 * DeleteChemicalAction.java
 * 
 * Delete a chemical, so long as no fire extinguisher is related to it.
 * 
 * @author Ben Northrop Jun 6, 2007
 * 
 */
public class DeleteChemicalAction extends BaseAction
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
        int chemicalId = getMap().getInt("chemicalId");
        FireExtinguisherDAO fireExtinguisherDAO = new FireExtinguisherDAO(
                getSession());
        ChemicalDAO chemicalDAO = new ChemicalDAO(getSession());
        Chemical chemical = chemicalDAO.get(chemicalId);

        Collection<FireExtinguisher> fireExtinguishers = fireExtinguisherDAO
                .retrieveFireExtinguishersForChemical(chemical);
        if (fireExtinguishers == null || fireExtinguishers.isEmpty()) {
            chemicalDAO.delete(chemical);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deleted chemical: " + chemical.getName());
            saveActionLog("Deleted chemical: " + chemical.getName());
        } else {
            chemical.setIsActive(Boolean.FALSE);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deactivated chemical: " + chemical.getName());
            saveActionLog("Deactivated chemical: " + chemical.getName());
        }
        ListManager.getInstance().refreshChemicals();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}
