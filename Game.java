
public class Game {
	Board b;
	boolean whiteFirst;
	
	public Game() {
		b = new Board();
		b.init();
		byte wr = b.roll();
		byte br = b.roll();
		if(wr>br) {
			System.out.println("White rolled "+wr+", Black rolled "+br+". White plays first.");
			whiteFirst = true;
		} else {
			System.out.println("Black rolled "+br+", White rolled "+wr+". Black plays first");
			whiteFirst = false;
		}
		
	}
	
	public void move() {
		byte roll = b.roll();
		System.out.println("Tokens you can move: ");
		if(whiteFirst==true) {
			for(int i=0; i<24; i++) {
				if((b.pst[i].getCol()==false)&&(b.pst[i].getNum()!=0)) {
					System.out.println("Position "+(i+1)+", number of tokens: "+b.pst[i].numOfPills);
				}
			}
		} else {
			for(int i=0; i<24; i++) {
				if((b.pst[i].getCol()==true)&&(b.pst[i].getNum()!=0)) {
					System.out.println("Position "+(i+1)+", number of tokens: "+b.pst[i].numOfPills);
				}
			}
		}
	}
}
