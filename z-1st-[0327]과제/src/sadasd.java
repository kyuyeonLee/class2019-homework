import java.io.IOException;
import java.util.Vector;

public class sadasd{
	public static void main(String[] args) throws IOException {
		boolean mode = true;
		Vector<Integer> input; 
		input = new Vector<Integer>();
		int conversion = 0;
		int number = 0;
		while (mode) {
			System.out.print("������ �Է��ϼ��� : ");
			//�Է�&�Ǻ�
			for (int keyvalue = System.in.read(); keyvalue != 0x0D; keyvalue = System.in.read()) {
				if (!(keyvalue < '0' || keyvalue > '9')) {
					input.add(keyvalue);
				} else {
					mode = false;
				}
			}
			System.out.println("input�� : " + input);
			
			//��ȯ
			for (int i = 0; i < input.size(); i++) {
				conversion = input.get(i) - 48;
				number = number * 10 + conversion;
			}
			System.out.println("��ȯ�� �� : " + number);
			System.in.read();
			
			//�������
			if (mode == false) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.(�����Է�)");
			} else if (number > 100) {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.(1)");
			} else if (number > 90) {
				System.out.println("���� : " + number + "��\n��� : A");
			} else if (number > 80) {
				System.out.println("���� : " + number + "��\n��� : B");
			} else if (number > 70) {
				System.out.println("���� : " + number + "��\n��� : C");
			} else if (number > 60) {
				System.out.println("���� : " + number + "��\n��� : D");
			} else if (number >= 0) {
				System.out.println("���� : " + number + "��\n��� : F");
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.(2)");
			}
			input.removeAllElements();
			number = 0;
		}
	}
}