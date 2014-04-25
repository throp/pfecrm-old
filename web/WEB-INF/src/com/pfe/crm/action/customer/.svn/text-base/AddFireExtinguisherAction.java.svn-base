package com.pfe.crm.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.hibernate.Session;

import com.pfe.crm.business.customer.ServiceManager;
import com.pfe.crm.core.web.BaseAction;
import com.pfe.crm.core.web.RequestParameterMap;
import com.pfe.crm.core.web.message.MessageUtilities;
import com.pfe.crm.dao.customer.FireExtinguisherDAO;
import com.pfe.crm.domain.entity.Chemical;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.Location;
import com.pfe.crm.domain.entity.Manufacturer;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.entity.Weight;
import com.pfe.crm.domain.type.FireExtinguisherServiceType;
import com.pfe.crm.domain.type.FireExtinguisherTestType;
import com.pfe.crm.domain.type.Floor;
import com.pfe.crm.domain.type.Year;

/**
 * AddFireExtinguisherAction.java
 * 
 * Add a fire extinguisher to the location
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Aug 8, 2006
 */
public class AddFireExtinguisherAction extends BaseAction
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
        FireExtinguisherDAO feDAO = new FireExtinguisherDAO(getSession());
        int serviceId = map.getInt("serviceId", -1);
        if (serviceId == -1) {
            int feId = map.getInt("fireExtinguisherId");
            FireExtinguisher fe = feDAO.get(feId);
            serviceId = fe.getService().getId();
            feDAO.delete(fe);
        }
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

        Session session = getSession();
        Location location = null;
        Service service = null;

        service = (Service) session.get(Service.class, new Integer(serviceId));
        location = service.getLocation();
        Manufacturer manufacturer = (Manufacturer) session.get(
                Manufacturer.class, new Integer(manufacturerId));
        Weight weight = (Weight) session.get(Weight.class,
                new Integer(weightId));
        Chemical chemical = (Chemical) session.get(Chemical.class, new Integer(
                chemicalId));
        FireExtinguisher fireExtinguisher = new FireExtinguisher();
        fireExtinguisher.setManufacturer(manufacturer);
        fireExtinguisher.setWeight(weight);
        fireExtinguisher.setChemical(chemical);
        fireExtinguisher.setFloor(floor);
        fireExtinguisher.setLocation(strLocation);
        fireExtinguisher.setYear(year);
        fireExtinguisher.setIsLocked(isLocked);
        fireExtinguisher.setTestYear(testYear);
        fireExtinguisher.setTestType(testType);
        fireExtinguisher.setServiceType(serviceType);
        service.addInventoryItem(fireExtinguisher);

        feDAO.save(fireExtinguisher);

        ServiceManager serviceManager = new ServiceManager(service, session);
        serviceManager.updateNumberInventoryItems();

        saveActionLog("Added fire extinguisher ("
                + fireExtinguisher.getManufacturer() + ", "
                + fireExtinguisher.getYear().getYear() + ") for location : "
                + location.getName());

        MessageUtilities.addConfirmationMessage(request,
                "Added Fire Extinguisher to location '" + location.getName()
                        + "' successfully");

        ActionRedirect redirect = new ActionRedirect(mapping
                .findForward("Success"));
        redirect.addParameter("serviceId", "" + serviceId);
        redirect.addParameter("isAdd", "yes");
        return redirect;
    }
}
