package com.pfe.crm.report.scheduling;

import java.util.ArrayList;

import org.apache.log4j.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.core.util.DateUtilities;
import com.ndg.report.LoadableAdaptor;
import com.ndg.report.ReportException;
import com.ndg.report.ReportParameterMap;
import com.ndg.report.ReportValidationException;
import com.pfe.crm.core.util.HibernateUtilities;
import com.pfe.crm.domain.entity.Job;
import com.pfe.crm.domain.type.Month;
import com.pfe.crm.domain.type.ServiceType;
import com.pfe.crm.domain.type.Year;

/**
 * JobManagerLoader.java
 * 
 * Load the Job Manager report/utility.
 * 
 * Copyright (c) Northrop Development Group 2006
 * 
 * @author Ben Date: Oct 6, 2006
 */
public class RoutingManagerLoader extends LoadableAdaptor
{
    // DATA MEMBERS
    private static final long serialVersionUID = 2053124757377678576L;

    private final static int UNDEFINED = 0;

    private Month month;

    private Month month2;

    private Year year;

    private Year year2;

    private int officeId;

    private String zip;

    private ServiceType serviceType;

    private String sortingField;

    private String customerName;

    private final static Category LOG = Category
            .getInstance(RoutingManagerLoader.class.getName());

    // METHODS
    /**
     * @see com.ndg.report.LoadableAdaptor#init(com.ndg.report.ReportParameterMap)
     */
    public void init(ReportParameterMap map) throws ReportValidationException
    {
        sortingField = map.getString("sortingField", "serviceType");

        // month init
        int thisMonth = DateUtilities.getMonthForToday();
        month = Month.getInstance(map.getInt("monthId", thisMonth));
        int monthId2 = map.getInt("monthId2", UNDEFINED);
        if (monthId2 == UNDEFINED) {
            month2 = null;
        } else {
            month2 = Month.getInstance(monthId2);
        }

        // year init
        int thisYear = DateUtilities.getYearForToday();
        year = Year.getInstance(map.getInt("yearId", thisYear));
        int yearId2 = map.getInt("yearId2", UNDEFINED);
        if (yearId2 == UNDEFINED) {
            year2 = null;
        } else {
            year2 = Year.getInstance(yearId2);
        }

        int serviceTypeId = map.getInt("serviceTypeId", UNDEFINED);
        LOG.debug("serviceTypeId: " + serviceTypeId);
        if (serviceTypeId != UNDEFINED) {
            serviceType = ServiceType.getInstance(serviceTypeId);
        } else {
            serviceType = null;
        }
        LOG.debug("serviceType: " + serviceType);
        officeId = map.getInt("officeId", UNDEFINED);
        zip = map.getString("zip", "");

        customerName = map.getString("customerName", "");
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadHeader()
     */
    public Object loadHeader() throws ReportException
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");
        hql.append(" from Job j ");
        hql.append(" join fetch j.service s ");
        hql.append(" join fetch s.location l ");
        hql.append(" join fetch l.customer c ");
        hql.append(" join fetch j.roadTechnician rt ");
        hql.append(" left join fetch j.shopTechnician ");
        hql.append(" where j.dateReadyForReturn != null ");
        hql.append(" and j.returnTechnician = null ");
        Session session = HibernateUtilities.getSession();
        Query query = session.createQuery(hql.toString());
        return new ArrayList(query.list());
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadSubHeader()
     */
    public Object loadSubHeader() throws ReportException
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");
        hql.append(" from Job j ");
        hql.append(" join fetch j.service s ");
        hql.append(" join fetch s.location l ");
        hql.append(" join fetch l.customer c ");
        hql.append(" join fetch j.serviceCall sc ");
        hql.append(" join fetch sc.employee e ");
        hql.append(" where j.dateInRoadTechQueue = null ");

        Session session = HibernateUtilities.getSession();
        Query query = session.createQuery(hql.toString());
        return new ArrayList(query.list());
    }

    /**
     * @see com.ndg.report.LoadableAdaptor#loadBody()
     */
    public ArrayList loadBody() throws ReportException
    {
        Session session = HibernateUtilities.getSession();
        StringBuffer hql = new StringBuffer();
        hql.append(" select j ");
        hql.append(" from Job j ");
        hql.append(" join fetch j.service s ");
        hql.append(" join fetch s.location l ");
        hql.append(" join fetch l.customer c ");
        hql.append(" join c.office o ");

        hql.append(" where j.dateInRoadTechQueue = null ");
        if (!"".equals(customerName)) {
            hql.append(" and c.name like :customerName ");
        }
        if (officeId != UNDEFINED) {
            hql.append(" and o.id = :officeId ");
        }
        if (!"".equals(zip)) {
            hql.append(" and l.zip = :zip ");
        }
        if (serviceType != null) {
            hql.append(" and j.service.serviceType = :serviceType ");
        }
        hql.append(" and ((j.monthDue = :month ");
        hql.append(" and j.yearDue = :year) ");
        hql.append(" or j.monthDue = :month2 ");
        hql.append(" and j.yearDue = :year2 )) ");
        if (!"".equals(sortingField)) {
            if (sortingField.equals("customerName")) {
                hql.append(" order by c.name ");
            } else if (sortingField.equals("locationName")) {
                hql.append(" order by l.name ");
            } else if (sortingField.equals("serviceType")) {
                hql.append(" order by s.serviceType.name asc ");
            } else if (sortingField.equals("zip")) {
                hql.append(" order by s.zip ");
            } else if (sortingField.equals("numInventoryItems")) {
                hql.append(" order by j.numInventoryItems ");
            } else {
                hql.append(" order by s.serviceType.name desc ");
            }
        } else {
            hql.append(" order by s.serviceType.name desc ");
        }

        LOG.debug("routing manager: " + hql);
        Query query = session.createQuery(hql.toString());
        query.setParameter("month", month);
        query.setParameter("year", year);
        query.setParameter("month2", month2);
        query.setParameter("year2", year2);
        if (!"".equals(customerName)) {
            query.setParameter("customerName", "%" + customerName + "%");
        }
        if (serviceType != null) {
            query.setParameter("serviceType", serviceType);
        }
        if (officeId != UNDEFINED) {
            query.setParameter("officeId", officeId);
        }
        if (!"".equals(zip)) {
            query.setParameter("zip", zip);
        }
        ArrayList<Job> jobs = new ArrayList<Job>(query.list());
        return jobs;
    }

}
