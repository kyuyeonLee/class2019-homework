package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class ToolBar<DrawingButton> extends JToolBar {

	private static final long serialVersionUID = 1L;

	private JToggleButton selectButton;
	private JToggleButton rectangleButton;
	private JToggleButton ellipseButton;
	private JToggleButton LineButton;
	
	ImageIcon rectangleIcon = new ImageIcon("img/rectangle.gif");
	ImageIcon ellipseIcon = new ImageIcon("img/ellipse.gif");
	ImageIcon lineIcon = new ImageIcon("img/line.gif");
	
	ImageIcon rectPressIcon = new ImageIcon("img/rectangleSLT.gif");
	ImageIcon ellipsePressIcon = new ImageIcon("img/ellipseSLT.gif");
	ImageIcon linePressIcon = new ImageIcon("img/lineSLT.gif");
	
	
	
	
	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();
		
		this.selectButton = new JToggleButton("select");
		this.add(this.selectButton);
		this.selectButton.setActionCommand(this.selectButton.getName());
		this.selectButton.addActionListener(actionHandler);

		this.rectangleButton = new JToggleButton("Rectangle",rectangleIcon);
		this.add(this.rectangleButton);
		this.rectangleButton.setPressedIcon(rectPressIcon);
		this.rectangleButton.setActionCommand(this.rectangleButton.getName());
		this.rectangleButton.addActionListener(actionHandler);

		this.ellipseButton = new JToggleButton("Ellipse", ellipseIcon);
		this.add(this.ellipseButton);
		this.ellipseButton.setPressedIcon(ellipsePressIcon);
		this.ellipseButton.setActionCommand(this.ellipseButton.getName());
		this.ellipseButton.addActionListener(actionHandler);

		this.LineButton = new JToggleButton("Line", lineIcon);
		this.add(this.LineButton);
		this.LineButton.setPressedIcon(linePressIcon);
		this.LineButton.setActionCommand(this.LineButton.getName());
		this.LineButton.addActionListener(actionHandler);
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawingPanel.setCurrentTool(e.getActionCommand());
		}
	}
}
