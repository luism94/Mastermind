package codes;

import static codes.GameMode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static codes.Colors.*;

public class Computer {

	private GameMode gm;
	private Combination secretComb;
	
	public Computer(GameMode mode) {
		gm = mode;
		secretComb = new Combination(gm);
		if (!gm.repeatedColors()) {
			secretComb.createSecretCombinationNoRepetition();
		} else {
			//secretComb.createSecretCombinationWithRepetition();
		}
		System.out.println(secretComb);	//se muestra en pantalla para pruebas
	}

	public Combination getSecretComb() {
		return secretComb;
	}

	private void setSecretComb(Combination secretComb) {
		this.secretComb = secretComb;
	}

	public String compareCombinations(Combination playerComb) {
		//En la comb de la respuesta se coloca una ficha roja, blanca o nada en la posicion oportuna
		String solution = "";
		
		if (gm.repeatedColors()) {
			//solution = secretComb.checkPlayerCombinationWithRepetition(playerComb);
		} else {
			solution = secretComb.checkPlayerCombinationNoRepetition(playerComb);
		}
		
		return solution;
	}
}
