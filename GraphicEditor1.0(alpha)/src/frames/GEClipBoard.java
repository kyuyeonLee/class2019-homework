package frames;

import java.util.Vector;

import shapes.GEShape;

public class GEClipBoard {
	
	private Vector<GEShape> clipBaord;
	
	public GEClipBoard() {
		clipBaord = new Vector<GEShape>();
	}
	
	public void add(GEShape shape) {
		
	}
	
	public Vector<GEShape> paste() {
		return (Vector<GEShape>) clipBaord.clone();
	}
	
	public void copy(Vector<GEShape> shapes) {
		clipBaord.clear(); // Ŭ������ ����ֱ�
		GEShape shape;
		for(int i=shapes.size(); i>0; i--) {
			shape = shapes.get(i-1);
			if(shape.isSelected()) {
				clipBaord.add(shape.deepcopy());
			}
		}
	}
	
	public void cut(Vector<GEShape> shapes) {
		clipBaord.clear(); // Ŭ������ ����ֱ�
		GEShape shape;
		for(int i=shapes.size(); i>0; i--) {
			shape = shapes.get(i-1);
			if(shape.isSelected()) {
				clipBaord.add(shape.deepcopy());
				shapes.remove(shape); // for-each�� ����ϸ� java.util.ConcurrentModificationException �߻��ؼ� �Ϲ� for������ ����
			}
		}
	}
}
