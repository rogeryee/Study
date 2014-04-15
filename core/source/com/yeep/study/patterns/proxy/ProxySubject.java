package com.yeep.study.patterns.proxy;

/**
 * The Proxy Class of RealSubject
 */
public class ProxySubject implements Subject
{
  private RealSubject realSubject;

  public void operation()
  {
    preOperation();

    if(realSubject == null)
      realSubject = new RealSubject();
    realSubject.operation();

    postOperation();
  }

  private void preOperation()
  {
    System.out.println("This is ProxySubject's preOperation");
  }

  private void postOperation()
  {
    System.out.println("This is ProxySubject's postOperation");
  }
}
