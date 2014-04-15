package com.yeep.gwt.study.sample.mvp.hellomvp.client.goodbye;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BaseActivity;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.hello.HelloPlace;

public class GoodbyeView extends Composite implements IsWidget,
		GoodbyeActivity.Presenter
{
	private BaseActivity activity;
	private Label goodbyeLabel;
	private Label nameLabel;
	private Button helloBtn;

	@SuppressWarnings("unused")
	private String name;

	public GoodbyeView(BaseActivity activity)
	{
		this.activity = activity;
		initView();
	}

	private void initView()
	{
		this.goodbyeLabel = new Label("You left the MVP world, ");
		this.nameLabel = new Label();
		this.helloBtn = new Button("Enter MVP!");
		this.helloBtn.addClickHandler(new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event)
			{
				GoodbyeView.this.activity.goTo(new HelloPlace());
			}

		});

		Panel panel = new FlowPanel();
		panel.add(this.goodbyeLabel);
		panel.add(this.nameLabel);
		panel.add(this.helloBtn);
		initWidget(panel);
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
		this.nameLabel.setText(name);
	}

}
