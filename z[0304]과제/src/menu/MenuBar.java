package menu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private FileMenu fileMenu;
	
	public MenuBar() {
		this.fileMenu = new FileMenu("File");
		this.add(this.fileMenu);
	}

}
