package com.yeep.study.spring.sample.dao;

import com.yeep.study.hibernate.pojo.TestUserInfo;

/**
 * @author Roger.Yee
 */
public class TestUserInfoDao extends BaseHibernateDaoImpl
{
    protected Class getEntityClass()
    {
        return TestUserInfo.class;
    }
}
