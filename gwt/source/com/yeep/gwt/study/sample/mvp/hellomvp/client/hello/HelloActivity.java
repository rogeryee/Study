package com.yeep.gwt.study.sample.mvp.hellomvp.client.hello;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BaseActivity;

public class HelloActivity extends BaseActivity
{
	private HelloView view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus)
	{
		if (this.view == null)
			this.view = new HelloView(this);

		this.view.setName("Roger");
		panel.setWidget(this.view);
	}

	public interface Presenter
	{
		void setName(String name);
	}
}
