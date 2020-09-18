package codes;

import static codes.Constants.*;

import java.util.Scanner;

public abstract class Player {

	protected GameMode mode;
	
	public Player(GameMode mode) {
		this.mode = mode;
	}

	public abstract Combination newTry();
}
