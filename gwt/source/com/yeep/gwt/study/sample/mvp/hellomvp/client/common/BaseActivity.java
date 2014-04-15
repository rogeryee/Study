package com.yeep.gwt.study.sample.mvp.hellomvp.client.common;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;

public abstract class BaseActivity extends AbstractActivity
{
	public void goTo(String token)
	{
		Place place = ClientFactory.getInstance().getApplicationMapper()
				.getPlace(token);
		ClientFactory.getInstance().getPlaceController().goTo(place);
	}

	public void goTo(Place place)
	{
		ClientFactory.getInstance().getPlaceController().goTo(place);
	}
}
