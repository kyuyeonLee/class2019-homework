package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private MouseHandler mouseHandler;

	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(new MouseMotionHandler());
	}

	Vector<Point> startPoint = new Vector<Point>();
	Vector<Point> endPoint = new Vector<Point>();

	private class MouseHandler implements MouseListener {
		public void mousePressed(MouseEvent e) {
			startPoint.add(e.getPoint());
			endPoint.add(e.getPoint());
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	private class MouseMotionHandler implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			endPoint.set(endPoint.size() - 1, e.getPoint());
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < startPoint.size(); i++) {
			int P1 = Math.min(startPoint.get(i).x, endPoint.get(i).x);
			int P2 = Math.min(startPoint.get(i).y, endPoint.get(i).y);
			int Width = Math.abs(endPoint.get(i).x - startPoint.get(i).x);
			int Height = Math.abs(endPoint.get(i).y - startPoint.get(i).y);
			g.drawRect(P1, P2, Width, Height);

		}

	}
}
