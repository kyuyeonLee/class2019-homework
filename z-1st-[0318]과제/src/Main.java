import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Boolean b = true;
		while (b) {
			int number = 0;
			for (int keyvalue = System.in.read(); keyvalue != 0x0D; keyvalue = System.in.read()) {
				if (keyvalue < 48 || keyvalue > 57) {
					System.out.println("프로그램이 종료됩니다.");
					b = false;
				} else {
					keyvalue = keyvalue - 0x30;
					number = number * 10 + keyvalue;
				}
			}
			System.in.read();
			if (b != false) {
				System.out.println(number);
				if (number > 100) {
					System.out.println("잘못 입력 하셨습니다.(1)");
				} else if (number > 90) {
					System.out.println("A");
				} else if (number > 80) {
					System.out.println("B");
				} else if (number > 70) {
					System.out.println("C");
				} else if (number > 60) {
					System.out.println("D");
				} else if (number >= 0) {
					System.out.println("F");
				} else {
					System.out.println("잘못 입력 하셨습니다.(2)");
				}
			}
		}
	}
}// while