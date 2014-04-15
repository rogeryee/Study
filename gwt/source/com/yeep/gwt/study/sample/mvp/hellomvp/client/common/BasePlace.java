package com.yeep.gwt.study.sample.mvp.hellomvp.client.common;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

public abstract class BasePlace extends Place
{
	public abstract String getToken();

	public abstract Activity getActivity();
}
