package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.type.FireExtinguisherServiceType;
import com.pfe.crm.domain.type.FireExtinguisherTestType;
import com.pfe.crm.domain.type.Floor;
import com.pfe.crm.domain.type.Year;

/**
 * EditFireExtinguisherAction.java
 * 
 * Edit the fire extingiusher
 * 
 * @author Ben Northrop Jan 6, 2007
 * 
 */
public class EditFireExtinguisherAction extends BaseAction
{

    @Override
    protected ActionForward subExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        RequestParameterMap map = getMap();
        Integer feId = map.getInt("fireExtinguisherId");
        int manufacturerId = map.getInt("manufacturerId");
        int chemicalId = map.getInt("chemicalId");
        int weightId = map.getInt("weightId");
        boolean isLocked = map.getBoolean("isLocked", false);
        Year year = Year.getInstance(map.getInt("year"));
        int intTestYear = map.getInt("testYear", -1);
        Year testYear = intTestYear == -1 ? null : Year
                .getInstance(intTestYear);
        FireExtinguisherTestType testType = null;
        int testTypeId = map.getInt("testType", 0);
        if (testTypeId != 0) {
            testType = FireExtinguisherTestType.getInstance(testTypeId);
        }
        FireExtinguisherServiceType serviceType = null;
        int serviceTypeId = map.getInt("serviceType", 0);
        if (serviceTypeId != 0) {
            serviceType = FireExtinguisherServiceType
                    .getInstance(serviceTypeId);
        }
        int floorNum = map.getInt("floor", -1);
        Floor floor = Floor.getInstance(floorNum);
        String strLocation = map.getString("location", "");

        FireExtinguisherDAO feDAO = new FireExtinguisherDAO(getSession());
        FireExtinguisher fe = feDAO.get(feId);

        return mapping.findForward("Success");
    }

}
