package SnakeAndLadder;

import java.util.Random;

public class Board {

	Cell[][] cell;
	Board(){
		cell=new Cell[10][10];
	}
	public void initializeBoard() {
		// TODO Auto-generated method stub
		System.out.println("Initializing Board.......");
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				this.cell[i][j]=new Cell(null);
			}
		}
		System.out.println("Initializing Board Done.......");
	}
	public void setSnakeAndLadder(int snakes,int ladders)
	{
		System.out.println("Setting Board.......");
		while(snakes>0)
		{
			int start=(int)(Math.random()*100);
			int end=(int)(Math.random()*100);	
			while(start==end || checkJump(start) || checkJump(end))
			{
				start=(int)(Math.random()*100);		
				end=(int)(Math.random()*100);
			}
			
			Jump j=new Jump(Math.max(start, end),Math.min(start, end),"snake");
			int index=Math.max(start, end);
			this.cell[index/10][index%10].jump=j;
			
			snakes--;
		}
		System.out.println("Setting snakes Board Completed.......");
		System.out.println("Setting Ladder.......");
		while(ladders>0)
		{
			
			
			int start=(int)(Math.random()*100);
			int end=(int)(Math.random()*100);
			
			while(checkJump(start) || checkJump(end))
			{
				start=(int)(Math.random()*100);
				end=(int)(Math.random()*100);
			}
			Jump j=new Jump(Math.min(start, end),Math.max(start, end),"ladder");
			int index=Math.min(start,end);
			this.cell[index/10][index%10].jump=j;
			
			ladders--;
		}
		System.out.println("Setting Ladder completed.......");
	}
	
	public boolean checkJump(int pos)
	{
		int r=pos/10;
		int c=pos%10;
		if(this.cell[r][c].jump!=null)
			return true;
		return false;
		
	}
	
}
