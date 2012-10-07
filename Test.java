public class Test {
	
	public static void main(String[] args) {
		byte test;
		byte a = 5;
		boolean b = false;
		Position pos = new Position(true, a);
		test = pos.getNum();
		System.out.println(test);
		pos.increase();
		test = pos.getNum();
		System.out.println(test);
		pos.decrease();
		test = pos.getNum();
		System.out.println(test);
		b = pos.getCol();
		System.out.println(b);
		Board c = new Board();
		c.init();
		c.print();
		for(int i=0; i<10; i++) {
			byte dice = (byte)((Math.random()*6)+1);
			System.out.println(dice);
		}
	}
}
