package com.pfe.crm.dao.customer;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.core.util.StringUtilities;
import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Chemical;
import com.pfe.crm.domain.entity.FireExtinguisher;
import com.pfe.crm.domain.entity.Manufacturer;
import com.pfe.crm.domain.entity.Service;
import com.pfe.crm.domain.entity.Weight;

/**
 * FireExtinguisherDAO.java
 * 
 * 
 * 
 * @author Ben Northrop Jun 4, 2007
 * 
 */
public class FireExtinguisherDAO extends BaseDAO<FireExtinguisher>
{
    /**
     * Default constructor.
     */
    public FireExtinguisherDAO(Session session)
    {
        super(session);
    }

    /**
     * Overloaded - find all fire extinguishers for a given service.
     */
    public Collection<FireExtinguisher> retrieveFireExtinguishersForService(
            Service service)
    {
        return retrieveFireExtinguishersForService(service, null);
    }

    /**
     * Find all fire extinguishers for a given service.
     */
    public Collection<FireExtinguisher> retrieveFireExtinguishersForService(
            Service service, String sortBy)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" from FireExtinguisher f ");
        hql.append(" left join fetch f.manufacturer m ");
        hql.append(" left join fetch f.chemical c ");
        hql.append(" left join fetch f.weight w ");
        hql.append(" where f.service = :service ");
        if (!StringUtilities.isEmpty(sortBy)) {
            hql.append(" order by " + sortBy);
        } else {
            hql.append(" order by f.id ");
        }
        Query query = getSession().createQuery(hql.toString());
        query.setParameter("service", service);
        return query.list();
    }

    /**
     * Find all fire extinguishers with a certain weight.
     */
    public Collection<FireExtinguisher> retrieveFireExtinguishersForWeight(
            Weight weight)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" from FireExtinguisher f ");
        hql.append(" where f.weight = :weight ");
        Query query = getSession().createQuery(hql.toString());
        query.setParameter("weight", weight);
        return query.list();
    }

    /**
     * Find all fire extinguishers with a certain weight.
     */
    public Collection<FireExtinguisher> retrieveFireExtinguishersForChemical(
            Chemical chemical)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" from FireExtinguisher f ");
        hql.append(" where f.chemical = :chemical ");
        Query query = getSession().createQuery(hql.toString());
        query.setParameter("chemical", chemical);
        return query.list();
    }

    /**
     * Find all fire extinguishers with a certain weight.
     */
    public Collection<FireExtinguisher> retrieveFireExtinguishersForManufacturer(
            Manufacturer manufacturer)
    {
        StringBuffer hql = new StringBuffer();
        hql.append(" from FireExtinguisher f ");
        hql.append(" where f.manufacturer = :manufacturer ");
        Query query = getSession().createQuery(hql.toString());
        query.setParameter("manufacturer", manufacturer);
        return query.list();
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return FireExtinguisher.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "FireExtinguisher";
    }

}
