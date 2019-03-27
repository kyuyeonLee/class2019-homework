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
		// ���콺 Ŭ���̶� �����̴� ���� ���� ���� �޾ƾ��ϴµ� �ѹ��� ����
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
	
	
//Ŭ�� ����Ŭ�� ������ �ؾ���. e.getclickcount
//������ ��ǥ�� ���ͷ� �޾Ƽ� �̰Ÿ� for���� �̿��ؼ� array�� ����.
	
	
	
	
	private class MouseHandler implements MouseListener, MouseMotionListener {// �Լ� ȣ�� �� �ϰ� �϶�.
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
