package com.yeep.gwt.study.sample.rpcSample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yeep.gwt.study.sample.rpcSample.client.SampleService;
import com.yeep.study.gwt.rpcSample.service.Spring4GWTService;

/**
 * The Service in GWT side which will call the spring service via gwt-servlet.xml
 *
 * @author Roger.Yee
 */
public class SampleServiceImpl extends RemoteServiceServlet implements
    SampleService
{
  private Spring4GWTService spring4GWTService;

  public SampleServiceImpl(Spring4GWTService spring4GWTService)
  {
    this.spring4GWTService = spring4GWTService;
  }

  public String getMessageFromServer()
  {
    // Invoke the method from server side
    return this.spring4GWTService.getMessageFromServer();
  }
}