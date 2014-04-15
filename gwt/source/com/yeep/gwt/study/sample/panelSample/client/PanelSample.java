package com.yeep.gwt.study.sample.panelSample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * The Simple Panel Sample
 * Author: Roger.Yi
 */
public class PanelSample implements EntryPoint
{
  public void onModuleLoad()
  {
    /**************************** 1.PopupPanel Sample Start ******************************/
    RootPanel.get().add(new HTML("1.PopupPanel Sample <br><br>"));
    Button buttonPopup = new Button("Popup Panel", new ClickListener()
    {
      public void onClick(Widget sender)
      {
        MyPopup mypopup = new MyPopup();
        mypopup.show();
        mypopup.setPopupPosition(300, 200);
      }
    });

    RootPanel.get().add(buttonPopup);
    RootPanel.get().add(new HTML("<br>"));
    /**************************** PopupPanel Sample End *********************************/

    /**************************** 2.DialogPanel Sample Start ****************************/
    RootPanel.get().add(new HTML("2.DialogPanel Sample <br><br>"));
    Button buttonDialog = new Button("Dialog Panel", new ClickListener()
    {
      public void onClick(Widget sender)
      {
        MyDialog myDialog = new MyDialog();
        myDialog.show();
        myDialog.setPopupPosition(300, 200);
      }
    });

    RootPanel.get().add(buttonDialog);
    RootPanel.get().add(new HTML("<br>"));
    /**************************** DialogPanel Sample End ******************************/

    /**************************** 3.FormPanel Sample Start ****************************/
    RootPanel.get().add(new HTML("3.FormPanel Sample <br><br>"));
    // Create a FormPanel and point it at a service.
    final FormPanel formPanel = new FormPanel();
    formPanel.setAction("/myFormHandler");

    // Because we're going to add a FileUpload widget, we'll need to set the form to use the POST method, and multipart MIME encoding.
    formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
    formPanel.setMethod(FormPanel.METHOD_POST);

    // Create a panel to hold all of the form widgets.
    VerticalPanel formVerticalPanel = new VerticalPanel();
    formPanel.setWidget(formVerticalPanel);

    // Create a TextBox, giving it a name so that it will be submitted.
    final TextBox tbFormPanel = new TextBox();
    tbFormPanel.setName("textBoxFormElement");
    formVerticalPanel.add(tbFormPanel);

    // Create a ListBox, giving it a name and some values to be associated with
    // its options.
    ListBox lbFormPanel = new ListBox();
    lbFormPanel.setName("listBoxFormElement");
    lbFormPanel.addItem("foo", "fooValue");
    lbFormPanel.addItem("bar", "barValue");
    lbFormPanel.addItem("baz", "bazValue");
    formVerticalPanel.add(lbFormPanel);

    // Create a FileUpload widget.
    FileUpload uploadFormPanel = new FileUpload();
    uploadFormPanel.setName("uploadFormElement");
    formVerticalPanel.add(uploadFormPanel);

    // Add a 'submit' button.
    formVerticalPanel.add(new Button("Submit", new ClickListener()
    {
      public void onClick(Widget sender)
      {
        Window.alert("form submit");
        // if action is avaible.
        //formPanel.submit();
      }
    }));

    // Add an event handler to the form.
    formPanel.addFormHandler(new FormHandler()
    {
      public void onSubmitComplete(FormSubmitCompleteEvent event)
      {
        // When the form submission is successfully completed, this event is
        // fired. Assuming the service returned a response of type text/plain,
        // we can get the result text here (see the FormPanel documentation for
        // further explanation).
        Window.alert(event.getResults());
      }

      public void onSubmit(FormSubmitEvent event)
      {
        // This event is fired just before the form is submitted. We can take
        // this opportunity to perform validation.
        if(tbFormPanel.getText().length() == 0)
        {
          Window.alert("The text box must not be empty");
          event.setCancelled(true);
        }
      }
    });

    RootPanel.get().add(formPanel);

    RootPanel.get().add(new HTML("<br>"));
    /**************************** FormPanel Sample End ******************************/

    /**************************** 4. TabPanel Sample Start ******************************/
    RootPanel.get().add(new HTML("4.TabPanel Sample <br><br>"));

    // Create a tab panel with three tabs, each of which displays a different piece of text.
    TabPanel tp = new TabPanel();
    tp.add(new HTML("Foo"), "foo");
    tp.add(new HTML("Bar"), "bar");
    tp.add(new HTML("Baz"), "baz");

    // Show the 'bar' tab initially.
    tp.selectTab(1);

    // Add it to the root panel.
    RootPanel.get().add(tp);
    RootPanel.get().add(new HTML("<br>"));
    /**************************** TabPanel Sample End *********************************/
  }

  // Popup Panel
  private static class MyPopup extends PopupPanel
  {
    public MyPopup()
    {
      // PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
      // If this is set, the panel closes itself automatically when the user
      // clicks outside of it.
      super(true);

      // PopupPanel is a SimplePanel, so you have to set it's widget property to
      // whatever you want its contents to be.
      setWidget(new Label("Click outside of this popup to close it"));
    }
  }

  // Dialog Panel
  private static class MyDialog extends DialogBox
  {
    public MyDialog()
    {
      // Set the dialog box's caption.
      setText("My First Dialog");

      // DialogBox is a SimplePanel, so you have to set it's widget property to
      // whatever you want its contents to be.
      Button ok = new Button("OK");
      ok.addClickListener(new ClickListener()
      {
        public void onClick(Widget sender)
        {
          MyDialog.this.hide();
        }
      });

      setWidget(ok);
    }
  }

}
