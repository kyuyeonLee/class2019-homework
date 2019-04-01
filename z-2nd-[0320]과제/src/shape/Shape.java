package shape;

import java.awt.Graphics;
import java.util.Vector;

public abstract class Shape{
	protected int x1, y1, x2, y2;
	protected Vector<Integer> xvect, yvect;
	public void setOrigin(int x,int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
		this.xvect.add(x);
		this.yvect.add(y);
	}
	
	public void setPoint(int x, int y) {
		this.x2 = x;
		this.y2 = y;
		this.xvect.add(x);
		this.yvect.add(y);
	}
	
	abstract public void draw(Graphics g);
	abstract public void stroke(Graphics g);
	abstract public void clear(Graphics g);
	abstract public void polygon(Graphics g);
}
