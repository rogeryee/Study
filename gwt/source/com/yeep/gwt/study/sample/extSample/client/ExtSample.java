package com.yeep.gwt.study.sample.extSample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.event.ComboBoxCallback;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;

/**
 * The Widget Sample Author: Roger.Yi
 */
public class ExtSample implements EntryPoint
{
	public void onModuleLoad()
	{
		/** ************************** 1.ComboBox Sample Start ******************************** */
		RootPanel.get().add(new HTML("1.ComboBox Sample <br><br>"));

		final Store store = new SimpleStore(
				new String[] { "abbr", "state", "nick" }, getStates());
		store.load();

		final ComboBox cb = new ComboBox();
		cb.setForceSelection(true);
		cb.setMinChars(1);
		cb.setFieldLabel("State");
		cb.setStore(store);
		cb.setDisplayField("state");
		cb.setMode(ComboBox.LOCAL);
		cb.setTriggerAction(ComboBox.ALL);
		cb.setEmptyText("Enter state");
		cb.setLoadingText("Searching...");
		cb.setTypeAhead(true);
		cb.setSelectOnFocus(true);
		cb.setWidth(200);

		cb.setHideTrigger(false);

		cb.addListener(new ComboBoxListenerAdapter()
		{
			public boolean doBeforeQuery(ComboBox comboBox, ComboBoxCallback cb)
			{
				Window.alert("ComboBox::doBeforeQuery()");
				System.out.println("ComboBox::doBeforeQuery()");
				return true;
			}

			public boolean doBeforeSelect(ComboBox comboBox, Record record, int index)
			{
				Window.alert("ComboBox::doBeforeSelect()");
				System.out.println("ComboBox::doBeforeSelect("
						+ record.getAsString("state") + ")");
				return super.doBeforeSelect(comboBox, record, index);
			}

			public void onCollapse(ComboBox comboBox)
			{
				Window.alert("ComboBox::onCollapse()");
				System.out.println("ComboBox::onCollapse()");
			}

			public void onExpand(ComboBox comboBox)
			{
				Window.alert("ComboBox::onExpand()");
				System.out.println("ComboBox::onExpand()");
			}

			public void onSelect(ComboBox comboBox, Record record, int index)
			{
				Window.alert("ComboBox::onSelect()");
				System.out.println("ComboBox::onSelect('" + record.getAsString("state")
						+ "')");
			}

			public void onBlur(Field field)
			{
				Window.alert("ComboBox::onBlur()");
				System.out.println("ComboBox::onBlur()");
			}

			public void onChange(Field field, Object newVal, Object oldVal)
			{
				Window.alert("ComboBox::onChange()");
				System.out.println("ComboBox::onChange(" + oldVal + "-->" + newVal
						+ ")");
			}

			public void onFocus(Field field)
			{
				Window.alert("ComboBox::onFocus()");
				System.out.println("ComboBox::onFocus()");
			}

			public void onInvalid(Field field, String msg)
			{
				Window.alert("ComboBox::onInvalid()");
				super.onInvalid(field, msg);
			}

			public void onSpecialKey(Field field, EventObject e)
			{
				Window.alert("ComboBox::onSpecialKey()");
				System.out.println("ComboBox::onSpecialKey(key code " + e.getKey()
						+ ")");
			}
		});

		RootPanel.get().add(cb);
		RootPanel.get().add(new HTML("<br>"));
		/** ************************** ListBox Sample End ******************************** */
	}

	private static String[][] getStates()
	{
		return new String[][] {
				new String[] { "AL", "Alabama", "The Heart of Dixie" },
				new String[] { "AK", "Alaska", "The Land of the Midnight Sun" },
				new String[] { "AZ", "Arizona", "The Grand Canyon State" },
				new String[] { "AR", "Arkansas", "The Natural State" },
				new String[] { "CA", "California", "The Golden State" },
				new String[] { "CO", "Colorado", "The Mountain State" },
				new String[] { "CN", "Connecticut", "The Constitution State" },
				new String[] { "DE", "Delaware", "The First State" },
				new String[] { "DC", "District of Columbia", "The Nation's Capital" },
				new String[] { "FL", "Florida", "The Sunshine State" },
				new String[] { "GA", "Georgia", "The Peach State" },
				new String[] { "HW", "Hawaii", "The Aloha State" },
				new String[] { "ID", "Idaho", "Famous Potatoes" },
				new String[] { "IL", "Illinois", "The Prairie State" },
				new String[] { "IN", "Indiana", "The Hospitality State" },
				new String[] { "IA", "Iowa", "The Corn State" },
				new String[] { "KS", "Kansas", "The Sunflower State" },
				new String[] { "KY", "Kentucky", "The Bluegrass State" },
				new String[] { "LA", "Louisiana", "The Bayou State" },
				new String[] { "ME", "Maine", "The Pine Tree State" },
				new String[] { "MA", "Massachusetts", "The Spirit of America" },
				new String[] { "MD", "Maryland", "Chesapeake State" },
				new String[] { "MI", "Michigan", "Great Lakes State" },
				new String[] { "MN", "Minnesota", "North Star State" },
				new String[] { "MS", "Mississippi", "Magnolia State" },
				new String[] { "MO", "Missouri", "Show Me State" },
				new String[] { "MT", "Montana", "Big Sky Country" },
				new String[] { "NE", "Nebraska", "Beef State" },
				new String[] { "NV", "Nevada", "Silver State" },
				new String[] { "NH", "New Hampshire", "Granite State" },
				new String[] { "NJ", "New Jersey", "Garden State" },
				new String[] { "NM", "New Mexico", "Land of Enchantment" },
				new String[] { "NY", "New York", "Empire State" },
				new String[] { "NC", "North Carolina", "First in Freedom" },
				new String[] { "ND", "North Dakota", "Peace Garden State" },
				new String[] { "OH", "Ohio", "The Heart of it All" },
				new String[] { "OK", "Oklahoma", "Oklahoma is OK" },
				new String[] { "OR", "Oregon", "Pacific Wonderland" },
				new String[] { "PA", "Pennsylvania", "Keystone State" },
				new String[] { "RH", "Rhode Island", "Ocean State" },
				new String[] { "SC", "South Carolina", "Nothing Could be Finer" },
				new String[] { "SD", "South Dakota", "Great Faces, Great Places" },
				new String[] { "TE", "Tennessee", "Volunteer State" },
				new String[] { "TX", "Texas", "Lone Star State" },
				new String[] { "UT", "Utah", "Salt Lake State" },
				new String[] { "VE", "Vermont", "Green Mountain State" },
				new String[] { "VA", "Virginia", "Mother of States" },
				new String[] { "WA", "Washington", "Green Tree State" },
				new String[] { "WV", "West Virginia", "Mountain State" },
				new String[] { "WI", "Wisconsin", "America's Dairyland" },
				new String[] { "WY", "Wyoming", "Like No Place on Earth" } };
	}
}
