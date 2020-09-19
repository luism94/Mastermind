package codes;

import static codes.GameMode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static codes.Colors.*;

public class Computer {

	private GameMode gm;
	private PieceCombination secretComb;
	
	public Computer(GameMode mode) {
		gm = mode;
		secretComb = createComputerCombination();	//Array con las fichas de la respuesta secreta
		System.out.println(secretComb);				//se muestra en pantalla para pruebas
		//Genero una ficha de un color aleatorio y compruebo si esta repetida
	}

	public PieceCombination getSecretComb() {
		return secretComb;
	}

	private void setSecretComb(PieceCombination secretComb) {
		this.secretComb = secretComb;
	}

	public String compareCombinations(PieceCombination playerComb) {
		//ficha de la cmb del jugador con toda la comb secreta
		//En la comb de la respuesta se coloca una ficha roja, blanca o nada en la posicion oportuna
		String solution = "";
		
		if (gm.repeatedColors()) {
			//solution = secretComb.checkPlayerCombinationWithRepetition(playerComb);
		} else {
			solution = secretComb.checkPlayerCombinationNoRepetition(playerComb);
		}
		return solution;
	}

	private PieceCombination createComputerCombination() {
		Random generator = new Random();
		GamePiece pieceToCheck = null;
		PieceCombination computerComb = new PieceCombination(gm);
		int count = 0;

		while (count < gm.getPieceNumber()) {
			pieceToCheck = new GamePiece(computerComb.pickColorPiece(generator.nextInt(gm.getColorNumber()) + 1));
			
			if (!computerComb.checkExistence(pieceToCheck)) {
				//busco si esta repetido	
				computerComb.getPieceCombiantion()[count] = pieceToCheck;
				count++;
			}
		}
		
		return computerComb;
	}
}
