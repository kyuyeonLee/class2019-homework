package shape;

import java.awt.Graphics;

public class Polygon extends Shape{
	
	private final static int nMaxPoints = 20;
	private int nPoints;
	private int[] xPoints;
	private int[] yPoints;
	
	public Polygon() {
		this.nPoints = 0;
		this.xPoints = new int[nMaxPoints];
		this.yPoints = new int[nMaxPoints];
		
	}
	
	public void setOrigin(int x,int y) {
		//���� �ϳ� �߰��ϴ� ���� �Ʒ� 3�ٷ� ����.. -> ���� �߰��Ѵٴ� ���� ���翡 npoint�� ���ο����� �߰��ϰ� npoint�� +1���ش�
		this.xPoints[this.nPoints] = x;  
		this.yPoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;

		this.xPoints[this.nPoints] = x; 
		this.yPoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;
	}
	
	public void setPoint(int x, int y) {
		this.xPoints[this.nPoints-1] = x;
		this.yPoints[this.nPoints-1] = y;
	}
	
	public void addPoint(int x, int y) {
		this.xPoints[this.nPoints] = x; 
		this.yPoints[this.nPoints] = y;
		this.nPoints = this.nPoints +1;
	}
	
	public void draw(Graphics g) {
		g.drawPolygon(xPoints, yPoints, nPoints);
	}
}
