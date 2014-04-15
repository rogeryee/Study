package com.yeep.gwt.study.sample.mvp.hellomvp.client.common;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.goodbye.GoodbyePlace;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.hello.HelloPlace;

public class ApplicationMapper implements PlaceHistoryMapper, ActivityMapper
{
	private Map<String, Place> placeMap;

	private Place defaultPlace;

	public ApplicationMapper()
	{
		if (this.placeMap == null)
		{
			this.placeMap = new HashMap<String, Place>();

			HelloPlace helloPlace = new HelloPlace();
			this.placeMap.put(helloPlace.getToken(), helloPlace);
			this.defaultPlace = helloPlace;

			GoodbyePlace goodbyePlace = new GoodbyePlace();
			this.placeMap.put(goodbyePlace.getToken(), goodbyePlace);
		}
	}

	@Override
	public Activity getActivity(Place place)
	{
		return ((BasePlace) place).getActivity();
	}

	@Override
	public Place getPlace(String token)
	{
		return this.placeMap.get(token);
	}

	@Override
	public String getToken(Place place)
	{
		return ((BasePlace) place).getToken();
	}

	public Place getDefaultPlace()
	{
		return this.defaultPlace;
	}
}
