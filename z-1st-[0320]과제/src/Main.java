import java.io.IOException;
import java.util.Vector;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean mode = true;
		Vector<Integer> input; 
		input = new Vector<Integer>();
		int conversion = 0;
		int number = 0;
		while (mode) {
			System.out.print("점수를 입력하세요 : ");
			//입력&판별
			for (int keyvalue = System.in.read(); keyvalue != 0x0D; keyvalue = System.in.read()) {
				if (!(keyvalue < '0' || keyvalue > '9')) {
					input.add(keyvalue);
				} else {
					mode = false;
				}
			}
			System.out.println("input값 : " + input);
			
			//변환
			for (int i = 0; i < input.size(); i++) {
				conversion = input.get(i) - 48;
				number = number * 10 + conversion;
			}
			System.out.println("변환된 값 : " + number);
			System.in.read();
			
			//성적계산
			if (mode == false) {
				System.out.println("잘못 입력하셨습니다.(문자입력)");
			} else if (number > 100) {
				System.out.println("잘못 입력 하셨습니다.(1)");
			} else if (number > 90) {
				System.out.println("점수 : " + number + "점\n등급 : A");
			} else if (number > 80) {
				System.out.println("점수 : " + number + "점\n등급 : B");
			} else if (number > 70) {
				System.out.println("점수 : " + number + "점\n등급 : C");
			} else if (number > 60) {
				System.out.println("점수 : " + number + "점\n등급 : D");
			} else if (number >= 0) {
				System.out.println("점수 : " + number + "점\n등급 : F");
			} else {
				System.out.println("잘못 입력 하셨습니다.(2)");
			}
			input.removeAllElements();
			number = 0;
		}
	}
}
