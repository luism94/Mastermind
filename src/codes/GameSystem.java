package codes;

import static codes.GameMode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static codes.Colors.*;

public class GameSystem {

	private GameMode gm;
	private Combination secretComb;
	
	public GameSystem(GameMode mode) {
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
		
		int playerCount = 0;
		int secretCount = 0;
		int whiteCount = 0;
		int redCount = 0;
		String solution = "";
		boolean alreadyChecked;
		String[] checkedColors = new String[gm.getPieceNum()];
		int checkedCount = 0;
//		int solutionCount = 0;
		GamePiece piece = null;
		
		while (playerCount < gm.getPieceNum()) {
			secretCount = 0;
			piece = playerComb.getPieceComb()[playerCount];
			alreadyChecked = false;
			checkedCount=0;
			while (secretCount < gm.getPieceNum()) {
				if (piece.equals(secretComb.getPieceComb()[secretCount])) {
					//esta en la secreta
					while (checkedCount < gm.getPieceNum()) {	//for?
						//compruebo si ese color ya se ha comprobado en la secreta
						if (checkedColors[checkedCount] != null && checkedColors[checkedCount].equals(piece.getPieceColor())) {
							alreadyChecked = true;
						}
						
						checkedCount++;
					}
					
					if (alreadyChecked) {
						//esta en las comprobadas
						if (playerCount == secretCount) {
							//esta en la misma posicion que en la secreta
							whiteCount--;
							redCount++;
						}
					} else {
						//NO esta en las comprobadas
						if (playerCount == secretCount) {
							//esta en la misma posicion que en la secreta
							redCount++;
						} else {
							//NO esta en la misma posicion NI se ha comprobado antes
							whiteCount++;
						}
						//introduzco el color en los colores comprobados
						checkedColors[playerCount] = piece.getPieceColor();
					}
				}
				
				secretCount++;
			}
			
			playerCount++;
		}
		
		for (int i = 0; i < redCount; i++) {
			solution = solution + RED + "  " + RESET + " ";
		}
		
		for (int i = 0; i < whiteCount; i++) {
			solution = solution + WHITE + "  " + RESET + " ";
		}
		
		return solution;
	}

}
