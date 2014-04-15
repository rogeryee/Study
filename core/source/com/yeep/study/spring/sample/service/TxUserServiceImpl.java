package com.yeep.study.spring.sample.service;

import com.yeep.study.hibernate.pojo.TestLog;
import com.yeep.study.hibernate.pojo.TestUserExtInfo;
import com.yeep.study.hibernate.pojo.TestUserInfo;
import com.yeep.study.spring.sample.dao.TestLogDao;
import com.yeep.study.spring.sample.dao.TestUserExtInfoDao;
import com.yeep.study.spring.sample.dao.TestUserInfoDao;
import com.yeep.study.spring.sample.exception.LogicException;

/**
 * Implements UserService with Spring v1.0 transaction declaration sample
 * 
 * @author Roger.Yee
 */
public class TxUserServiceImpl implements TxUserService
{
    // properties
    private TestUserInfoDao userDao;
    private TestLogDao logDao;
    private TestUserExtInfoDao userExtDao;

    //Setters and Getters
    public TestUserInfoDao getUserDao()
    {
        return userDao;
    }

    public void setUserDao(TestUserInfoDao userDao)
    {
        this.userDao = userDao;
    }

    public TestLogDao getLogDao()
    {
        return logDao;
    }

    public void setLogDao(TestLogDao logDao)
    {
        this.logDao = logDao;
    }

    public TestUserExtInfoDao getUserExtDao()
    {
        return userExtDao;
    }

    public void setUserExtDao(TestUserExtInfoDao userExtDao)
    {
        this.userExtDao = userExtDao;
    }

    //Business Functions
    public void log(TestLog log) throws LogicException
    {
        System.out.println("---- Enter TxUserServiceImpl.log() \r\n");
        
        logDao.save(log);
    }

    public void saveUserInfoAndExtension(TestUserInfo userInfo, TestUserExtInfo userExt) throws LogicException
    {
        System.out.println("---- Enter TxUserServiceImpl.saveUserInfoAndExtension() \r\n");

        userDao.save(userInfo);

        userExtDao.save(userExt);
    }
}
