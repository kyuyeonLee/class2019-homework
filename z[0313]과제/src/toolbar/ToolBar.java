package toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import drawingpanel.DrawingPanel;
import global.Constants;
import global.Constants.EToolBar;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	private Vector<JToggleButton> buttons;
	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();
		this.buttons = new Vector<JToggleButton>();
		for (EToolBar eToolBar : EToolBar.values()) {
			JToggleButton button = new JToggleButton(eToolBar.getText());
			button.setIcon(new ImageIcon(Constants.library + eToolBar + Constants.imageSufix));
			button.setSelectedIcon(new ImageIcon(Constants.library + eToolBar + Constants.imageSufix));
			button.setActionCommand(eToolBar.getText());
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button);
		}
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawingPanel.setCurrentTool(e.getActionCommand());
		}
	}
}
