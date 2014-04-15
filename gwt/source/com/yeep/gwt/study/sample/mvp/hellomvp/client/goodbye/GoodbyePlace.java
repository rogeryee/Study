package com.yeep.gwt.study.sample.mvp.hellomvp.client.goodbye;

import com.google.gwt.activity.shared.Activity;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BasePlace;

public class GoodbyePlace extends BasePlace
{
	@Override
	public String getToken()
	{
		return "Token:Goodbye";
	}

	@Override
	public Activity getActivity()
	{
		return new GoodbyeActivity();
	}
}
