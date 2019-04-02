import java.io.IOException;

public class Main_2nd {

	public static Object input(int arrayNumber[], int index, Boolean isNumber) throws IOException {// 수학에서 함수 f 와 같은 의미
//////////////통신라인을 만들어 파라메타로 통신에서 가장 좋은방법은 ㄴ//////////
/////////////////////// input Buffering/ ///////////////////////
////////////////////////////////////////////////////////////////
		Object o = new Object();
		int keyvalue = System.in.read();
		while (!(keyvalue == 0x0D || keyvalue == 0x0A)) {
			if (index >= 20) {
				System.out.println("저장 가능한 Index가 초과됐습니다.");
				System.out.print("arrayNumber[20]까지 저장된 숫자 -> ");
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

		o.setArrayNumber(arrayNumber);
		o.setIndex(index);
		o.setIsNumber(isNumber);
		return o;
	}

	public static Object stringToInt(int arrayNumber[], int index, Boolean isNumber, String realNum, long number)
			throws IOException {
//////////////////////////////////////////////////////////////////////////
/////////////////////// ascii to integer ///////////////////////////////
///////////////////////////////////////////////////////////////////////
		Object o2 = new Object();
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
		return o2;
	}

	public static void main(String[] args) throws IOException {
		Boolean isNumber = true;
		String realNum = "";
		int index = 0;
		long number = 0L;
		int arrayNumber[] = new int[20];

		Object o = input(arrayNumber, index, isNumber);
//		System.out.println(a.toString());
		o.getArrayNumber();
		o.getIndex();
		o.getIsNumber();
		stringToInt(o.getArrayNumber(), o.getIndex(), o.getIsNumber(), realNum, number);
	}
}
