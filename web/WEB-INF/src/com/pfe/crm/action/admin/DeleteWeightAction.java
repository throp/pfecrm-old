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
import com.pfe.crm.dao.admin.WeightDAO;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.Weight;

/**
 * DeleteWeightAction.java
 * 
 * Delete a weight, if possible.
 * 
 * @author Ben Northrop Jun 4, 2007
 * 
 */
public class DeleteWeightAction extends BaseAction
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
        int weightId = getMap().getInt("weightId");
        FireExtinguisherDAO fireExtinguisherDAO = new FireExtinguisherDAO(
                getSession());
        WeightDAO weightDAO = new WeightDAO(getSession());
        Weight weight = weightDAO.get(weightId);

        Collection<FireExtinguisher> fireExtinguishers = fireExtinguisherDAO
                .retrieveFireExtinguishersForWeight(weight);
        if (fireExtinguishers == null || fireExtinguishers.isEmpty()) {
            weightDAO.delete(weight);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deleted weight: " + weight.getPounds()
                            + "lbs.");
            saveActionLog("Deleted employee: " + weight.getPounds());
        } else {
            weight.setIsActive(Boolean.FALSE);
            MessageUtilities.addConfirmationMessage(request,
                    "Successfully deactivated weight: " + weight.getPounds()
                            + "lbs.");
            saveActionLog("Deactivated employee: " + weight.getPounds());
        }
        ListManager.getInstance().refreshWeights();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}
