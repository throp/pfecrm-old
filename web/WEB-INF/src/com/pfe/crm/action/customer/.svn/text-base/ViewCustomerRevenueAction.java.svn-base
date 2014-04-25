package com.pfe.crm.action.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.domain.entity.Customer;

/**
 * ViewCustomerRevenueAction.java
 * 
 * View the billing (i.e. invoices) for a customer
 * 
 * @author Ben Northrop Nov 27, 2006
 * 
 */
public class ViewCustomerRevenueAction extends BaseAction
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
        Integer customerId = new Integer(getMap().getInt("customerId"));
        Session session = getSession();
        StringBuffer listHql = new StringBuffer();
        listHql.append(" select j ");
        listHql.append(" from Job j ");
        listHql.append(" left join fetch j.service s ");
        listHql.append(" left join fetch s.location l ");
        listHql.append(" where l.customer.id = :customerId ");
        listHql.append(" and j.dateBilled != null ");
        
        Query listQuery = session.createQuery(listHql.toString());
        listQuery.setInteger("customerId", customerId);
        List jobs = listQuery.list();
        
        StringBuffer totalHql = new StringBuffer();
        totalHql.append(" select sum(j.invoiceAmount) ");
        totalHql.append(" from Job j ");
        totalHql.append(" where j.service.location.customer.id = :customerId ");
        totalHql.append(" and j.dateBilled != null");
        Query totalQuery = session.createQuery(totalHql.toString());
        totalQuery.setInteger("customerId", customerId);
        Float total = (Float) totalQuery.uniqueResult();

        Customer customer = (Customer) session.get(Customer.class, customerId);

        request.setAttribute("customer", customer);
        request.setAttribute("jobs", jobs);
        request.setAttribute("total", total);
        
        return mapping.findForward("Success");
    }

}
