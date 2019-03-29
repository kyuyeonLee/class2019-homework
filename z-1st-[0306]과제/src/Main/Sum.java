package Main;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		System.out.print("숫자를 입력 하세요 >> ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum = sum + i;
		}
		System.out.println("1~" + num + "까지의 합은 " + sum + "입니다.");
		scanner.close();
	}
}
