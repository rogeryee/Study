package com.yeep.gwt.study.sample.mvp.hellomvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.ClientFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloMVP implements EntryPoint
{
	private SimplePanel mainframe = new SimplePanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// ClientFactory clientFactory = GWT.create(ClientFactory.class);
		ClientFactory clientFactory = ClientFactory.getInstance();

		// ActivityManager
		ActivityManager activityManager = new ActivityManager(
				clientFactory.getApplicationMapper(),
				clientFactory.getEventBus());
		activityManager.setDisplay(mainframe);

		// PlaceHistoryHandler
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				clientFactory.getApplicationMapper());
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(), clientFactory
						.getApplicationMapper().getDefaultPlace());

		RootPanel.get().add(mainframe);

		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
