package com.pfe.crm.action.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Category;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.ndg.core.util.StringUtilities;
import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.dao.customer.CustomerDAO;
import com.pfe.crm.domain.entity.Customer;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.type.CustomerStatus;
import com.pfe.crm.report.customer.CustomerLoader;

/**
 * ViewCustomersAction.java
 * 
 * Find the customers, given the filter.
 * 
 * @author Ben Northrop May 12, 2007
 * 
 */
public class ViewCustomersAction extends BaseAction
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
        RequestParameterMap map = getMap();
        LOG = Category.getInstance(CustomerLoader.class);
        LOG.debug("ReportParameterMap: " + map);

        String customerName = map.getString("customerName", "");
        String customerAddress = map.getString("customerAddress", "");
        String customerZip = map.getString("customerZip", "");
        String locationName = map.getString("locationName", "");
        String locationAddress = map.getString("locationAddress", "");
        Integer officeId = map.getInt("officeId", 0);
        Integer statusId = map.getInt("status", 0);
        CustomerStatus status = null;
        if (statusId != 0) {
            status = CustomerStatus.getInstance(statusId);
        }

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("customerName", customerName);
        parameterMap.put("customerAddress", customerAddress);
        parameterMap.put("customerZip", customerZip);
        parameterMap.put("locationName", locationName);
        parameterMap.put("locationAddress", locationAddress);
        parameterMap.put("officeId", officeId);
        parameterMap.put("statusId", statusId);
        Session session = getSession();
        CustomerDAO customerDAO = new CustomerDAO(session);
        List<Customer> customers = customerDAO
                .retrieveCustomers(parameterMap);
        LOG.debug("customers: " + customers.size());
        if (!StringUtilities.isEmpty(locationName)
                || !StringUtilities.isEmpty(locationAddress)) {
            Iterator iter = customers.iterator();
            while (iter.hasNext()) {
                Location location = (Location) iter.next();
                Customer customer = location.getCustomer();
                customer.getName();
            }
        }

        if (customers == null || customers.size() == 0) {
            request.setAttribute("ndg.report", new ArrayList());
        } else if (customers.size() > MAX_RECORDS_TO_SHOW) {
            request.setAttribute("totalRecords", customers.size() + "");
            request.setAttribute("recordsShown", MAX_RECORDS_TO_SHOW);
            request.setAttribute("ndg.report", new ArrayList<Customer>(
                    customers.subList(0, MAX_RECORDS_TO_SHOW - 1)));
        } else {
            request.setAttribute("recordsShown", customers.size() + "");
            request.setAttribute("totalRecords", customers.size() + "");
            request.setAttribute("ndg.report", new ArrayList<Customer>(
                    customers));
        }
        request.setAttribute("reportParameters", map);
        return mapping.findForward("Success");

    }
}
