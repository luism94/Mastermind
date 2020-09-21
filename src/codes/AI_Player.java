package codes;

import java.util.Random;

public class AI_Player extends Player{

	public AI_Player(GameMode gm) {
		super(gm);
	}

	@Override
	public Combination createNewPlayerTrial() {	
		return createAIPlayerCombination();
	}

	private Combination createAIPlayerCombination() {
		Combination comb = new Combination(gm);
		Random rndm = new Random();
		int option = 0;
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			option = rndm.nextInt(gm.getColorNumber()) + 1;
			comb.createNewPiece(i, option);
		}
		
		return comb;
	}

	
}
