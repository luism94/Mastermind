package codes;

import static codes.Colors.*;
import static codes.GameMode.*;

public class Main {

	public static void main(String[] args) {
		new Main().prueba();
	}

	private void prueba() {
		//System.out.println(ORANGE + "ficha" + RESET);
		//System.out.println(BROWN + "ficha" + RESET);
//		Combination secretComb = new Combination(EASY);
//		secretComb.generateSecretCombination();
//		System.out.println(secretComb.toString());
		//System.out.println(comb);	//Se generan siempre las mismas fichas (naranja, blanca, marron, roja)
//		GameSystem system = new GameSystem(EASY);
//		System.out.println(system.getSecretComb().toString());
//		Player player = new Player(EASY);
//		Combination playerComb = player.newTry();
		Controller control = new Controller();
		System.out.println();
	}
}
