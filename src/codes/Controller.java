package codes;

import java.util.Scanner;
import static codes.Constants.*;
import static codes.GameMode.*;

public class Controller {

	private Player player;
	private Computer system;
	private TableBoard board;
	private GameMode gm;
	
	public Controller() {
		int option = chooseMenuOption();
		
		if (option == 3) {
			System.out.println(Constants.EXIT);
		} else if (option == 2) {
			System.out.println(Constants.HOW_TO_PLAY_1);
			System.out.println(Constants.HOW_TO_PLAY_2);
		} else {
			
			option = pickGameOption();
			
			if (option == 4) {
				//gm = selectGameMode(option);
				gm = EASY;
				player = new AI_Player(gm);
				
			} else {
				//Elijo el modo de juego por la opcion escogida
				//option = showIAMenu();
				gm = selectGameMode(option);
				player = new User(gm);
			}
				//Creo el jugador, la maquina y el tablero de la partida dependiendo del modo
				system = new Computer(gm);
				board = new TableBoard(gm);
				startGame();
		}
	}

	private int showIAMenu() {
		System.out.println();
		
		return 0;
	}

	private void chooseIAPlayer(int option) {
		switch (option) {
		case 1:
			
		}
	}

	private void startGame() {
		Combination playerComb = null;
		String solution = "";
		boolean end = false;
		int trialCount = 1;
		
		while (!end) {
			playerComb = player.createNewPlayerTrial();
			solution = system.compareCombinations(playerComb);
			board.addTrial(playerComb, solution);
			board.drawingGame();
			
			//decidir quien gana
			end = board.checkWinner();
			if (!end) {
				if (gm != EASY) {
					end = checkPlayerTrial(trialCount);
				}
			} else {
				System.out.println("WINNER!");
			}
			trialCount++;
		}
	}

	private boolean checkPlayerTrial(int trialCount) {
		if (trialCount < gm.getTrialMax()) {
			return false;
		} else {
			return true;
		}
	}

	private GameMode selectGameMode(int option) {
		GameMode gm = null;
		
//		System.out.println(GAMEMODE_MENU_1);
//		System.out.println(GAMEMODE_MENU_2);
		
		switch(option) {
		case 1:
			gm = EASY;
			break;
		case 2:
			gm = NORMAL;
			break;
		case 3:
			gm = MEDIUM;
			break;
		default:
			throw new IllegalArgumentException(ILLEGAL_ARG_EXCP);
		}
		
		return gm;
	}
	
	private int pickGameOption() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(GAMEMODE_MENU_2);
		System.out.println(GAMEMODE_MENU_1);
		
		return scn.nextInt();
	}

	private int chooseMenuOption() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(WELCOME);
		System.out.println(MAIN_MENU_1);
		System.out.println(MAIN_MENU_2);
		System.out.println(MAIN_MENU_3);
		
		return scn.nextInt();
	}
}
