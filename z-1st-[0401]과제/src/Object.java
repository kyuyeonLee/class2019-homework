import java.util.Arrays;

public class Object {
	private Boolean isNumber;
	private String realNum ;
	private int index ;
	private long number ;
	private int arrayNumber[];
	
	public Boolean getIsNumber() {return isNumber;}
	public void setIsNumber(Boolean isNumber) {this.isNumber = isNumber;}

	public String getRealNum() {return realNum;}
	public void setRealNum(String realNum) {this.realNum = realNum;}
	
	public int getIndex() {return index;}
	public void setIndex(int index) {this.index = index;}
	
	public long getNumber() {return number;}
	public void setNumber(long number) {this.number = number;}
	
	public int[] getArrayNumber() {return arrayNumber;}
	public void setArrayNumber(int[] arrayNumber) {this.arrayNumber = arrayNumber;}
	
	@Override
	public String toString() {
		return "Asd [isNumber=" + isNumber + ", realNum=" + realNum + ", index=" + index + ", number=" + number
				+ ", arrayNumber=" + Arrays.toString(arrayNumber) + "]";
	}
	
	
	
	
	
	
}
