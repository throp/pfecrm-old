package com.pfe.crm.dao.customer;

import com.ndg.core.util.StringUtilities;
import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Location;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * All location related CRUD.
 * 
 * @author bnorthrop
 */
public class LocationDAO extends BaseDAO<Location>
{

    /**
     * Constructor.
     * 
     * @param session
     */
    public LocationDAO(Session session)
    {
        super(session);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Location.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Location";
    }

    /**
     * Retrieve locations meeting criteria.
     */
    public List<Location> retrieveLocations(Integer customerId, String name,
            String address1)
    {
        StringBuffer hql = new StringBuffer();
        hql.append("from Location l where l.customer = :customerId");
        if (!StringUtilities.isEmpty(name)) {
            hql.append(" and l.name LIKE :name");
        }
        if (!StringUtilities.isEmpty(address1)) {
            hql.append(" and l.address1 like :address1");
        }
        hql.append(" order by l.name ");
        Query query = getSession().createQuery(hql.toString());
        query.setInteger("customerId", customerId);
        if (!StringUtilities.isEmpty(name)) {
            query.setString("name", "%" + name + "%");
        }
        if (!StringUtilities.isEmpty(address1)) {
            query.setString("address1", "%" + address1 + "%");
        }
       
        return query.list();
    }

}
