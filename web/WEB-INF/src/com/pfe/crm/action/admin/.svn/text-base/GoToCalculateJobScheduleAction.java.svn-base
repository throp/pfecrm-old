package com.pfe.crm.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.type.Year;

/**
 * GoToCalculateJobScheduleAction.java
 * 
 * Go to the recalculate jobs page.
 * 
 * @author Ben Northrop Dec 8, 2006
 * 
 */
public class GoToCalculateJobScheduleAction extends BaseAction
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
        List<String> years = new ArrayList<String>();
        years.add(Year.thisYear().getName());
        years.add(Year.nextYear().getName());
        request.setAttribute("years", years);
        return mapping.findForward("Success");
    }

}
