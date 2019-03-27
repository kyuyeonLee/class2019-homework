package frames;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import menus.GEMenuBar;


public class GEMainFrame extends JFrame {

	private GEMenuBar menuBar;
	private GEToolBar toolBar;
	private GEDrawingPanel drawingPanel;
	
	public GEMainFrame() {
		super();
		
		// set x,y position
		setLocation(100, 100);
		// set width, height
		setSize(400, 600);
		// close ��ư ������ ���α׷� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �ʱ⿡ ���̱�
		
		// new components
		menuBar = new GEMenuBar();
		this.setJMenuBar(menuBar);
		toolBar = new GEToolBar();
		this.add(BorderLayout.NORTH, toolBar);
		drawingPanel = new GEDrawingPanel();
		//drawingPanel.setBackground(Color.white);
		this.add(drawingPanel);
		
		// initialize components functions
		setVisible(true);
	}

	public void initialize() {
		// set association
		//toolBar.setPanel(drawingPanel);
		//menuBar.setPanel(drawingPanel);
		
		//initialize associated functions
		toolBar.initialize(drawingPanel);
		menuBar.initialize(drawingPanel);
		drawingPanel.initialize();
		
	}
	
	
}
