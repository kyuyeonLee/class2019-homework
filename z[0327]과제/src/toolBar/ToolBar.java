package toolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import drawingPanel.DrawingPanel;
import global.Constants;
import global.Constants.EToolBar;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar{

	// components
		private Vector<JRadioButton> buttons; 
		
		// association
		private DrawingPanel drawingPanel;

		private ButtonGroup buttonGroup;

		public void associate(DrawingPanel drawingPanel) {
			this.drawingPanel = drawingPanel;
		}
		public ToolBar() {
			ActionHandler actionHandler = new ActionHandler();
			this.buttons = new Vector<JRadioButton>();
			this.buttonGroup = new ButtonGroup();
			for (EToolBar eToolBar: EToolBar.values()) {
				JRadioButton button = new JRadioButton();
				button.setIcon(new ImageIcon(Constants.library + eToolBar.name() + Constants.imageSufix));
				button.setSelectedIcon(new ImageIcon(Constants.library + eToolBar.name() + Constants.selectedImage + Constants.imageSufix));
				button.setActionCommand(eToolBar.name());
				button.addActionListener(actionHandler);
				this.buttons.add(button);
				this.buttonGroup.add(button);
				this.add(button);
			}
		}
		public void initialize(DrawingPanel drawingpanel) {
			this.drawingPanel = drawingpanel;
			buttons.get(EToolBar.rectangle.ordinal()).doClick();
		}
		private class ActionHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				drawingPanel.setCurrentTool(EToolBar.valueOf(e.getActionCommand()));
			}
	}
}

