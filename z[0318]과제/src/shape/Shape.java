package shape;

import java.awt.Graphics;

public abstract class Shape{
	protected int x, y, width, height;
	abstract public void draw(Graphics g, int x, int y, int width, int height);
	abstract public void clear(Graphics g, int x, int y, int width, int height);
	abstract public void stroke(Graphics g, int x, int y, int width, int height);
}
