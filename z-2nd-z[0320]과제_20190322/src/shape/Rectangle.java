package shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shape {

	public void clear(Graphics g, int x, int y, int width, int height) {
	}
	public void polystroke(Graphics g, int x, int y, int n) {
	}
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}
	public void stroke(Graphics g, int x, int y, int width, int height) {
		float[] dash1 = { 1, 5.0f };
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
		g.drawRect(x, y, width, height);
	}
}
