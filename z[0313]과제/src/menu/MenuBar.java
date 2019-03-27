package menu;

import javax.swing.JMenuBar;

import drawingpanel.DrawingPanel;


public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private FileMenu fileMenu;

	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public MenuBar() {
		this.fileMenu = new FileMenu("File");
		this.add(this.fileMenu);
	}

}
