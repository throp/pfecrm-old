package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Customer;

/**
 * GoToAddLocationAction.java
 * 
 * Go to the add location screen.
 * 
 * @author Ben Northrop
 * Nov 3, 2006
 *
 */
public class GoToAddLocationAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        int customerId = getMap().getInt("customerId");
        Customer customer = (Customer) getSession().get(Customer.class, new Integer(customerId));
        request.getSession().setAttribute("customer", customer);
        return mapping.findForward("Success");
    }

}
