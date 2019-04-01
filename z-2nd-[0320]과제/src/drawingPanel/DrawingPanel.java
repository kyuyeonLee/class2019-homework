package drawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.Shape;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final Enum<EToolBar> eToolBar = null;
	MouseHandler mouseHandler;
	private Shape currentTool;

	public void setCurrentTool(EToolBar CurrenTool) {
		this.currentTool = CurrenTool.getShape();
	}

	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		// 마우스 클릭이랑 움직이는 것을 따로 따로 달아야하는데 한번에 달음
		mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		currentTool = EToolBar.select.getShape();
	}
	
	public void drawShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.setOrigin(x, y);
		this.currentTool.draw(graphics);
	}
	
	public void moveShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		this.currentTool.draw(graphics);
	}

	public void strokeShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.stroke(graphics);
		this.currentTool.setPoint(x, y);
		this.currentTool.stroke(graphics);
	}
	
	public void polyshape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.polygon(graphics);
		this.currentTool.setPoint(x, y);
		this.currentTool.polygon(graphics);
	}
	
	public void clearShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.clear(graphics);
	}
	
	
//클릭 더블클릭 구분을 해야함. e.getclickcount
//폴리곤 좌표를 벡터로 받아서 이거를 for문을 이용해서 array에 넣음.
	
	
	
	
	private class MouseHandler implements MouseListener, MouseMotionListener {// 함수 호출 만 하게 하라.
		public void mouseClicked(MouseEvent e) {
			polyshape(e.getX(), e.getY());
		}

		public void mousePressed(MouseEvent e) {
			drawShape(e.getX(), e.getY());
		}

		public void mouseReleased(MouseEvent e) {
			moveShape(e.getX(), e.getY());
			clearShape(e.getX(), e.getY());
		}

		public void mouseDragged(MouseEvent e) {
			strokeShape(e.getX(), e.getY());
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}
	}
}
