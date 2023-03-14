package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

	Board board;
	Dice dice;
	Deque<Player> players;
	Player Winner;
	
	Game()
	{
		board=new Board();
		this.board.initializeBoard();
		this.board.setSnakeAndLadder(5, 5);
		this.dice=new Dice(1,1,6);
		this.players=new LinkedList<>();
		this.registerPlayers(5);
	}

	private void registerPlayers(int i) {
		// TODO Auto-generated method stub
		while(i>0)
		{
			this.players.addFirst(new Player(i));
			i--;
		}
	}
	
	public void beginGame() 
	{
		while(this.Winner==null)
		{
			Player cur=players.pollFirst();
			int nextMove=this.dice.rollDice();
			System.out.println(cur +" current position is "+cur.currentPosition);
			System.out.println(cur+" is make a move of "+nextMove);
			if(cur.currentPosition+nextMove>99)
			{
				this.Winner=cur;
				break;
			}
			else
			{
				
				int nextIndex=cur.currentPosition+nextMove;
				Cell c=this.board.cell[nextIndex/10][nextIndex%10];
				if(c.jump!=null)
				{
					if(c.jump.type.equalsIgnoreCase("snake"))
					{
						System.out.println(cur +" is making a jump of type snake from "+c.jump.start+" to "+c.jump.end);
						cur.currentPosition=c.jump.end;
					}
					else
					{
						System.out.println(cur +" is making a jump of type ladder from "+c.jump.start+" to "+c.jump.end);
						cur.currentPosition=c.jump.end;
					}
				}
				else
				{
					cur.currentPosition=nextIndex;
				}
			}
			if(cur.currentPosition>=99)
			{
				Winner=cur;
				break;
			}
			players.addLast(cur);
		}
		
		System.out.println(" The winner is "+Winner);
	}
	
}
