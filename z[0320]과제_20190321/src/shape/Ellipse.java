package shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends Shape{
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.drawOval(x, y, width, height);
	}
	
	public void clear(Graphics g, int x, int y, int width, int height) {
	}

	public void stroke(Graphics g, int x, int y, int width, int height) {
		float[] dash1 = {1,2.0f};
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash1,0));
		g.drawOval(x, y, width, height);		
	}

	@Override
	public void polystroke(Graphics g, int x, int y, int n) {
		// TODO Auto-generated method stub
		
	}
}
