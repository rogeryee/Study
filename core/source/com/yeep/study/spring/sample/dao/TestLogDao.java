package com.yeep.study.spring.sample.dao;

import com.yeep.study.hibernate.pojo.TestLog;

/**
 * @author Roger.Yee
 */
public class TestLogDao extends BaseHibernateDaoImpl
{
    protected Class getEntityClass()
    {
        return TestLog.class;
    }
}
