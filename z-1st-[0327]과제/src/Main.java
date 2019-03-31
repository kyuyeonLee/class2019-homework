import java.io.IOException;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Main {
	public static void main(String[] args) throws IOException {
////////////////////////////////////////////////////////////////
/////////////////////// input Buffering/ ///////////////////////
////////////////////////////////////////////////////////////////
		int index = 0;
		long number = 0;
		String realNum = "";
		int arrayNumber[] = new int[20];

		Boolean isNumber = true;
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
////////////////////////////////////////////////////////////////
/////////////////////// ascii to integer ///////////////////////
////////////////////////////////////////////////////////////////
		if (isNumber) { // number < 2^32
			for (int i = 0; i < index; i++) {
				if ((long) (number * 10 + arrayNumber[i] - 48) >= Math.pow(2, 31)) {
					for (int j = 0; j < index; j++) {
						realNum += (char) arrayNumber[j];
					}
					System.out.println("IntegerOverFlowException : " + realNum);
					System.out.println("Index Number : " + index);
					break;
				}
				number = (long) (number * 10 + arrayNumber[i] - '0');
			}
		}
	}
}
