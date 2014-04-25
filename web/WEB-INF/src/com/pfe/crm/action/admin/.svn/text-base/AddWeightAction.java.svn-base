package com.pfe.crm.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.domain.entity.Weight;

/**
 * AddWeightAction.java
 * 
 * Add a weight type.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 3, 2006
 */
public class AddWeightAction extends BaseAction
{

    /**
     * @see com.pfe.crm.core.web.BaseAction#subExecute(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        RequestParameterMap map = getMap();

        Weight weight = new Weight();
        weight.setPounds(new Float(map.getFloat("pounds")));
        Session session = getSession();

        session.save(weight);
        saveActionLog("Added weight: " + map.getFloat("pounds"));

        ListManager.getInstance().refreshWeights();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }

}
