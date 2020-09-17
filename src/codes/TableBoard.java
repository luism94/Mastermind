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
		String head, body, foot = "";
		boolean end = false;
		Iterator combIt = playerTrials.iterator();
		Iterator solIt = systemSolutions.iterator();
		Combination comb = null;
		String sol = "";
		
		head = DARK_BOARD + "                              " + "\n";
		body = DARK_BOARD + "  " + LIGHT_BOARD + "                          " + DARK_BOARD + "  " + "\n";
		while (combIt.hasNext() && solIt.hasNext()) {
			comb = (Combination) combIt.next();
			combDraw = comb.drawCombination();
			sol = (String) solIt.next();
			body += DARK_BOARD + "  " + LIGHT_BOARD + " " + combDraw + " " + sol + " " + DARK_BOARD + "  " + "\n";
			//System.out.println(combDraw + "  " + sol);
			body += DARK_BOARD + "  " + LIGHT_BOARD + "                          " + DARK_BOARD + "  " + "\n";
		}
		foot = DARK_BOARD + "                              " + "\n";
		System.out.println(head + body + foot);
	}

	public boolean checkWinner() {
		int redCount = 0, solIndex = 0;
		String lastSol = systemSolutions.get(systemSolutions.size() - 1);

		while (solIndex < lastSol.length()) {
			if (lastSol.substring(solIndex, solIndex + 12).equals(RED + "  " + RESET + " ")) {
				redCount++;
			}
			
			solIndex += 12;
		}
		
		if (redCount == 4) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
