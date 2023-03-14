package SnakeAndLadder;

public class Player {

	int playerId;
	int currentPosition=0;
	public Player(int playerId) {
		super();
		this.playerId = playerId;
		this.currentPosition=0;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + "]";
	}
	
}
