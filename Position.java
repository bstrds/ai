
public class Position {
	
	boolean isBlack;
	byte numOfPills;
	public Position() {
		numOfPills = 0;
	}
	public Position(boolean isB, byte numP) {
		isBlack = isB;
		numOfPills = numP;
	}
	public void increase() {
		numOfPills++;
	}
	public void decrease() {
		numOfPills--;
	}
	public boolean getCol(){
		return isBlack;
	}
	public void setCol(boolean col) {
		this.isBlack = col;
	}
	public byte getNum() {
		return numOfPills;
	}
	public void setNum(byte num) {
		this.numOfPills = num;
	}
}
