package global;

public class Constants {

	public enum EMainFrame {
		x(200),
		y(100),
		w(400),
		h(600)
		;
		private int vlaue;
		private EMainFrame(int value) {
			this.vlaue = value;
		}
		public int getvalue() {
			return this.vlaue;
		}
	}
	
	public enum EToolBar {
		select("select"),
		rectangle("rectangle"),
		ellipse("ellipse"),
		line("line"),
		;
		private String text;
		private EToolBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public static String imageSufix = ".gif";
	public static String library = "img/";
	
	
	public enum EMenu {
		filemenu("파일"),
		editmenu("Edit"),
		;
		private String text;
		private EMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

	public enum EFilemenu {
		newItem("새로만들기"),
		openItem("Open"),
		;
		private String text;
		private EFilemenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}

}
