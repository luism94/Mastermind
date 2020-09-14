package codes;

import java.util.Scanner;
import static codes.Constants.*;
import static codes.GameMode.*;

public class Controller {

	private Player player;
	private GameSystem system;
	private TableBoard board;
	private GameMode gm;
	
	public Controller() {
		int option = showMenu();
		
		if (option == 3) {
			System.out.println(Constants.EXIT);
		} else if (option == 2) {
			System.out.println(Constants.HOW_TO_PLAY_1);
			System.out.println(Constants.HOW_TO_PLAY_2);
		} else {
			option = showGameMenu();
			//Elijo el modo de juego por la opcion escogida
			gm = chooseGameMode(option);
			//Creo el jugador, la maquina y el tablero de la partida dependiendo del modo
			player = new Player(gm);
			system = new GameSystem(gm);
			board = new TableBoard(gm);
			playGame();
		}
	}

	private void playGame() {
		Combination playerComb = null;
		String solution = "";
		boolean winner = false;
		
		while (winner) {
			playerComb = player.newTry();
			solution = system.compareCombinations(playerComb);
			board.addTry(playerComb, solution);
			
			board.drawingGame();
			//decidir quien gana
		}
	}

	private GameMode chooseGameMode(int option) {
		GameMode gm = null;
		
		System.out.println(GAMEMODE_MENU_1);
		System.out.println(GAMEMODE_MENU_2);
		
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
	
	private int showGameMenu() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(GAMEMODE_MENU_1);
		System.out.println(GAMEMODE_MENU_2);
		
		return scn.nextInt();
	}

	private int showMenu() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println(WELCOME);
		System.out.println(MAIN_MENU_1);
		System.out.println(MAIN_MENU_2);
		System.out.println(MAIN_MENU_3);
		
		return scn.nextInt();
	}
}
