import java.io.IOException;

public class Array {

	public static void main(String[] args) throws IOException {
		int array[];
		array = new int[20]; //이름하고 실제 ㅁ메모리가  -> 바인딩
		boolean isNumber = true; 
		
		array[0] = 0; //고유의 이름을 주겟느냐 순서를 주겠느냐
		
		int index = 0;
		int keyvalue = System.in.read();
		while (!(keyvalue == 0x0D||keyvalue == 0x0A)) {
			if(!(keyvalue<'0' || keyvalue>'9')) {
				isNumber = false;
			}
			array[index] = keyvalue;
			index = index +1;
			keyvalue = System.in.read();//숫자인지 아닌지 판단하려고 array를 잡으라는 것이다.
		}
		if (isNumber) {
			
		}
	}

}
