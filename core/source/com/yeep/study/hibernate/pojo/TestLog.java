package com.yeep.study.hibernate.pojo;

/**
 * A TestLog POJO for Hibernate.
 *
 * @author Roger.Yee
 */
public class TestLog
{
    private String id;
    private String log;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getLog()
    {
        return log;
    }

    public void setLog(String log)
    {
        this.log = log;
    }
}
