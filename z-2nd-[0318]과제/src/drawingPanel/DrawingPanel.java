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

	public void setCurrentTool(Shape CurrenTool) {
		this.currentTool = CurrenTool;
	}

	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		// 마우스 클릭이랑 움직이는 것을 따로 따로 달아야하는데 한번에 달음
		mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
//		currentTool = EToolBar.select.getShape();
	}

	public void drawShape(int x, int y, int w, int h) {
		Graphics g = this.getGraphics();
		g.setXORMode(getBackground());
		this.currentTool.draw(g, x, y, w, h);
	}

	public void clearShape(int x, int y, int w, int h) {
		Graphics g = this.getGraphics();
		g.setXORMode(getBackground());
		this.currentTool.clear(g, x, y, w, h);
	}
	public void strokeShape(int x, int y, int w, int h) {
		Graphics g = this.getGraphics();
		g.setXORMode(getBackground());
		this.currentTool.stroke(g, x, y, w, h);
	}
	private class MouseHandler implements MouseListener, MouseMotionListener {// 함수 호출 만 하게 하라.
		private int x0, y0, x1, y1;

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			x0 = e.getX();
			y0 = e.getY();
			x1 = e.getX();
			y1 = e.getY();
			strokeShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
			clearShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
		}

		public void mouseReleased(MouseEvent e) {
			drawShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
			strokeShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
		}

		public void mouseDragged(MouseEvent e) {
			clearShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
			strokeShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
			x1 = e.getX();
			y1 = e.getY();
			clearShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
			strokeShape(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}
	}
}
