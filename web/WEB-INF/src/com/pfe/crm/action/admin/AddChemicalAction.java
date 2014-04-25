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
import com.pfe.crm.domain.entity.Chemical;

/**
 * AddChemicalAction.java
 * 
 * Add a chemical type.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 3, 2006
 */
public class AddChemicalAction extends BaseAction
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
        Session session = getSession();
        final String name = map.getString("name");
        String abbreviation = map.getString("abbreviation");
        Chemical chemical = new Chemical();
        chemical.setName(name);
        chemical.setAbbreviation(abbreviation);
        chemical.setIsActive(Boolean.TRUE);

        session.save(chemical);

        saveActionLog("Added chemical: " + name);

        ListManager.getInstance().refreshChemicals();
        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        return redirect;
    }
}
