package transform;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Vector;

import main.GEConstants.EPointerState;
import shapes.*;

public class GEResizer extends GETransformer {

	public GEResizer(GEShape shape) {
		super(shape);
		if(shape instanceof GEGroup) {
			shapelist = new Vector<GEShape>();
			for(GEShape subshape : ((GEGroup) shape).getSubShapes()) {
				shapelist.add(subshape);
			}
		}
		af = new AffineTransform();
	}

	public void init(int x, int y) {
		oldX = shape.getShape().getBounds().x;
		oldY = shape.getShape().getBounds().y;
	}

	public void Transform(int x, int y, EPointerState pointer) {
		Point2D.Double ratio = new Point2D.Double();
		Point move = new Point();
		int width = shape.getShape().getBounds().width;
		int height = shape.getShape().getBounds().height;
		
/*-----------------------------------------------------------------------------------------------------------------*/
		
		move.x = -oldX; move.y = -oldY;
		af.setToTranslation(move.x, move.y); // �������� �̵���Ŵ
			
		if(shape instanceof GEGroup) { // �׷��̸� ���� ���Һ���
			GEShape temp;
			for(int i=0; i < shapelist.size(); i++) {
				temp = shapelist.get(i);
				temp.setShape(af.createTransformedShape(temp.getShape()));
			}
		}
		
		shape.setShape(af.createTransformedShape(shape.getShape())); // �ڽ� ����
		
/*-----------------------------------------------------------------------------------------------------------------*/
		
		/* ��ǥ���� */
		switch (pointer) {
		case NE: //��
			ratio.x = (double)(x - oldX) / (width);
			ratio.y = (double)(oldY - y + height) / (height);
			move.x = oldX; move.y = y;
			oldY = y;
			break;
		case EE: //��
			ratio.x = (double)(x - oldX) / (width);
			ratio.y = 1;
			move.x = oldX; move.y = oldY;
			break;
		case SE: //��
			ratio.x = (double)(x - oldX) / (width);
			ratio.y = (double)(y - oldY) / (height);
			move.x = oldX; move.y = oldY;
			break;
		case SS: //��
			ratio.x = 1;
			ratio.y = (double)(y - oldY) / (height);
			move.x = oldX; move.y = oldY;
			break;
		case SW: //��
			ratio.x = (double)(oldX - x + width) / (width);
			ratio.y = (double)(y - oldY) / (height);
			move.x = x; move.y = oldY;
			oldX = x; 
			break;
		case WW: //��
			ratio.x = (double)(oldX - x + width) / (width);
			ratio.y = 1;
			move.x = x; move.y = oldY;
			oldX = x;
			break;
		case NW: //��
			ratio.x = (double)(oldX - x + width) / (width);
			ratio.y = (double)(oldY - y + height) / (height);
			move.x = x; move.y = y;
			oldX = x; oldY = y;
			break; 
		case NN: // ��
			ratio.x = 1;
			ratio.y = (double)(oldY - y + height) / (height);
			move.x = oldX; move.y = y;
			oldY = y;
			break;
		}

/*-----------------------------------------------------------------------------------------------------------------*/
		
		af.setToScale(ratio.x, ratio.y); // ����(0,0)�������� ������ǥ���� '�Ÿ�'�� �ش� ���������� �÷���..
			
		if(shape instanceof GEGroup) { // �׷��̸� ���� ���Һ���
			GEShape temp;
			for(int i=0; i < shapelist.size(); i++) {
				temp = shapelist.get(i);
				temp.setShape(af.createTransformedShape(temp.getShape()));
			}
		}
		
		shape.setShape(af.createTransformedShape(shape.getShape())); // �ڽź���
		
/*-----------------------------------------------------------------------------------------------------------------*/
		
		af.setToTranslation(move.x, move.y); // ���� ��ġ���� �Լ����� ����ŭ ��ǥ��ŭ �̵� (�������� ������ǥ�� �Ÿ����� �Լ����� ������)
		
		if(shape instanceof GEGroup) { // �׷��̸� ���� ���Һ���
			GEShape temp;
			for(int i=0; i < shapelist.size(); i++) {
				temp = shapelist.get(i);
				temp.setShape(af.createTransformedShape(temp.getShape()));
			}
		}
		
		shape.setShape(af.createTransformedShape(shape.getShape())); // �ڽź���

/*-----------------------------------------------------------------------------------------------------------------*/
		
		shape.getAnchor().resize(shape.getShape().getBounds());
	}

	@Override
	public void Transform(int x, int y) {}
}
