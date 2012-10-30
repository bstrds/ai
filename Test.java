
public class Test {
	
	public static void main(String[] args) {
		Game a1 = new Game();
		
	    /*for(int i=23; i>6; i--) {
			if(a1.b.pst[i].getCol()==true) {
				a1.b.pst[i].setNum((byte)0);
			}
		}*/ 
		for(int i=0; i<20; i++) {
			a1.roll();
			a1.b.draw();
		}
		
		
	}
}
