import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;




public class Game {
	
	Board b;
	boolean whiteFirst;
	boolean whiteTurn;
	Set<String> moveSet;
	
	public Game() {
		
		byte wr,br;
		moveSet = new HashSet<String>();
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
	 * TODO: pame ksana gia ta mavra
	 */
	
	public void movegen(byte r1, byte r2) {
		

		boolean exoume_diples = false ;
		boolean lastRun = false;
		boolean m1Happened = false;
		boolean m2Happened = false;
		boolean iCol, ir1Col, ir2Col, ir1r2Col, idubsCol;
		byte iNum, ir1Num, ir2Num, ir1r2Num, idubsNum;
		byte lastCounter = 0;
		
		/* check if we have dubs */
		if(r1==r2){
			exoume_diples = true ;
		}
		
		/* self-explanatory */
		if(whiteTurn) {
			
			//to be removed
			System.out.println("\t\t\t\t\t white rolled "+r1+" and "+r2);
			
			/* check to see if we are in last run mode */
			for(int i=0; i<18; i++) {
				if(b.pst[i].getCol()==false && b.pst[i].getNum() != 0) {
					lastCounter++;
				}
			}
			if(lastCounter==0) {
				lastRun = true;
			}
			
			/* loop that goes through every position on the board */
			for(int i=0; i<24; i++) {
				
				/* legal moves for non-double dice rolls */
				if (!exoume_diples) {	
					
					/* gets the color and number of pills that exist in the current position(i) */
					iCol = b.pst[i].getCol();
					iNum = b.pst[i].getNum();
					
					/* if the color is white, and there are some pills in the position, continue */
					if(iCol==false && iNum!=0) {
						
						/* if the position the first dice brings us to is within the game borders, continue */
						if(i+r1<24) {
							
							/* gets the color and number of pills of the position we are trying to move to */
							ir1Col = b.pst[i+r1].getCol();
							ir1Num = b.pst[i+r1].getNum();
							
							/* checks to see if we can move there legally */
							if((ir1Col==false || ir1Num==0) || (ir1Col==true) && (ir1Num==1)) {
								
								/* we print the legal moves, and also add them to moveSet */
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+1));
								moveSet.add((i+1)+" -> "+(i+r1+1));
								/* tells us the first dice produced a legal move */
								m1Happened = true;
								
								/* not sure if this is useful in this method */
								if(ir1Col) {
									System.out.println("It will eat a black pill");
								}
							}
							
						/* if the position we are trying to move to exceeds the game borders, and we are in last run mode, continue */	
						} else if (((i+r1) >= 24) && lastRun) {
							
							/* again, prints legal moves and adds them to the set */
							System.out.println("a white pill from position "+(i+1)+" can move out of the board");
							moveSet.add((i+1)+" -> out");
							m1Happened = true;
						}
						
						/* same stuff for the second dice */
						if(i+r2<24) {
							ir2Col = b.pst[i+r2].getCol();
							ir2Num = b.pst[i+r2].getNum();
							if((ir2Col==false || ir2Num==0) || (ir2Col==true) && (ir2Num==1)) {
								System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r2+1));
								moveSet.add((i+1)+" -> "+(i+r2+1));
								m2Happened = true;
								if(ir2Col) {
									System.out.println("It will eat a black pill");
								}
							}
						
						} else if (((i+r2) >= 24) && lastRun) {
							System.out.println("a white pill from position "+(i+1)+" can move out of the board");
							moveSet.add((i+1)+" -> out");
							m2Happened = true;
						}
						
						/* legal moves for the addition of both dice */
						if(i+r1+r2<24) {	
							
							/* checks if at least one of the two dice gives us a legal move in order to continue */
							if(m1Happened || m2Happened) {
								
								/* same stuff as before */
								ir1r2Col = b.pst[i+r1+r2].getCol();
								ir1r2Num = b.pst[i+r1+r2].getNum();
								if((ir1r2Col==false || ir1r2Num==0) || (ir1r2Col==true) && (ir1r2Num==1)) {
									System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+r1+r2+1));
									moveSet.add((i+1)+" -> "+(i+r1+r2+1));
									if(ir1r2Col) {
										System.out.println("It will eat a black pill");
									}
								}
							}
							
						/* last run check for both dice */
						} else if(((i+r1+r2) >=24) && lastRun) {
							if(m1Happened || m2Happened) {
								System.out.println("a white pill from position "+(i+1)+" can move out of the board");
								moveSet.add((i+1)+" -> out");
							}
						}
					}
				}
				
				/* legal moves for double dice rolls */
				else if(exoume_diples) {
					
					byte counter_diplwn = 1;
					iCol = b.pst[i].getCol() ;
					iNum = b.pst[i].getNum(); 
					if(iCol == false && iNum != 0){
						if(!lastRun){
							while(counter_diplwn < 5 && i+counter_diplwn*r1 < 24 ) {
								idubsCol = b.pst[i+counter_diplwn*r1].getCol();
								idubsNum = b.pst[i+counter_diplwn*r1].getNum();
								if((idubsCol==false || idubsNum==0) || (idubsCol==true) && (idubsNum==1)) {
									do {
										System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+counter_diplwn*r1+1));
										moveSet.add((i+1)+" -> "+(i+counter_diplwn*r1+1));
										if(idubsCol) {
											System.out.println("It will eat a black pill");
										}
										iNum--;
									} while (iNum>0);
									
								} else {
									break;
								}
								counter_diplwn ++ ;
							}
						/* dubs last run mode legals */
						} else if(lastRun) {
							while(counter_diplwn < 5) {
								if(i+counter_diplwn*r1 < 24) {
									idubsCol = b.pst[i+counter_diplwn*r1].getCol();
									idubsNum = b.pst[i+counter_diplwn*r1].getNum();
									if((idubsCol==false || idubsNum==0) || (idubsCol==true) && (idubsNum==1)) {
										
										System.out.println("a white pill from position "+(i+1)+" can move to position "+(i+counter_diplwn*r1+1));
										moveSet.add((i+1)+" -> "+(i+counter_diplwn*r1+1));
										if(idubsCol) {
											System.out.println("It will eat a black pill");
										}	
										iNum--;
										
									} else { break; }
									
									counter_diplwn ++ ;
									
								} else {
									if(iNum>0) {
										do {
											System.out.println("a white pill from position "+(i+1)+" can move out of the board ");
											moveSet.add((i+1)+" -> out");
											iNum--;
										} while(iNum>0);
										counter_diplwn++;
									}	
								}
							}
						}
					}
				}
				
			m1Happened = false;
			m2Happened = false;
			}
		whiteTurn = false;
		Iterator<String> it = moveSet.iterator();
        while (it.hasNext()) {
                System.out.println(it.next());
        } 
        moveSet.clear();
		
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
