package shape;

import java.awt.Graphics;

public class Select extends Shape {
	public void draw(Graphics g, int x, int y, int width, int height) {
//		g.drawRect(x, y, width, height);
	}

	public void clear(Graphics g, int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}

	public void stroke(Graphics g, int x, int y, int width, int height) {
	}
}
