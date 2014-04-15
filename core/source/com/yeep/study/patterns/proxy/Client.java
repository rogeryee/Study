package com.yeep.study.patterns.proxy;

public class Client
{
  public static void main(String[] args)
  {
    Subject subject = new ProxySubject();
    subject.operation();
  }
}
