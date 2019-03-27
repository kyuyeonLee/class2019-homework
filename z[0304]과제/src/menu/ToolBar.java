package menu;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	private JButton selectButton;
	
	public ToolBar() {
	this.selectButton = new JButton("select");
	this.add(this.selectButton);
	}
}
