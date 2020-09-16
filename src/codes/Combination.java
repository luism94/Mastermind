package codes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static codes.Colors.*;
import static codes.Constants.*;

public class Combination {

	private GameMode gm;
	private GamePiece[] pieceComb;

	public Combination(GameMode mode) {
		gm = mode;
		pieceComb = new GamePiece[mode.getPieceNum()];
	}

	public void generateSecretCombination() {
		Random randomGenerator = new Random();
		int colorOption = 0;
		GamePiece pieceToCheck = null;
		boolean correct = false;
		int count = 0;

		while (count < gm.getPieceNum()) {
			pieceToCheck = new GamePiece(chooseColor(randomGenerator.nextInt(gm.getColorNum()) + 1));
			
			if (!checkExistence(pieceToCheck)) {
				//busco si esta repetido	
				pieceComb[count] = pieceToCheck;
				count++;
			}
		}	
	}
	
	/* El metodo asList consigue envolver un array para se comporte como una Lista o Coleccion para usar
	 * de forma que pueda usar los metodos propios de una Lista o Coleccion
	 * Es un metodo puente que consigue conectar las listas y colecciones con los arrays, al igual
	 * que el metodo Collection.toArray()
	 */
	private boolean checkExistence(GamePiece pieceToCheck) {
		return Arrays.asList(pieceComb).contains(pieceToCheck);
	}

	public String chooseColor(int colorOption) {
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

	@Override
	public String toString() {
		String comb = "";
		
		for (int i = 0; i < gm.getPieceNum(); i++) {
			comb = comb + pieceComb[i].getPieceColor() + "Ficha " + (i+1) + "\n" + RESET;
		}
		
		return comb;
	}

	public void generateCombination() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(COLOR_MENU_1);
		System.out.println(COLOR_MENU_2);
		
		for (int i = 0; i < gm.getPieceNum(); i++) {
			System.out.println("Choose a color: ");
			pieceComb[i] = new GamePiece(chooseColor(scn.nextInt()));
		}
	}
	
	public GamePiece[] getPieceComb() {
		return pieceComb;
	}

	public String drawCombination() {
		String draw = "";
		
		for (int i = 0; i < gm.getPieceNum(); i++) {
			draw += pieceComb[i].drawPiece() + RESET + " ";
		}
		
		return draw;
	}

	public String compareCombinationRepeated(Combination playerComb) {
		String solution = "";
		GamePiece piece = null;
		GamePiece[] secretCopy = new GamePiece[gm.getPieceNum()];
		int playerCount = 0, secretCount, redCount = 0, whiteCount = 0;
		boolean alreadyChecked = false;
		
		
		while (playerCount < gm.getPieceNum()) {
			secretCount = 0;
			piece = playerComb.getPieceComb()[playerCount];
			while (secretCount < gm.getPieceNum()) {
				if (piece.equals(this.getPieceComb()[secretCount])) {
					if (secretCount == playerCount) {
						redCount++;
					} else {
						whiteCount++;
					}
					secretCopy[player]
				}
			}
		}
		
		return solution;
	}

	public String compareCombinationNoRepeated(Combination playerComb) {
		
		int playerCount = 0;
		int secretCount = 0;
		int whiteCount = 0;
		int redCount = 0;
		String solution = "";
		boolean alreadyChecked;
		String[] checkedColors = new String[gm.getPieceNum()];
		int checkedCount = 0;

		GamePiece piece = null;
		
		while (playerCount < gm.getPieceNum()) {
			secretCount = 0;
			piece = playerComb.getPieceComb()[playerCount];
			alreadyChecked = false;
			checkedCount=0;
			while (secretCount < gm.getPieceNum()) {
				if (piece.equals(this.getPieceComb()[secretCount])) {
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

