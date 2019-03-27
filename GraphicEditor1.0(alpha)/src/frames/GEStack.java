package frames;

import java.util.Vector;

import shapes.GEShape;

public class GEStack {

	private Vector<Vector<GEShape>> data;
	private int num;
	
	public GEStack() {
		data = new Vector<Vector<GEShape>>();
		num = 0;
	}
	
	public void push(Vector<GEShape> shapes) {
		//System.out.println("         �������� : " + shapes.size() + " / ���ü� : " + num + " / ���ð��� :  " + data.size());
		Vector<GEShape> temp = new Vector<GEShape>();
		
		if(num < data.size()){
			//System.out.println(num +"������ " + data.size() + "�� ���� �ʱ�ȭ");
			for(int i=data.size()-1; num <= i; i--) {
				//System.out.println(i + "���ʱ�ȭ");
				data.remove(i);
			}
		}
		
		for(int i=0; i<shapes.size(); i++) {
			temp.add(shapes.get(i).deepcopy());
		}
		data.add(temp);
		num++;
		//System.out.println("�ֱ�]�������� : " + shapes.size() + " / ���ü� : " + num + " / ���ð��� :  " + data.size());
	}
	
	/**
	 * 
	 * @param param = +1 : redo
	 * 		  param = -1 : undo
	 * @return
	 */
	public Vector<GEShape> pop(int param) {
		if(num <= data.size()) {
			num = num + param;
		}
		//System.out.print((param > 0 ? "����" : "���") + (num) +"��°] ");
		//System.out.println("���ü� : " + num + " / ���ð��� : " + data.size());
		Vector<GEShape> temp = null;
		
		if(num > 0 && num <= data.size()) {
			temp = data.get(num-1); // 
		} else if(num == data.size()) {
			temp = data.lastElement();
		}
				
		//System.out.println("���  ���ü� : " + num + " / ���ð��� : " + data.size());
		return temp;
	}
	
	public int getStacksize() {
		return num;
	}
	
	public void clear() {
		data.clear();
	}
}
