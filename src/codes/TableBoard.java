package codes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static codes.Colors.*;

public class TableBoard implements DrawBoard{

	private GameMode gm;
	private List<Combination> playerTrials;
	private List<String> systemSolutions;
	
	public TableBoard(GameMode mode) {
		gm = mode;
		playerTrials = new ArrayList<Combination>();
		systemSolutions = new ArrayList<String>();
	}

	public void addTry(Combination playerComb, String solution) {
		playerTrials.add(playerComb);
		systemSolutions.add(solution);
	}

	public List<Combination> getPlayerTrials() {
		return playerTrials;
	}
	
	public List<String> getSystemSolutions() {
		return systemSolutions;
	}

	@Override
	public void drawingGame() {
		String board = "";
		String combDraw = "";
		boolean end = false;
		Iterator combIt = playerTrials.iterator();
		Iterator solIt = systemSolutions.iterator();
		Combination comb = null;
		String sol = "";
		
		while (combIt.hasNext() && solIt.hasNext()) {
			comb = (Combination) combIt.next();
			combDraw = comb.drawCombination();
			sol = (String) solIt.next();
			System.out.println("Jugador: " + combDraw + "Resultado: " + sol);
		}
	}

	public boolean endGame(String solution) {
		int redCount = 0, solIndex = 0;
		
		while (solIndex < solution.length()) {
			if (solution.substring(solIndex, solIndex).equals(RED + "  " + RESET + " ")) {
				redCount++;
			}
			
			solIndex += 3;
		}
		
		if (redCount == 4) {
			return true;
		} else {
			return false;
		}
	}

	
}
