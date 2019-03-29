import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		int key = 0;
		int num = 0;
		int sum = 0;
		int i = 1;

		while (i == 1) {
			key = System.in.read();
			if (key == 'x') {
				i = 0;
			} else {
				key = key - '0';
				num = num * 10 + key;
			}
		}
		System.out.println("Мі : " + num);
		for (int j = 1; j <= num; j++) {
			sum = sum + j;
		}
		System.out.println("Че: " + sum);
	}
}
