package codes;

import java.util.Random;

public class AI_Player extends Player{

	public AI_Player(GameMode gm) {
		super(gm);
	}

	@Override
	public Combination newTry() {
		Combination ia = createNewCombination();
		
		return ia;
	}

	private Combination createNewCombination() {
		Combination comb = new Combination(mode);
		Random rndm = new Random();
		int option = 0;
		for (int i = 0; i < mode.getPieceNum(); i++) {
			option = rndm.nextInt(mode.getColorNum()) + 1;
			comb.generateNewPiece(i, option);
		}
		
		return comb;
	}

	
}
