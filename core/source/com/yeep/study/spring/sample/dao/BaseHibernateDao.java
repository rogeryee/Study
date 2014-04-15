package com.yeep.study.spring.sample.dao;

import java.io.Serializable;

/**
 * Interface for all Hibernate Dao
 * Definite the basic functions in Dao
 *
 * @author Roger.Yee
 */
public interface BaseHibernateDao
{
    public Object get(Serializable id);

    public Object load(Serializable id);

    public void save(Object bo);

    public void update(Object bo);
}
