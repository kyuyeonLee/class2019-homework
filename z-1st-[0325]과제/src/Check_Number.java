import java.io.IOException;

public class Check_Number {

	public static void main(String[] args) throws IOException {
		int array[];
		array = new int[20];
		boolean isNumber = true;

		array[0] = 0;
		int number = 0;
		int index = 0;
		int keyvalue = System.in.read();
		while (!(keyvalue == 0x0D || keyvalue == 0x0A)) {
			if (keyvalue < '0' || keyvalue > '9') {
				isNumber = false;
			}
			array[index] = keyvalue;
			index = index + 1;
			keyvalue = System.in.read();
		}
		if (isNumber != false) {
			for (int i = 0; i < index; i++) {
				array[i] = array[i] - 48;
				number = number * 10 + array[i];
			}
			System.out.print(number);
		} else {
			System.out.println("숫자를 입력하세요!");
		}
	}
}
