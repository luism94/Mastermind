package codes;

public class User extends Player{

	public User(GameMode mode) {
		super(mode);
	}

	@Override
	public Combination newTry() {
		Combination playerComb = new Combination(mode);
		
		playerComb.generateCombination();
		
		return playerComb;
	}
}
