package com.yeep.gwt.study.sample.rpcSample.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Async Call Proxy Interface
 */
public interface SampleServiceAsync
{
  void getMessageFromServer(AsyncCallback callback);
}
