package com.yeep.gwt.study.sample.mvp.hellomvp.client.hello;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.common.BaseActivity;
import com.yeep.gwt.study.sample.mvp.hellomvp.client.goodbye.GoodbyePlace;

public class HelloView extends Composite implements IsWidget,
		HelloActivity.Presenter
{
	private BaseActivity activity;
	private Label helloLabel;
	private Label nameLabel;
	private Button goodbyeBtn;

	@SuppressWarnings("unused")
	private String name;

	public HelloView(BaseActivity activity)
	{
		this.activity = activity;
		initView();
	}

	private void initView()
	{
		this.helloLabel = new Label("Welcome to the MVP world, ");
		this.nameLabel = new Label();
		this.goodbyeBtn = new Button("Good Bye!");
		this.goodbyeBtn.addClickHandler(new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event)
			{
				HelloView.this.activity.goTo(new GoodbyePlace());
			}

		});

		Panel panel = new FlowPanel();
		panel.add(this.helloLabel);
		panel.add(this.nameLabel);
		panel.add(this.goodbyeBtn);
		initWidget(panel);
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
		this.nameLabel.setText(name);
	}

}
