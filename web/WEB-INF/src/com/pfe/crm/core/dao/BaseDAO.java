package com.pfe.crm.core.dao;

import com.pfe.crm.core.domain.BaseEntity;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * BaseDAO.java
 * 
 * A generic dao for an entity, from which all DAOs should extend.
 * 
 * @author Ben Northrop May 20, 2007
 * 
 */
public abstract class BaseDAO<ENTITY extends BaseEntity>
{
    // DATA MEMBERS
    private Session session;

    // CONSTRUCTOR
    /**
     * Must pass in hibernate session for DAO.
     */
    public BaseDAO(Session session)
    {
        this.session = session;
    }

    /**
     * Save an entitye (i.e. create, edit).
     */
    public void save(ENTITY entity)
    {
        session.save(entity);
    }

    /**
     * Delete an entity.
     */
    public void delete(ENTITY entity)
    {
        session.delete(entity);
    }

    /**
     * Retrieve an entity, given the id.
     */
    public ENTITY get(Integer id)
    {
        return (ENTITY) session.get(getEntityClass(), id);
    }

    /**
     * Retrieve the list of all of the entity.
     */
    public Collection<ENTITY> retrieveAll()
    {
        Query query = session.createQuery(" from " + getEntityName());
        return (Collection<ENTITY>) query.list();
    }

    /**
     * Delete an entity given its id.
     */
    public void delete(Integer id)
    {
        ENTITY entity = get(id);
        if (entity == null) {
            throw new DAOException("Could not find entity for id: " + id);
        }
        session.delete(entity);
    }

    /**
     * @return the session
     */
    public Session getSession()
    {
        return session;
    }

    /**
     * Abstract method for retrieving the specific class name of the entity to
     * be retrieved.
     */
    public abstract Class getEntityClass();

    /**
     * Abstract method for retrieving the name of the entity that the DAO is
     * for.
     */
    public abstract String getEntityName();
}
