package com.yeep.study.hibernate.pojo;

/**
 * A TestUserInfo POJO for Hibernate.
 *
 * @author Roger.Yee
 */
public class TestUserExtInfo
{
    private String id;
    private String userName;
    private String company;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
}
