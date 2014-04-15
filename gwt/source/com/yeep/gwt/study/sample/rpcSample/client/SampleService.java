package com.yeep.gwt.study.sample.rpcSample.client;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Sample Service for GWT
 */
public interface SampleService extends RemoteService
{
  public static final String URL = "sampleRPC.rpc";

  public String getMessageFromServer();
}
