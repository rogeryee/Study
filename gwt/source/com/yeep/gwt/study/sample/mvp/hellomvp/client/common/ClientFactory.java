package com.yeep.gwt.study.sample.mvp.hellomvp.client.common;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactory
{
	private static final ClientFactory instance = new ClientFactory();

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(
			eventBus);
	private static final ApplicationMapper applicationMapper = new ApplicationMapper();

	private ClientFactory()
	{
	}

	public static ClientFactory getInstance()
	{
		return instance;
	}

	public EventBus getEventBus()
	{
		return eventBus;
	}

	public PlaceController getPlaceController()
	{
		return placeController;
	}

	public ApplicationMapper getApplicationMapper()
	{
		return applicationMapper;
	}
}
