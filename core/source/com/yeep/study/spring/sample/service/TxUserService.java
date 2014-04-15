package com.yeep.study.spring.sample.service;

import com.yeep.study.hibernate.pojo.TestLog;
import com.yeep.study.hibernate.pojo.TestUserExtInfo;
import com.yeep.study.hibernate.pojo.TestUserInfo;
import com.yeep.study.spring.sample.exception.LogicException;

/**
 * Interface for the UserService with Spring v1.0 transaction declaration sample
 *
 *
 * @author Roger.Yee
 */
public interface TxUserService
{
    public void saveUserInfoAndExtension(TestUserInfo userInfo, TestUserExtInfo userExt) throws LogicException;

    public void log(TestLog log) throws LogicException;
}
