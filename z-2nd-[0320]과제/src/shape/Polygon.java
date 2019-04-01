package shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Polygon extends Shape {
	public void draw(Graphics g) {
	}
	

	public void polygon(Graphics g) {
		int[] xpoint = new int[xvect.size()];
		for (int i = 0; i < xvect.size(); i++) {
			xpoint[i] = xvect.get(i);
		}
		
		int[] ypoint = new int[yvect.size()];
		for (int i = 0; i < yvect.size(); i++) {
			ypoint[i] = yvect.get(i);
		}
		
		float[] dash1 = { 1, 2.0f };
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash1, 0));
		g.drawPolyline(xpoint, ypoint, xpoint.length );
	}

	public void clear(Graphics g) {
	}


	public void stroke(Graphics g) {
	}

}
