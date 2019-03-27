package transform;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Vector;

import shapes.GEGroup;
import shapes.GEShape;

public class GERotater extends GETransformer {
	protected Point2D.Double ROrigin;
	protected double theta;

	public GERotater(GEShape shape) {
		super(shape);
		if(shape instanceof GEGroup) {
			shapelist = new Vector<GEShape>();
			for(GEShape subshape : ((GEGroup) shape).getSubShapes()) {
				shapelist.add(subshape);
			}
		}
		af = new AffineTransform();
	}

	@Override
	public void init(int x, int y) {
		// ȸ���� ������ �߽��� ���մϴ�
		ROrigin = new Point2D.Double(shape.getShape().getBounds().getCenterX(), shape.getShape().getBounds().getCenterY());
		//  ���콺 �����Ϳ� �߽����� �̷�� ���� ���մϴ�
		theta = Math.atan2(ROrigin.y - y, x - ROrigin.x);
	}

	@Override
	public void Transform(int x, int y) {
		// ó�� ���� ������ �̵��� ��(���콺 �����ͷ� ������ ����)�� ���մϴ�
		double theta2 = theta - Math.atan2(ROrigin.y - y, x - ROrigin.x);
		
		// AffineTrasform���� ȸ����ȯ��Ŵ
		af.setToRotation(theta2, ROrigin.x, ROrigin.y);
		//shape.getAnchor().rotate(theta2, ROrigin);
		shape.getAnchor().resize(shape.getShape().getBounds());
		
		if(shape instanceof GEGroup) { // �׷��̸� ���� ���Һ���
			GEShape temp;
			for(int i=0; i < shapelist.size(); i++) {
				temp = shapelist.get(i);
				temp.setShape(af.createTransformedShape(temp.getShape()));
				shape.setShape(shape.getShape().getBounds().createUnion(temp.getShape().getBounds()));
			}
		} else {
			shape.setShape(af.createTransformedShape(shape.getShape())); // �ڽ� ����
		}
		
		//shape.setShape(af.createTransformedShape(shape.getShape())); // �ڽ� ����
		theta = Math.atan2(ROrigin.y - y, x - ROrigin.x); // �̵��� �� ����
	}

}
