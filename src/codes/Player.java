package codes;

import static codes.Constants.*;

import java.util.Scanner;

public class Player {

	private GameMode mode;
	
	public Player(GameMode mode) {
		this.mode = mode;
	}

	public Combination newTry() {
		Combination playerComb = new Combination(mode);
		
		playerComb.generateCombination();
		
		return playerComb;
	}
}
