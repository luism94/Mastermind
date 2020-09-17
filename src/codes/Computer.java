package codes;

import static codes.GameMode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static codes.Colors.*;

public class Computer {

	private GameMode gm;
	private Combination secretComb;
	
	public Computer(GameMode mode) {
		gm = mode;
		secretComb = new Combination(mode);	//Array con las fichas de la respuesta secreta
		secretComb.generateSecretCombination();
		System.out.println(secretComb);
		//Genero una ficha de un color aleatorio y compruebo si esta repetida
	}

	public Combination getSecretComb() {
		return secretComb;
	}

	private void setSecretComb(Combination secretComb) {
		this.secretComb = secretComb;
	}

	public String compareCombinations(Combination playerComb) {
		//ficha de la cmb del jugador con toda la comb secreta
		//En la comb de la respuesta se coloca una ficha roja, blanca o nada en la posicion oportuna
		String solution = "";
		
		if (gm.isRepeated()) {
			solution = secretComb.compareCombinationRepeated(playerComb);
		} else {
			solution = secretComb.compareCombinationNoRepeated(playerComb);
		}
		return solution;
	}

}
