package com.pfe.crm.action.scheduling;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.domain.entity.Employee;
import com.pfe.crm.domain.entity.Job;

/**
 * BillJobAction.java
 * 
 * Bill the job, given an amount.
 * 
 * @author Ben Northrop Nov 1, 2006
 * 
 */
public class UpdateJobBillAction extends BaseAction
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
        String billedAmountString = map.getString("invoiceAmount");
        String invoiceNumber = map.getString("invoiceNumber", "");
        int employeeId = map.getInt("employeeId");
        Float billedAmount = Float.parseFloat(billedAmountString);

        Session session = getSession();
        int jobId = getMap().getInt("jobId");
        Employee creditedTech = (Employee) session.get(Employee.class,
                new Integer(employeeId));
        if(creditedTech == null) { 
            throw new IllegalStateException("No Employee with id: " + employeeId);
        }
        Job job = (Job) session.get(Job.class, new Integer(jobId));

        job.setInvoiceAmount(billedAmount);
        job.setDateBilled(new Date());
        job.setInvoiceNumber(invoiceNumber);
        creditedTech.addCreditedTechnicianJob(job);
        session.save(creditedTech);

        saveActionLog("Billed for job: "
                + job.getService().getLocation().getName() + "->"
                + job.getService().getServiceType().getName());
        
        MessageUtilities.addConfirmationMessage(request,
                "Job was successfully billed.");

        return mapping.findForward("Success");
    }

}
