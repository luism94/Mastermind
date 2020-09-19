package codes;

public class User extends Player{

	public User(GameMode mode) {
		super(mode);
	}

	@Override
	public PieceCombination createNewPlayerTrial() {
		PieceCombination playerComb = new PieceCombination(gm);
		
		playerComb.createPlayerCombination();
		
		return playerComb;
	}
}
