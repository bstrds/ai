
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
		if(whiteTurn) {
			
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
