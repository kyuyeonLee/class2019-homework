package shape;

import java.awt.Graphics;

public class Line extends Shape{
	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
}
