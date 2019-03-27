

package shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends Shape{
	public void draw(Graphics g) {
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
	}
	public void stroke(Graphics g) {
		float[] dash1 = { 1, 3.0f };
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
	}
	public void clear(Graphics g) {
	}

	public void polygon(Graphics g) {
	}
}
