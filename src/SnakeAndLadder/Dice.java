package SnakeAndLadder;

import java.util.Random;

public class Dice {

	int diceCount;
	int min;
	int max;
	public Dice(int diceCount, int min, int max) {
		super();
		this.diceCount = diceCount;
		this.min = min;
		this.max = max;
	}
	public int rollDice()
	{
		
		return min+(int)(Math.random()*5);
	}
}
