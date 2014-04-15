package com.yeep.gwt.study.sample.rpcSample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The RPC Sample Author: Roger.Yi
 */
public class RpcSample implements EntryPoint
{
	private final SampleServiceAsync sampleRPC;

	public RpcSample()
	{
		this.sampleRPC = createRPC();
	}

	private SampleServiceAsync createRPC()
	{
		SampleServiceAsync ret = (SampleServiceAsync) GWT
				.create(SampleService.class);
		((ServiceDefTarget) ret).setServiceEntryPoint(GWT.getModuleBaseURL()
				+ SampleService.URL);
		return ret;
	}

	public void onModuleLoad()
	{
		Button button = new Button("Click for RPC");
		button.addClickListener(new ClickListener()
		{
			public void onClick(Widget sender)
			{
				sampleRPC.getMessageFromServer(new AsyncCallback()
				{
					public void onSuccess(Object result)
					{
						Window.alert(result.toString());
					}

					public void onFailure(Throwable caught)
					{
						Window.alert(caught.toString());
						Window.alert("Error!!!!");
					}

				});
			}
		});

		RootPanel.get().add(button);
	}
}
