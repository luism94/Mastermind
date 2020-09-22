package codes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static codes.Colors.*;
import static codes.Constants.*;

public class Combination {

	private GameMode gm;
	private GamePiece[] comb;

	public Combination(GameMode mode) {
		gm = mode;
		comb = new GamePiece[mode.getPieceNumber()];
	}

	public GamePiece[] getPieceCombination() {
		return comb;
	}

	public void addPiece(int position, GamePiece piece) {
		comb[position] = new GamePiece(piece.getPieceColor());
	}

	public void addPiece(int position, int nextInt) {
		GamePiece piece = new GamePiece();
		piece.generatePiece(nextInt);
		comb[position] = piece;
	}

	protected void createSecretCombinationNoRepetition() {
		Random generator = new Random();
		GamePiece pieceToCheck = new GamePiece();
		int count = 0;

		while (count < gm.getPieceNumber()) {
			pieceToCheck.generatePiece(generator.nextInt(gm.getColorNumber()) + 1);
			
			if (!checkExistence(pieceToCheck)) {
				//busco si esta repetido	
				addPiece(count, pieceToCheck);
				count++;
			}
		}	
	}
	
	protected void createSecretCombinationWithRepetition() {
		Random generator = new Random();
		GamePiece pieceToCheck = new GamePiece();

		for (int i = 0; i < gm.getPieceNumber(); i++) {
			pieceToCheck.generatePiece(generator.nextInt(gm.getColorNumber()) + 1);	
			addPiece(i, pieceToCheck);
		}	
	}
	
	/* El metodo asList consigue envolver un array para se comporte como una Lista o Coleccion para usar
	 * de forma que pueda usar los metodos propios de una Lista o Coleccion
	 * Es un metodo puente que consigue conectar las listas y colecciones con los arrays, al igual
	 * que el metodo Collection.toArray()
	 */
	protected boolean checkExistence(GamePiece pieceToCheck) {
		return Arrays.asList(comb).contains(pieceToCheck);
	}

	public String checkPlayerCombinationWithRepetition(Combination playerComb) {
		String answer = "";
		GamePiece piece = null;
		GamePiece[] secretCopy = new GamePiece[gm.getPieceNumber()];
		int playerCount = 0, secretCount, redCount = 0, whiteCount = 0, emptySpaces = 0;
		
		while (playerCount < gm.getPieceNumber()) {
			secretCount = 0;
			piece = playerComb.getPieceCombination()[playerCount];
			
			while (secretCount < gm.getPieceNumber()) {
				if (piece.equals(getPieceCombination()[secretCount])) {
					if (secretCopy[secretCount] == null) {
						//esta en la secreta
						if (secretCount == playerCount) {
							redCount++;
						} else {
							whiteCount++;
						}
						//copio la ficha de la secreta en su posicion si coincide con la del jugador
						secretCopy[secretCount] = piece;
					} else if (piece.equals(secretCopy[secretCount])) {
						if (secretCount == playerCount) {
							whiteCount--;
							redCount++;
						}
					}
				}
				
				secretCount++;
			}
			
			playerCount++;
		}
		
		for (int i = 0; i < redCount; i++) {
			answer += RED + "  " + LIGHT_BOARD + " ";
		}
		
		for (int i = 0; i < whiteCount; i++) {
			answer += WHITE + "  " + LIGHT_BOARD + " ";
		}
		
		emptySpaces = gm.getPieceNumber() - (redCount + whiteCount);
		
		if (emptySpaces != 0) {	//para asegurar que no se ejecuta si no queda hueco dentro
			for (int i = 0; i < emptySpaces; i++) {
				answer += LIGHT_BOARD + "   ";
			} 
		}
		
		return answer;
	}

	protected String checkPlayerCombinationNoRepetition(Combination playerComb) {
		
		int playerCount = 0, secretCount, whiteCount = 0, redCount = 0, checkedCount = 0, emptySpaces;
		boolean alreadyChecked;
		String answer = "";
		String[] checkedColors = new String[gm.getPieceNumber()];
		GamePiece piece = null;
		
		while (playerCount < gm.getPieceNumber()) {
			secretCount = 0;
			checkedCount = 0;
			piece = playerComb.getPieceCombination()[playerCount];
			alreadyChecked = false;
			
			while (secretCount < gm.getPieceNumber()) {
				if (piece.equals(getPieceCombination()[secretCount])) {
					//esta en la secreta
					while (checkedCount < gm.getPieceNumber()) {	//for?
						//compruebo si ese color ya se ha comprobado en la secreta
						if (checkedColors[checkedCount] != null &&
								checkedColors[checkedCount].equals(piece.getPieceColor())) {
							
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
			answer += RED + "  " + LIGHT_BOARD + " ";
		}
		
		for (int i = 0; i < whiteCount; i++) {
			answer += WHITE + "  " + LIGHT_BOARD + " ";
		}
		
		emptySpaces = gm.getPieceNumber() - (redCount + whiteCount);
		
		if (emptySpaces != 0) {	//para asegurar que no se ejecuta si no queda hueco dentro
			for (int i = 0; i < emptySpaces; i++) {
				answer += LIGHT_BOARD + "   ";
			} 
		}

		return answer;
	}

	@Override
	public String toString() {
		String pieceComb = "";
		
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			pieceComb += comb[i].getPieceColor() + "Ficha" + RESET;
		}
		
		return pieceComb;
	}

	protected String drawPlayerCombination() {
		String drawing = "";
		
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			drawing += comb[i].drawPiece() + LIGHT_BOARD + " ";
		}
		
		return drawing;
	}
}

