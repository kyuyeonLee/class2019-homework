package Main;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.print("문자를 입력하세요 >> ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String KeyBoard = scanner.next();
		
		System.out.println("입력하신 문자는 " + "'" + KeyBoard + "'" + "입니다.");
	}
	
}
