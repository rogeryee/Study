package com.yeep.gwt.study.sample.mvp.hellomvp.client.hello;

import com.google.gwt.activity.shared.Activity;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BasePlace;

public class HelloPlace extends BasePlace
{
	@Override
	public String getToken()
	{
		return "Token:Hello";
	}

	@Override
	public Activity getActivity()
	{
		return new HelloActivity();
	}
}
