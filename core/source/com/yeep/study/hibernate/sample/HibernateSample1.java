package com.yeep.study.hibernate.sample;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.yeep.study.hibernate.model.Address;
import com.yeep.study.hibernate.model.User;
import com.yeep.study.hibernate.util.HibernateUtil;

/**
 * A Hibernate Sample of one-to-many relationship
 *
 * @author Roger.Yee
 */
public class HibernateSample1
{
  Logger logger = Logger.getLogger(HibernateSample1.class);

  public static void main(String[] args)
  {
    insert();
//    delete();
//    select();
  }

  /**
   * This method is using for insert testing
   */
  public static void insert()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User user = new User();
    user.setName("Roger");

    Address address = new Address();
    address.setName("Shanghai");
    address.setUser(user);

    Address address2 = new Address();
    address2.setName("Beijing");
    address2.setUser(user);

    HashSet<Address> addressSet = new HashSet<Address>();
    addressSet.add(address);
    addressSet.add(address2);
    user.setAddress(addressSet);

    session.save(user);

    session.getTransaction().commit();
    HibernateUtil.getSessionFactory().close();
  }

  /**
   * This method is using for delete testing
   */
  public static void delete()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

//    String hql = " from TestPerson where name='Roger'";
//    List userList = session.createQuery(hql).list();
//    TestPerson person = (TestPerson) userList.get(0);
//
//    if(person.getAddress() != null)
//    {
//      Iterator it = person.getAddress().iterator();
//      if(it.hasNext())
//      {
//        TestPersonAddress addr = (TestPersonAddress) it.next();
//        if(addr != null)
//        {
//          person.getAddress().remove(addr);
//        }
//      }
//    }
//
//    session.save(person);

    session.getTransaction().commit();
    HibernateUtil.getSessionFactory().close();
  }

  public static void select()
  {
//    String hql = " from TestPerson where name='Roger'";
//
//    Session session = HibernateUtil.getSessionFactory().openSession();
//
//    try
//    {
//      List userList = session.createQuery(hql).list();
//      TestPerson person = (TestPerson) userList.get(0);
//      System.out.println("person name is " + person.getName());
//
//      for(Iterator iter = person.getAddress().iterator(); iter.hasNext();)
//      {
//        TestPersonAddress addr = (TestPersonAddress) iter.next();
//        System.out.println("person address is " + addr.getName());
//      }
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//    }
//    finally
//    {
//      HibernateUtil.getSessionFactory().close();
//    }
  }

}
