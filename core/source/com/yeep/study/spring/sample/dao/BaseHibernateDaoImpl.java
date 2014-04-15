package com.yeep.study.spring.sample.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yeep.study.spring.sample.exception.LogicException;

/**
 * SuperClass for all Hibernate Dao Class
 * Implements load,get,save and update method which defined in BaseHibernateDao
 *
 * @author Roger.Yee
 */
public abstract class BaseHibernateDaoImpl extends HibernateDaoSupport implements BaseHibernateDao
{
    protected Logger logger = Logger.getLogger(getClass());


    /*
    * return the Class of the EntityClass
    */
    abstract protected Class getEntityClass();

    /**
     * Get Object from database by Id
     *
     * @param id
     * @return
     */
    public Object get(Serializable id)
    {
        return getHibernateTemplate().get(this.getEntityClass(), id);
    }

    /**
     * Load Object from database by id
     *
     * @param id
     * @return
     */
    public Object load(Serializable id)
    {
        return getHibernateTemplate().load(this.getEntityClass(), id);
    }

    /**
     * Save Object
     *
     * @param obj
     */
    public void save(Object obj)
    {
        if (this.getEntityClass().isInstance(obj))
        {
            getHibernateTemplate().save(obj);
        }
        else
        {
            throw new LogicException("This obj is not matched with the Entity Class");
        }
    }

    /**
     * Update Object
     *
     * @param obj
     */
    public void update(Object obj)
    {
        if (this.getEntityClass().isInstance(obj))
        {
            getHibernateTemplate().update(obj);
        }
        else
        {
            throw new LogicException("This obj is not matched with the Entity Class");
        }
    }
}
