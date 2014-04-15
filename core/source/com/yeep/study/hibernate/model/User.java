package com.yeep.study.hibernate.model;

import java.util.Set;

/**
 * A User POJO for Hibernate.
 *
 * @author Roger.Yee
 */
public class User
{
  private String id;
  private String name;
  private Set address;

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Set getAddress()
  {
    return address;
  }

  public void setAddress(Set address)
  {
    this.address = address;
  }
}