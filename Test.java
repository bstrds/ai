
public class Test {
	
	public static void main(String[] args) {
		Game a1 = new Game();
		a1.b.pst[4].setCol(true);
		a1.b.pst[4].setNum((byte)1);
		a1.b.pst[21].setCol(false);
		a1.b.pst[21].setNum((byte)1);
		for(int i=0; i<20; i++) {
			a1.movegen();
		}
		
	}
}
