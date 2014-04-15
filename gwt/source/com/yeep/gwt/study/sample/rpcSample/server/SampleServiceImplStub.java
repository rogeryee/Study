package com.yeep.gwt.study.sample.rpcSample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.yeep.gwt.study.sample.rpcSample.client.SampleService;

/**
 * Implemented Service for Hosted mode
 */
public class SampleServiceImplStub extends RemoteServiceServlet
    implements SampleService
{
  public String getMessageFromServer()
  {
    return "This is the Message from SampleServiceImplStub";
  }
}