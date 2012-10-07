
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
		
	}
}
