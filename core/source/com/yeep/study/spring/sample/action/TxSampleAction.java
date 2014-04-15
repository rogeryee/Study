package com.yeep.study.spring.sample.action;

import com.yeep.study.hibernate.pojo.TestLog;
import com.yeep.study.hibernate.pojo.TestUserExtInfo;
import com.yeep.study.hibernate.pojo.TestUserInfo;
import com.yeep.study.spring.sample.exception.GlobalEnv;
import com.yeep.study.spring.sample.exception.LogicException;
import com.yeep.study.spring.sample.service.TxUserService;

/**
 * Sample Action for Spring v1.0 transaction declaration sample
 * @author Roger.Yee
 */
public class TxSampleAction
{
    private TxUserService userService;

    public TxUserService getUserService()
    {
        return userService;
    }

    public void setUserService(TxUserService userService)
    {
        this.userService = userService;
    }

    public void userLogicAddUser(String userName, String address, String company) throws LogicException
    {
        System.out.println("---- Enter TxSampleAction.userLogicAddUser() \r\n");

        TestUserInfo user = new TestUserInfo();
        user.setName(userName);
        user.setAddress(address);

        TestUserExtInfo userExt = new TestUserExtInfo();
        userExt.setUserName(userName);
        userExt.setCompany(company);

        TestLog log = new TestLog();
        log.setLog("this is a log data");

        // Because the ValidationAdvice is listening to the userService,
        // it will throw a exception when GlobalEnv has been set to error state
        // And the operation to UserInfo and UserExtension will be rolled back,
        // and the operation to LogInfo will be committed to database.

        /**
         * situation 1
         */
        GlobalEnv.error();
        userService.saveUserInfoAndExtension(user, userExt);
//        userService.log(log);

        /**
         * situation 2
         */
//        userService.saveUserInfoAndExtension(user,userExt);
//        GlobalEnv.error();
//        userService.log(log);

        /**
         * situation 3
         */
//        try
//        {
//            GlobalEnv.error();
//            userService.saveUserInfoAndExtension(user,userExt);
//        }
//        catch(LogicException le)
//        {
//            try
//            {
//                GlobalEnv.error();
//                userService.log(log);
//            }
//            catch(LogicException lec)
//            {
//                throw lec;
//            }
//
//            throw le;
//        }
    }
}
