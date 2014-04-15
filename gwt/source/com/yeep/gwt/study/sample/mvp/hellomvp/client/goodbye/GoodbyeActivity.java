package com.yeep.gwt.study.sample.mvp.hellomvp.client.goodbye;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BaseActivity;

public class GoodbyeActivity extends BaseActivity
{
	private GoodbyeView view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus)
	{
		if (this.view == null)
			this.view = new GoodbyeView(this);

		this.view.setName("Roger");
		panel.setWidget(this.view);
	}

	public interface Presenter
	{
		void setName(String name);
	}
}
