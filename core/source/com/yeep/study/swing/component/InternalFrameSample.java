package com.yeep.study.swing.component;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultDesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class InternalFrameSample
{
	public static void main(String[] args)
	{
		InternalFrameSample sample = new InternalFrameSample();
		sample.init();
	}

	JFrame mainFrame;
	private JDesktopPane desk;

	/**
	 * initialize the sample
	 */
	public void init()
	{
		// create main frame
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// using desktopPane to contain the internalFrames
		desk = new JDesktopPane();
		mainFrame.setContentPane(desk);
		desk.setDesktopManager(new DesktopPaneManager());

		this.createMenuBar();
		this.loadBackgroundImage();
		mainFrame.setSize(300, 220);
		mainFrame.setVisible(true);
	}

	protected void createMenuBar()
	{
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Frames");

		menu.add(new AddFrameAction(true)); // Add "upper" frame.
		menu.add(new AddFrameAction(false)); // Add "lower" frame.
		menu.add(new TileAction(desk)); // Add tiling capability.

		this.mainFrame.setJMenuBar(mb);
		mb.add(menu);
	}

	protected void loadBackgroundImage()
	{
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"resources/moon.jpg"));
		JLabel l = new JLabel(icon);
		l.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.desk.add(l, new Integer(Integer.MIN_VALUE));
	}

	// Inner classes
	class AddFrameAction extends AbstractAction
	{
		public AddFrameAction(boolean upper)
		{
			super(upper ? "Add Upper Frame" : "Add Lower Frame");
			if (upper)
			{
				this.layer = new Integer(2);
				this.name = "Up";
			}
			else
			{
				this.layer = new Integer(1);
				this.name = "Low";
			}
		}

		public void actionPerformed(ActionEvent ev)
		{
			// Constructor: JInternalFrame(String title, boolean resizable, boolean
			// closable, boolean maximizable, boolean iconifiable)
			JInternalFrame iframe = new JInternalFrame(name, true, true, true, true);
			iframe.setBounds(0, 0, 120, 60);
			desk.add(iframe, layer);
			iframe.setVisible(true);
		}

		private Integer layer;
		private String name;
	}
}

class DesktopPaneManager extends DefaultDesktopManager
{
	// This is called whenever a frame is moved. This implementation keeps the
	// frame from leaving the desktop.
	public void dragFrame(JComponent frame, int x, int y)
	{
		if (frame instanceof JInternalFrame)
		{
			// Deal only with internal frames.
			JInternalFrame iframe = (JInternalFrame) frame;
			JDesktopPane desk = iframe.getDesktopPane();
			Dimension d = desk.getSize();

			// Nothing all that fancy below, just figuring out how to adjust
			// to keep the frame on the desktop
			if (x < 0)
			{ // Too far left?
				x = 0; // Flush against the left side.
			}
			else
			{
				if (x + frame.getWidth() > d.width)
				{ // Too far right?
					x = d.width - frame.getWidth(); // Flush against right side.
				}
			}
			if (y < 0)
			{ // Too high?
				y = 0; // Flush against the top.
			}
			else
			{
				if (y + frame.getHeight() > d.height)
				{ // Too low?
					y = d.height - frame.getHeight(); // Flush against the bottom.
				}
			}
		}

		// Pass along the (possibly cropped) values to the normal drag handler.
		super.dragFrame(frame, x, y);
	}
}

class TileAction extends AbstractAction
{
	private JDesktopPane desk; // The desktop to work with

	public TileAction(JDesktopPane desk)
	{
		super("Tile Frames");
		this.desk = desk;
	}

	public void actionPerformed(ActionEvent ev)
	{
		// How many frames do we have?
		JInternalFrame[] allframes = desk.getAllFrames();
		int count = allframes.length;
		if (count == 0)
			return;

		// Determine the necessary grid size.
		int sqrt = (int) Math.sqrt(count);
		int rows = sqrt;
		int cols = sqrt;
		if (rows * cols < count)
		{
			cols++;
			if (rows * cols < count)
			{
				rows++;
			}
		}

		// Define some initial values for size and location.
		Dimension size = desk.getSize();

		int w = size.width / cols;
		int h = size.height / rows;
		int x = 0;
		int y = 0;

		// Iterate over the frames, deiconifying any iconified frames and then
		// relocating and resizing each.
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols && ((i * cols) + j < count); j++)
			{
				JInternalFrame f = allframes[(i * cols) + j];

				if (!f.isClosed() && f.isIcon())
				{
					try
					{
						f.setIcon(false);
					}
					catch (PropertyVetoException ignored)
					{
					}
				}

				desk.getDesktopManager().resizeFrame(f, x, y, w, h);
				x += w;
			}
			y += h; // Start the next row.
			x = 0;

		}

	}
}
