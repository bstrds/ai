
public class Game {
	
	Board b;
	boolean whiteFirst;
	boolean whiteTurn;
	
	public Game() {
		
		byte wr,br;
		b = new Board();
		b.init();
		do { 
		wr = (byte)((Math.random()*6)+1);
		br = (byte)((Math.random()*6)+1);
		} while (wr==br);
		first(wr,br);
		if (whiteFirst) {
			whiteTurn=true;
		} else {
			whiteTurn=false;
		}
	}
	
	/*
	 * rolls two dice
	 * TODO: figure out if it needs a return statement
	 */
	public void roll() {
		byte dice1 = (byte)((Math.random()*6)+1);
		byte dice2 = (byte)((Math.random()*6)+1);
	    movegen(dice1, dice2);
	}
	
	
	/*
	 * a method that prins every possible legal move a player (computer or human) can perform, according to the dice they rolled.
	 * TODO: exei dromo akoma....
	 */
	
	public void movegen(byte r1, byte r2) {
		boolean exoume_diples =false ;
		boolean m1Happened = false;
		boolean m2Happened = false;
		boolean iCol, ir1Col, ir2Col, ir1r2Col, idubsCol;
		byte iNum, ir1Num, ir2Num, ir1r2Num, idubsNum;
		if(r1==r2){
			exoume_diples = true ;
		}
		if(whiteTurn) {
			System.out.println("\t\t\t\t\t white rolled "+r1+" and "+r2);
			
			for(int i=0; i<24; i++) {
				
				if (!exoume_diples) {	
					
					iCol = b.pst[i].getCol();
					iNum = b.pst[i].getNum();
					if(iCol==false && iNum!=0) {
						
						if(i+r1<24) {
							ir1Col = b.pst[i+r1].getCol();
							ir1Num = b.pst[i+r1].getNum();
							if((ir1Col==false || ir1Num==0) || (ir1Col==true) && (ir1Num==1)) {
								
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+1));
								m1Happened = true;
								
								if(ir1Col) {
									System.out.println("It will eat a black pill");
								}
							}
						}
						
						if(i+r2<24) {
							ir2Col = b.pst[i+r2].getCol();
							ir2Num = b.pst[i+r2].getNum();
							if((ir2Col==false || ir2Num==0) || (ir2Col==true) && (ir2Num==1)) {
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r2+1));
								m2Happened = true;
								if(ir2Col) {
									System.out.println("It will eat a black pill");
								}
							}
						
						}
					
						if(i+r1+r2<24) {	
							if(m1Happened || m2Happened) {
								ir1r2Col = b.pst[i+r1+r2].getCol();
								ir1r2Num = b.pst[i+r1+r2].getNum();
								if((ir1r2Col==false || ir1r2Num==0) || (ir1r2Col==true) && (ir1r2Num==1)) {
									System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+r2+1));
									if(ir1r2Col) {
										System.out.println("It will eat a black pill");
									}
								}
							}
						}
					}
				}
				
				else if(exoume_diples) {
					
					int counter_diplwn = 1;
					iCol = b.pst[i].getCol() ;
					iNum = b.pst[i].getNum();
					if(iCol == false && iNum != 0){
						while(counter_diplwn <= 4 && i+counter_diplwn*r1 < 24 ){
							idubsCol = b.pst[i+counter_diplwn*r1].getCol();
							idubsNum = b.pst[i+counter_diplwn*r1].getNum();
							if((idubsCol==false || idubsNum==0) || (idubsCol==true) && (idubsNum==1)) {
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+counter_diplwn*r1+1));
								if(idubsCol) {
									System.out.println("It will eat a black pill");
								}
							} else {
								break;
							}
							counter_diplwn ++ ;
						}
					}
				}
				
			m1Happened = false;
			m2Happened = false;
			}
		whiteTurn = false;
		
		} else {
			
			System.out.println("\t\t\t\t\t black rolled "+r1+" and "+r2);
			for(int i=23; i>0; i--) {
				if(!exoume_diples) {
					iCol = b.pst[i].getCol();
					iNum = b.pst[i].getNum();
					if(iCol==true && iNum!=0) {
						if(i-r1>=0)	{
							ir1Col = b.pst[i-r1].getCol();
							ir1Num = b.pst[i-r1].getNum();
							if((ir1Col==true || ir1Num==0) || (ir1Col==false) && (ir1Num==1)) {
								System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r1+1));
								m1Happened = true;
								if((ir1Col==false) && (ir1Num==1)) {
									System.out.println("It will eat a white pill");
								}
							}
						}
						
						if(i-r2>=0) {
							ir2Col = b.pst[i-r2].getCol();
							ir2Num = b.pst[i-r2].getNum();
							if((ir2Col==true || ir2Num==0) || (ir2Col==false) && (ir2Num==1)) {
								System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r2+1));
								m2Happened = true;
								if((ir2Col==false) && (ir2Num==1)) {
									System.out.println("It will eat a white pill");
								}
							}
						}
						
						if(i-r1-r2>=0) {
							if(m1Happened || m2Happened) {
								ir1r2Col = b.pst[i-r1-r2].getCol();
								ir1r2Num = b.pst[i-r1-r2].getNum();
								if((ir1r2Col==true || ir1r2Num==0) || (ir1r2Col==false) && (ir1r2Num==1)) {
									System.out.println("a black pill from position "+(i+1)+" can move to position "+(i-r1-r2+1));
									if((ir1r2Col==false) && (ir1r2Num==1)) {
										System.out.println("It will eat a white pill");
									}
								}
							}
						}	
					}	
				} 
				
				else if(exoume_diples) {
					int counter_diplwn = 1;
					iCol = b.pst[i].getCol() ;
					iNum = b.pst[i].getNum();
					if(iCol == true && iNum != 0){
						while(counter_diplwn <= 4 && i-counter_diplwn*r1 >= 0 ){
							idubsCol = b.pst[i-counter_diplwn*r1].getCol();
							idubsNum = b.pst[i-counter_diplwn*r1].getNum();
							if((idubsCol==true || idubsNum==0) || ((idubsCol==false) && (idubsNum==1))) {
								System.out.println("a black pill from position "+(i+1)+" can move to position "+((i-counter_diplwn*r1)+1));
								if(idubsCol==false && idubsNum>0) {
									System.out.println("It will eat a white pill");
								}
							} else {
								break;
							}
							counter_diplwn ++ ;
						}
					}
				}
			m1Happened = false;
			m2Happened = false;
			}
		whiteTurn = true;
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
