package com.pfe.crm.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.ListManager;

/**
 * ViewAllOfficesAction.java
 * 
 * Retrieve all offices and display
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 4, 2006
 */
public class ViewAllOfficesAction extends BaseAction
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
        Session session = getSession();
        List chemicals = null;

        Query query = session.createQuery("from Office order by name");
        chemicals = query.list();

        ListManager.getInstance().refreshOffices();
        request.setAttribute("offices", chemicals);
        return mapping.findForward("Success");
    }

}
