import java.io.IOException;

public class Main_1st {

	public static void input(int arrayNumber[], int index, Boolean isNumber, String realNum, long number)
			throws IOException {// ���п��� �Լ� f �� ���� �ǹ�
//////////////��Ŷ����� ����� �Ķ��Ÿ�� ��ſ��� ���� ��������� ��//////////
/////////////////////// input Buffering/ ///////////////////////
////////////////////////////////////////////////////////////////
		int keyvalue = System.in.read();
		while (!(keyvalue == 0x0D || keyvalue == 0x0A)) {
			if (index >= 20) {
				System.out.println("���� ������ Index�� �ʰ��ƽ��ϴ�.");
				System.out.print("arrayNumber[20]���� ����� ���� -> ");
				break;
			}
			if (keyvalue < '0' || keyvalue > '9') {
				isNumber = false;
			}
			arrayNumber[index] = keyvalue;
			index = index + 1;
			keyvalue = System.in.read();
		}
		keyvalue = System.in.read();
		stringToInt(arrayNumber, index, isNumber, realNum, number);
	}

	public static void stringToInt(int arrayNumber[], int index, Boolean isNumber, String realNum, long number)
			throws IOException {
//////////////////////////////////////////////////////////////////////////
/////////////////////// ascii to integer ///////////////////////////////
///////////////////////////////////////////////////////////////////////
		if (isNumber) { // number < 2^32
			for (int i = 0; i < index; i++) {
				if ((long) (number * 10) + arrayNumber[i] - 48 >= Math.pow(2, 31)) {
					for (int j = 0; j < index; j++) {
						realNum += (char) arrayNumber[j];
					}
					System.out.println("IntegerOverFlowException : " + realNum);
					System.out.println("Index Number : " + index);
					break;
				} else {
					number = number * 10 + arrayNumber[i] - '0';
				}
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws IOException {
		Boolean isNumber = true;
		String realNum = "";
		int index = 0;
		long number = 0L;
		int arrayNumber[] = new int[20];
		input(arrayNumber, index, isNumber, realNum, number);
	}
}
