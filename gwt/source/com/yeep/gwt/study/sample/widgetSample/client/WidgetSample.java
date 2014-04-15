package com.yeep.gwt.study.sample.widgetSample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DisclosureEvent;
import com.google.gwt.user.client.ui.DisclosureHandler;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DisclosurePanelImages;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.LoadListener;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.TreeListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Widget Sample
 * Author: Roger.Yi
 */
public class WidgetSample implements EntryPoint, HistoryListener
{
	// Gobal Label Ojbect
	private Label gobalLbl = new Label();

	public void onModuleLoad()
	{
		// Create Constants
		final WidgetSampleConstants constants = (WidgetSampleConstants) GWT
				.create(WidgetSampleConstants.class);

		/**************************** 1.Button Sample Start *********************************/
		RootPanel.get().add(new HTML("1.Button Sample <br><br>"));
		// Create a btn with name and listener
		Button btn1 = new Button(constants.ButtonItem1(), new ClickListener()
		{
			public void onClick(Widget sender)
			{
				Window.alert("You click me!!!");
			}
		});

		// Add it to the root panel.
		RootPanel.get().add(btn1);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Button Sample End *********************************/

		/************************* 2.Hyperlinks Sample Start ******************************/
		RootPanel.get().add(new HTML("2.Hyperlinks Sample <br><br>"));
		// Create three hyperlinks that change the application's history.
		Hyperlink link0 = new Hyperlink("link to foo", "foo");
		Hyperlink link1 = new Hyperlink("link to bar", "bar");
		Hyperlink link2 = new Hyperlink("link to baz", "baz");

		// If the application starts with no history token, start it off in the
		// 'baz' state.
		String initToken = History.getToken();
		if (initToken.length() == 0)
			initToken = "baz";

		// onHistoryChanged() is not called when the application first runs.
		// Call it now in order to reflect the initial state.
		onHistoryChanged(initToken);

		// Add widgets to the root panel.
		VerticalPanel panel = new VerticalPanel();
		panel.add(gobalLbl);
		panel.add(link0);
		panel.add(link1);
		panel.add(link2);
		RootPanel.get().add(panel);

		// Add history listener
		History.addHistoryListener(this);
		RootPanel.get().add(new HTML("<br>"));
		/************************* Hyperlinks Sample End ******************************/

		/**************************** 3.Menu Sample Start *********************************/
		RootPanel.get().add(new HTML("3.Menu Sample <br><br>"));
		// Create a Command for Menu Item Event
		Command menuCommand = new Command()
		{
			public void execute()
			{
				Window.alert("You selected a menu item!");
			}
		};

		// Make some sub-menus that we will cascade from the top menu.
		MenuBar fooMenu = new MenuBar(true);
		fooMenu.addItem("the", menuCommand);
		fooMenu.addItem("foo", menuCommand);
		fooMenu.addItem("menu", menuCommand);

		MenuBar barMenu = new MenuBar();
		barMenu.addItem("the", menuCommand);
		barMenu.addItem("bar", menuCommand);
		barMenu.addItem("menu", menuCommand);

		MenuBar bazMenu = new MenuBar(true);
		bazMenu.addItem("the", menuCommand);
		bazMenu.addItem("baz", menuCommand);
		bazMenu.addItem("menu", menuCommand);

		// Make a new menu bar, adding a few cascading menus to it.
		MenuBar menu = new MenuBar();
		menu.addItem("foo", fooMenu);
		menu.addItem("bar", barMenu);
		menu.addItem("baz", bazMenu);

		// Add it to the root panel.
		RootPanel.get().add(menu);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Menu Sample End *********************************/

		/**************************** 4.Tree Sample Start *********************************/
		RootPanel.get().add(new HTML("4.Tree Sample <br><br>"));

		TreeItem chapter1 = new TreeItem("1: Introducing GWT");
		chapter1.addItem("1.1: A Walk Through GWT");
		chapter1.addItem("1.2: GWT Versus Other Solutions");

		TreeItem chapter2 = new TreeItem("2: Exercising the GWT Tools");
		chapter2.addItem("2.1: Setting up Dashboard Version 1");

		TreeItem chapter3 = new TreeItem("3: Creating the Dashboard");
		chapter3.addItem("3.1: Stage 2 - Developing the Application");

		Tree tree = new Tree();
		tree.addItem(chapter1);
		tree.addItem(chapter2);
		tree.addItem(chapter3);

		tree.addTreeListener(new TreeListener()
		{
			public void onTreeItemSelected(TreeItem item)
			{
				Window.alert(item.getText() + " " + item.getChildCount());
			}

			public void onTreeItemStateChanged(TreeItem item)
			{
				Window.alert(item.getText() + " " + item.getState() + " "
						+ item.getChildCount());
			}
		});

		RootPanel.get().add(tree);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Tree Sample End *********************************/

		/**************************** 5.Image Sample Start *********************************/
		RootPanel.get().add(new HTML("5.Image Sample <br><br>"));
		// Create an image, not yet referencing a URL.
		Image image = new Image();
		final Label imagelbl = new Label();

		// Hook up a load listener, so that we can find out when it loads (or
		// fails to, as the case may be).
		image.addLoadListener(new LoadListener()
		{
			public void onLoad(Widget sender)
			{
				imagelbl.setText("Done loading.");
			}

			public void onError(Widget sender)
			{
				imagelbl.setText("An error occurred while loading.");
			}
		});

		// Point the image at a real URL.
		imagelbl.setText("Loading...");
		image.setUrl("http://www.google.com/images/logo.gif");

		// Add the image & label to the root panel.
		VerticalPanel panelImage = new VerticalPanel();
		panelImage.add(imagelbl);
		panelImage.add(image);

		RootPanel.get().add(panelImage);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Image Sample End *********************************/

		/**************************** 6.Label Sample Start *********************************/
		RootPanel.get().add(new HTML("6.Label Sample <br><br>"));

		final Label textLabel = new Label("First Label Text");
		textLabel.addClickListener(new ClickListener()
		{
			public void onClick(Widget sender)
			{
				if ("First Label Text".equals(textLabel.getText()))
					textLabel.setText("Second Label Text");
				else
					textLabel.setText("First Label Text");
			}
		});

		RootPanel.get().add(textLabel);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Label Sample End *********************************/

		/**************************** 7.CheckBox Sample Start *********************************/
		RootPanel.get().add(new HTML("7.CheckBox Sample <br><br>"));

		// Make a new check box, and select it by default.
		CheckBox checkBox = new CheckBox("Foo");
		checkBox.setChecked(true);

		// Hook up a listener to find out when it's clicked.
		checkBox.addClickListener(new ClickListener()
		{
			public void onClick(Widget sender)
			{
				boolean checked = ((CheckBox) sender).isChecked();
				Window.alert("It is " + (checked ? "" : "not ") + "checked");
			}
		});

		// Add it to the root panel.
		RootPanel.get().add(checkBox);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** CheckBox Sample End *********************************/

		/**************************** 8.RadioBox Sample Start *********************************/
		RootPanel.get().add(new HTML("8.RadioBox Sample <br><br>"));
		// Make some radio buttons, all in one group.
		RadioButton rb0 = new RadioButton("myRadioGroup", "foo");
		RadioButton rb1 = new RadioButton("myRadioGroup", "bar");
		RadioButton rb2 = new RadioButton("myRadioGroup", "baz");

		// Check 'baz' by default.
		rb2.setChecked(true);

		// Add them to the root panel.
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.add(rb0);
		flowPanel.add(rb1);
		flowPanel.add(rb2);

		rb1.addClickListener(new ClickListener()
		{
			public void onClick(Widget sender)
			{
				Window.alert("check rb1");
			}
		});

		RootPanel.get().add(flowPanel);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** RadioBox Sample End *********************************/

		/**************************** 9.Text Sample Start *********************************/
		RootPanel.get().add(new HTML("9.Text Sample <br><br>"));

		// Make some text boxes.
		// The Password TextBox and TextBox
		final PasswordTextBox ptb = new PasswordTextBox();
		final TextBox tb = new TextBox();

		tb.addKeyboardListener(new KeyboardListenerAdapter()
		{
			public void onKeyPress(Widget sender, char keyCode, int modifiers)
			{
				if (!Character.isDigit(keyCode))
				{
					((TextBox) sender).cancelKey();
					Window.alert("Only Digital Character is acceptable!!!");
					tb.setFocus(true);
				}
			}
		});

		// Let's make an 20x5 text area to go along with the other two.
		TextArea ta = new TextArea();
		ta.setCharacterWidth(20);
		ta.setVisibleLines(5);

		// Add them to the root panel.
		VerticalPanel textPanel = new VerticalPanel();
		textPanel.add(tb);
		textPanel.add(ptb);
		textPanel.add(ta);

		RootPanel.get().add(textPanel);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** Text Sample End *********************************/

		/**************************** 9.ListBox Sample Start *********************************/
		RootPanel.get().add(new HTML("9.ListBox Sample <br><br>"));
		// Make a new list box, adding a few items to it.
		ListBox lb = new ListBox();
		lb.addItem("foo");
		lb.addItem("bar");
		lb.addItem("baz");
		lb.addItem("toto");
		lb.addItem("tintin");

		// Make enough room for all five items (setting this value to 1 turns it
		// into a drop-down list).
		lb.setVisibleItemCount(5);

		RootPanel.get().add(lb);
		RootPanel.get().add(new HTML("<br>"));
		/**************************** ListBox Sample End *********************************/

		/**************************** 10.DisclosurePanel Sample Start *********************************/
		RootPanel.get().add(new HTML("10.DisclosurePanel Sample <br><br>"));
//		final DisclosurePanel disclosurePanel = new DisclosurePanel();
//		disclosurePanel.addEventHandler(new DisclosureHandler()
//		{
//
//			public void onClose(DisclosureEvent event)
//			{
//				disclosurePanel.setHeader(new DisclosurePanelHeader(false,
//						"Click Here To Open"));
//			}
//
//			public void onOpen(DisclosureEvent event)
//			{
//				disclosurePanel.setHeader(new DisclosurePanelHeader(true,
//						"Click Here To Close"));
//			}
//		});
//		TextBox textBox = new TextBox();
//		textBox.setText("Roger Yi");
//		disclosurePanel.add(textBox);
//		disclosurePanel.setWidth("300px");
//		disclosurePanel.addStyleName("table-center");
//
//		RootPanel.get().add(disclosurePanel);
//		RootPanel.get().add(new HTML("<br>"));
		
		
		FlowPanel fp1 = new FlowPanel();
		final DisclosurePanel disclosurePanel1 = new DisclosurePanel("111111");
		disclosurePanel1.addEventHandler(new DisclosureHandler()
		{

			public void onClose(DisclosureEvent event)
			{
				disclosurePanel1.setHeader(new DisclosurePanelHeader(false,
						"Click Here To Open"));
			}

			public void onOpen(DisclosureEvent event)
			{
				disclosurePanel1.setHeader(new DisclosurePanelHeader(true,
						"Click Here To Close"));
			}
		});
		
		FlowPanel fp11 = new FlowPanel();
		TextBox textBox1 = new TextBox();
		textBox1.setText("Roger Yi 1111");
		fp11.add(textBox1);
		disclosurePanel1.add(fp11);
		disclosurePanel1.setWidth("300px");
		fp1.add(disclosurePanel1);
		
		FlowPanel fp2 = new FlowPanel();
		final DisclosurePanel disclosurePanel2 = new DisclosurePanel("2222222");
		disclosurePanel2.addEventHandler(new DisclosureHandler()
		{

			public void onClose(DisclosureEvent event)
			{
				disclosurePanel1.setHeader(new DisclosurePanelHeader(false,
						"Click Here To Open"));
			}

			public void onOpen(DisclosureEvent event)
			{
				disclosurePanel1.setHeader(new DisclosurePanelHeader(true,
						"Click Here To Close"));
			}
		});
		FlowPanel fp22 = new FlowPanel();
		TextBox textBox2 = new TextBox();
		textBox2.setText("Roger Yi 2222");
		fp22.add(textBox2);
		disclosurePanel2.add(fp22);
		disclosurePanel2.setWidth("300px");
		fp2.add(disclosurePanel2);
		
		FlowPanel fp = new FlowPanel();
		fp.add(fp1);
		fp.add(fp2);
		RootPanel.get().add(fp);
		

		/**************************** ListBox Sample End *********************************/
	}

	final DisclosurePanelImages images = (DisclosurePanelImages) GWT
			.create(DisclosurePanelImages.class);

	class DisclosurePanelHeader extends HorizontalPanel
	{
		public DisclosurePanelHeader(boolean isOpen, String html)
		{
			add(isOpen ? images.disclosurePanelOpen().createImage() : images
					.disclosurePanelClosed().createImage());
			add(new HTML(html));
		}
	}

	/**
	 * Implemented menthod from HistoryListener
	 * This method is called whenever the application's history changes.
	 *
	 * @param historyToken
	 */
	public void onHistoryChanged(String historyToken)
	{
		// Set the label to reflect the current history token.
		gobalLbl.setText("The current history token is: " + historyToken);
	}
}
