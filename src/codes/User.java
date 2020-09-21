package codes;

import java.util.Scanner;
import static codes.Constants.*;

public class User extends Player{

	public User(GameMode mode) {
		super(mode);
	}

	@Override
	public Combination createNewPlayerTrial() {
		Combination playerComb = new Combination(gm);
		Scanner scn = new Scanner(System.in);
		
		System.out.println(COLOR_MENU_1);
		System.out.println(COLOR_MENU_2);
		
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			
			System.out.println("Choose a color to put into the gamepiece: ");
			playerComb.addPiece(i, scn.nextInt());
		}
		
		return playerComb;
	}
}
