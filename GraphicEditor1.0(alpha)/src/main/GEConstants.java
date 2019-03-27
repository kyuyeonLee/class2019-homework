package main;
import shapes.*;


public class GEConstants {

	public static enum EMenus {
		File("����"), Edit("����"), Color("����");
		private String name;
		private EMenus(String s) {this.name = s;}
		public String getName() {return this.name;}
	}
	
	public static enum EFileMenuItems {
		nnew("���θ����"), open("����"), save("����"), exit("����");
		private String name;
		private EFileMenuItems(String s) {this.name = s;}
		public String getName() {return this.name;}
	}
	
	public static enum EEditMenuItems {
		redo("�����"), undo("�������"), copy("����"), cut("�߶󳻱�"), paste("�ٿ��ֱ�"), delete("����"), group("�׷�"), ungroup("�׷�����");
		private String name;
		private EEditMenuItems(String s) {this.name = s;}
		public String getName() {return this.name;}
	}
	
	public static enum EColorMenuItems {
		lineColor("����"), fillColor("���"), clearLineColor("���� �ʱ�ȭ"), clearFillColor("��� �ʱ�ȭ");
		private String name;
		private EColorMenuItems(String s) {this.name = s;}
		public String getName() {return this.name;}
	}
	
	public static enum EToolBarButtons {
		group("�׷�", GESelect.class.getName()), // �׸��°��� �簢������ �׸��� GEGroup�� Panel ����� ���� ó���Ѵ�
		rectangle("�簢��", GERectangle.class.getName()),
		ellipse("��", GEEllipse.class.getName()),
		line("��", GELine.class.getName()),
		polygon("�ٰ���", GEPolygon.class.getName());
		
		private String label;
		private String className;
		private EToolBarButtons(String label, String className) {
			this.label = label;
			this.className = className;
		}
		public String getLabel() {return this.label;}
		public String getClassName() {return className;}
	}
	
	public static enum EShapeType {
		TP, NP, GR
	}
	
	public static final String imageSufix = ".gif";
	public static final String libraryPath = "img/";
	public static final String selectedImage = "SLT";
	
	public static enum EPointerState {
		NW, WW, SW, NN, SS, NE, EE, SE, RR, MM
	}
	
}
