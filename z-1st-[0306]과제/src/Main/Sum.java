package Main;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		System.out.print("���ڸ� �Է� �ϼ��� >> ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum = sum + i;
		}
		System.out.println("1~" + num + "������ ���� " + sum + "�Դϴ�.");
		scanner.close();
	}
}
