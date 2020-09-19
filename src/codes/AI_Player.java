package codes;

import java.util.Random;

public class AI_Player extends Player{

	public AI_Player(GameMode gm) {
		super(gm);
	}

	@Override
	public PieceCombination createNewPlayerTrial() {	
		return createAIPlayerCombination();
	}

	private PieceCombination createAIPlayerCombination() {
		PieceCombination comb = new PieceCombination(gm);
		Random rndm = new Random();
		int option = 0;
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			option = rndm.nextInt(gm.getColorNumber()) + 1;
			comb.createNewPiece(i, option);
		}
		
		return comb;
	}

	
}
