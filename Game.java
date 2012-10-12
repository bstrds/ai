
public class Game {
	
	Board b;
	boolean whiteFirst;
	boolean whiteTurn;
	
	public Game() {
		
		byte wr,br;
		b = new Board();
		b.init();
		do { 
		wr = b.roll();
		br = b.roll();
		} while (wr==br);
		first(wr,br);
		if (whiteFirst) {
			whiteTurn=true;
		} else {
			whiteTurn=false;
		}
	}
	
	public void movegen() {
		
		byte r1 = b.roll();
		byte r2 = b.roll();
		if(whiteTurn) {
			System.out.println("white rolled "+r1+" and "+r2);
			for(int i=0; i<24; i++) {
				if(b.pst[i].getCol()==false && b.pst[i].getNum()!=0) {
					if(i+r1<25) {
						if(b.pst[i+r1].getCol()==false || b.pst[i+r1].getNum()==0) {
							System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+1));
							if(b.pst[i+r1+r2].getCol()==true ||b.pst[i-r1-r2].getNum()==0){
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+r2+1));
							}
						}
						if(b.pst[i+r2].getCol()==false || b.pst[i+r2].getNum()==0) {
							System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r2+1));
							if(b.pst[i+r1+r2].getCol()==true ||b.pst[i-r1-r2].getNum()==0){
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+r2+1));
							}
						}
					}
				}
			}
		} else {
			System.out.println("black rolled "+r1+" and "+r2);
			for(int i=23; i>0; i--) {
				if(b.pst[i].getCol()==true && b.pst[i].getNum()!=0) {
					if(i-r1>=0)	{
						if(b.pst[i-r1].getCol()==true || b.pst[i-r1].getNum()==0) {
							System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r1+1));
							if(b.pst[i-r1-r2].getCol()==true ||b.pst[i-r1-r2].getNum()==0){
								System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r1-r2+1));
							}
						}
						if(b.pst[i-r2].getCol()==false || b.pst[i-r2].getNum()==0) {
							System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r2+1));
							if(b.pst[i-r1-r2].getCol()==true ||b.pst[i-r1-r2].getNum()==0){
								System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r1-r2+1));
							}
						}
						
					}	
				}
			}
		}
	}
	
	public void first(byte wr, byte br) {
		
		if(wr>br) {
			System.out.println("White rolled "+wr+", Black rolled "+br+". White plays first.");
			whiteFirst = true;
		} else if(wr<br){
			System.out.println("Black rolled "+br+", White rolled "+wr+". Black plays first");
			whiteFirst = false;
		}
	}
}
