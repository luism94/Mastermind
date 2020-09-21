package codes;

public abstract class Player {

	protected GameMode gm;
	
	public Player(GameMode mode) {
		gm = mode;
	}

	public abstract Combination createNewPlayerTrial();
}
