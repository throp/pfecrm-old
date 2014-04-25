package com.pfe.crm.dao.customer;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ndg.core.util.StringUtilities;
import com.pfe.crm.core.dao.BaseDAO;
import com.pfe.crm.domain.entity.Customer;

/**
 * CustomerDAO.java
 * 
 * All CRUD methods related to the Customer entity.
 * 
 * @author Ben Northrop Jun 27, 2007
 * 
 */
public class CustomerDAO extends BaseDAO<Customer>
{

    /**
     * @param session
     */
    public CustomerDAO(Session session)
    {
        super(session);
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityClass()
     */
    @Override
    public Class getEntityClass()
    {
        return Customer.class;
    }

    /**
     * @see com.pfe.crm.core.dao.BaseDAO#getEntityName()
     */
    @Override
    public String getEntityName()
    {
        return "Customer";
    }

    /**
     * Retrieve all customers matching the criteria.
     */
    public List<Customer> retrieveCustomers(Map map)
    {
        StringBuffer hql = new StringBuffer();
        if (stringNotEmpty(map, "locationName")
                || stringNotEmpty(map, "locationAddress")) {
            hql.append(" select l ");
        } else {
            hql.append(" select c");
        }
        hql.append(" from Customer c ");
        if (stringNotEmpty(map, "locationName")
                || stringNotEmpty(map, "locationAddress")) {
            hql.append(" join c.locations l ");
        }
        hql.append(" where 1 = 1 ");
        if (stringNotEmpty(map, "customerName")) {
            hql.append(" and c.name LIKE :customerName");
        }
        if (stringNotEmpty(map, "customerAddress")) {
            hql.append(" and c.address1 like :customerAddress");
        }
        if (stringNotEmpty(map, "customerZip")) {
            hql.append(" and c.zip like :customerZip");
        }
        if (stringNotEmpty(map, "locationName")) {
            hql.append(" and l.name LIKE :locationName");
        }
        if (stringNotEmpty(map, "locationAddress")) {
            hql.append(" and l.address1 like :locationAddress");
        }
        if (map.get("status") != null) {
            hql.append(" and c.status = :status ");
        }
        hql.append(" order by c.name ");
        Query query = getSession().createQuery(hql.toString());

        if (stringNotEmpty(map, "customerName")) {
            query.setString("customerName", subWildCard(map, "customerName"));
        }
        if (stringNotEmpty(map, "customerAddress")) {
            query.setString("customerAddress", subWildCard(map,
                    "customerAddress"));
        }
        if (stringNotEmpty(map, "customerZip")) {
            query.setString("customerZip", subWildCard(map, "customerZip"));
        }
        if (stringNotEmpty(map, "locationName")) {
            query.setString("locationName", subWildCard(map, "locationName"));
        }
        if (stringNotEmpty(map, "locationAddress")) {
            query.setString("locationAddress", subWildCard(map,
                    "locationAddress"));

        }
        if (map.get("status") != null) {
            query.setParameter("status", map.get("status"));
        }
        return query.list();

    }

    /**
     * Checks if it's empty in the collection or if the string is empty.
     */
    private boolean stringNotEmpty(Map map, String key)
    {
        Object value = map.get(key);
        if (value == null) {
            return false;
        } else {
            return !StringUtilities.isEmpty(value.toString());
        }
    }

    /**
     * Substitute the wildcard in with a '%'.
     */
    private String subWildCard(Map map, String key)
    {
        String value = map.get(key).toString();
        return StringUtilities.replaceWith(value, "*", "%");
    }
}
