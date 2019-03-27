package main;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import drawingpanel.DrawingPanel;
import global.Constants.EMainFrame;
import menu.MenuBar;
import toolbar.ToolBar;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	
	//mainframe �������� ����� �ڽ�������(�ִ� ���� ��ӹ޾Ƽ�)
	public MainFrame() {//constructor
		//attributes
		this.setLocation(EMainFrame.x.getvalue(), EMainFrame.y.getvalue()); 
		this.setSize(EMainFrame.w.getvalue(), EMainFrame.h.getvalue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
		this.menuBar = new MenuBar();
		this.setJMenuBar(this.menuBar);
		
		this.toolBar = new ToolBar();
		this.add(this.toolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new DrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);
		
		this.menuBar.associate(this.drawingPanel);
		this.toolBar.associate(this.drawingPanel);
	}
}
