import java.io.IOException;

public class Array {

	public static void main(String[] args) throws IOException {
		int array[];
		array = new int[20]; //�̸��ϰ� ���� ���޸𸮰�  -> ���ε�
		boolean isNumber = true; 
		
		array[0] = 0; //������ �̸��� �ְٴ��� ������ �ְڴ���
		
		int index = 0;
		int keyvalue = System.in.read();
		while (!(keyvalue == 0x0D||keyvalue == 0x0A)) {
			if(!(keyvalue<'0' || keyvalue>'9')) {
				isNumber = false;
			}
			array[index] = keyvalue;
			index = index +1;
			keyvalue = System.in.read();//�������� �ƴ��� �Ǵ��Ϸ��� array�� ������� ���̴�.
		}
		if (isNumber) {
			
		}
	}

}
