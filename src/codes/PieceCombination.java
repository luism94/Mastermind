package codes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static codes.Colors.*;
import static codes.Constants.*;

public class PieceCombination {

	private GameMode gm;
	private GamePiece[] comb;

	public PieceCombination(GameMode mode) {
		gm = mode;
		comb = new GamePiece[mode.getPieceNumber()];
	}

	protected void createNewPiece(int position, int option) {
		comb[position] = new GamePiece(pickColorPiece(option));
	}

	protected String pickColorPiece(int colorOption) {
		String color = "";
	
		switch (colorOption) {
		case 1:
			color = RED;
			break;
		case 2:
			color = GREEN;
			break;
		case 3:
			color = BLUE;
			break;
		case 4:
			color = YELLOW;
			break;
		case 5:
			color = BROWN;
			break;
		case 6:
			color = ORANGE;
			break;
		case 7:
			color = BLACK;
			break;
		case 8:
			color = WHITE;
			break;
		default:
			throw new IllegalArgumentException(ILLEGAL_ARG_EXCP);
		}
		
		return color;
	}

//	protected void createComputerCombination() {
//		Random generator = new Random();
//		GamePiece pieceToCheck = null;
//		int count = 0;
//
//		while (count < gm.getPieceNumber()) {
//			pieceToCheck = new GamePiece(pickColorPiece(generator.nextInt(gm.getColorNumber()) + 1));
//			
//			if (!checkExistence(pieceToCheck)) {
//				//busco si esta repetido	
//				comb[count] = pieceToCheck;
//				count++;
//			}
//		}	
//	}
	
	/* El metodo asList consigue envolver un array para se comporte como una Lista o Coleccion para usar
	 * de forma que pueda usar los metodos propios de una Lista o Coleccion
	 * Es un metodo puente que consigue conectar las listas y colecciones con los arrays, al igual
	 * que el metodo Collection.toArray()
	 */
	protected boolean checkExistence(GamePiece pieceToCheck) {
		return Arrays.asList(comb).contains(pieceToCheck);
	}

	protected void createPlayerCombination() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(COLOR_MENU_1);
		System.out.println(COLOR_MENU_2);
		
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			
			System.out.println("Choose a color to put into the gamepiece: ");
			comb[i] = new GamePiece(pickColorPiece(scn.nextInt()));
		}
	}
	
	

//	public String checkPlayerCombinationWithRepetition(PieceCombination playerComb) {
//		String solution = "";
//		GamePiece piece = null;
//		GamePiece[] secretCopy = new GamePiece[gm.getPieceNum()];
//		int playerCount = 0, secretCount, redCount = 0, whiteCount = 0;
//		
//		while (playerCount < gm.getPieceNum()) {
//			secretCount = 0;
//			piece = playerComb.getPieceCombiantion()[playerCount];
//			while (secretCount < gm.getPieceNum()) {
//				if (piece.equals(this.getPieceCombiantion()[secretCount])) {
//					if (secretCopy[secretCount] == null) {
//						//esta en la secreta
//						if (secretCount == playerCount) {
//							redCount++;
//						} else {
//							whiteCount++;
//						}
//						//copio la ficha de la secreta en su posicion si coincide con la del jugador
//						secretCopy[secretCount] = piece;
//					}
//				}
//				secretCount++;
//			}
//			playerCount++;
//		}
//		
//		for (int i = 0; i < redCount; i++) {
//			solution = solution + RED + "  " + LIGHT_BOARD + " ";
//		}
//		
//		for (int i = 0; i < whiteCount; i++) {
//			solution = solution + WHITE + "  " + LIGHT_BOARD + " ";
//		}
//		
//		return solution;
//	}

	protected String checkPlayerCombinationNoRepetition(PieceCombination playerComb) {
		
		int playerCount = 0, secretCount, whiteCount = 0, redCount = 0, checkedCount = 0, emptySpaces;
		boolean alreadyChecked;
		String answer = "";
		String[] checkedColors = new String[gm.getPieceNumber()];
		GamePiece piece = null;
		
		while (playerCount < gm.getPieceNumber()) {
			secretCount = 0;
			checkedCount = 0;
			piece = playerComb.getPieceCombiantion()[playerCount];
			alreadyChecked = false;
			
			while (secretCount < gm.getPieceNumber()) {
				if (piece.equals(this.getPieceCombiantion()[secretCount])) {
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
			answer += answer + RED + "  " + LIGHT_BOARD + " ";
		}
		
		for (int i = 0; i < whiteCount; i++) {
			answer += answer + WHITE + "  " + LIGHT_BOARD + " ";
		}
		
		emptySpaces = gm.getPieceNumber() - (redCount + whiteCount);
		
		if (emptySpaces != 0) {	//para asegurar que no se ejecuta si no queda hueco dentro
			for (int i = 0; i < emptySpaces; i++) {
				answer += answer + LIGHT_BOARD + "   ";
			} 
		}
		
		return answer;
	}

	public GamePiece[] getPieceCombiantion() {
		return comb;
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

