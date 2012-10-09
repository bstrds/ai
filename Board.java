// 1111
// sjdkas
// dsakdsa
public class Board {

	Position[] pst;
	int count;
	
	public Board(){
		pst = new Position[24];
		count = 0;
		for(int i=0; i<24; i++) {
		pst[i] = new Position();
		}
	}

	public void init() {
		
		pst[0].setCol(false); pst[0].setNum((byte)2);
		pst[5].setCol(true); pst[5].setNum((byte)5);
		pst[7].setCol(true); pst[7].setNum((byte)3);
		pst[11].setCol(false); pst[11].setNum((byte)5);
		pst[12].setCol(true); pst[12].setNum((byte)5);
		pst[16].setCol(false); pst[16].setNum((byte)3);
		pst[18].setCol(false); pst[18].setNum((byte)5);
		pst[23].setCol(true); pst[23].setNum((byte)2);
		
	}
	
	public byte roll() {
		byte dice = (byte)((Math.random()*6)+1);
		return dice;
	}
	
	public void addCount() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public void print() {
		for(int i=0; i<24; i++) {
			if(pst[i].getNum() != 0) {
				System.out.println(pst[i].getNum()+" "+pst[i].getCol());
			} else {
				System.out.println("empty");
			}
		}
	}
}
