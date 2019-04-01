

package shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape{
	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
	public void stroke(Graphics g) {
		float[] dash1 = { 1, 3.0f };
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
		g.drawLine(x1, y1, x2, y2);
	}
	public void clear(Graphics g) {
	}
	@Override
	public void polygon(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
