package codes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static codes.Colors.*;

public class TableBoard implements DrawBoard{

	private GameMode gm;
	private List<PieceCombination> playerTrials;
	private List<String> systemSolutions;
	
	private final int MAXLENGTH = gm.getPieceNumber() * 3;
	private final int MAXPIECES = gm.getPieceNumber();
	
	public TableBoard(GameMode mode) {
		gm = mode;
		playerTrials = new ArrayList<PieceCombination>();
		systemSolutions = new ArrayList<String>();
	}

	protected void addTrial(PieceCombination playerComb, String solution) {
		playerTrials.add(playerComb);
		systemSolutions.add(solution);
	}

	public List<PieceCombination> getPlayerTrials() {
		return playerTrials;
	}
	
	public List<String> getSystemSolutions() {
		return systemSolutions;
	}

	@Override
	public void drawingGame() {
		String combDrawing = "", header = "", body = "", footer = "", answer = "";
		Iterator<PieceCombination> combinationIterator = playerTrials.iterator(); 
		Iterator<String> answerIterator = systemSolutions.iterator();
		PieceCombination playerComb = null;
		
		header = DARK_BOARD + "                              " + "\n";
		body = DARK_BOARD + "  " + LIGHT_BOARD + "                          " + DARK_BOARD + "  " + "\n";
		while (combinationIterator.hasNext() && answerIterator.hasNext()) {
			playerComb = (PieceCombination) combinationIterator.next();
			combDrawing = playerComb.drawPlayerCombination();
			answer = (String) answerIterator.next();
			body += DARK_BOARD + "  " + LIGHT_BOARD + " " + combDrawing + " " + answer + DARK_BOARD + "  " + "\n";
			//System.out.println(combDraw + "  " + sol);
			body += DARK_BOARD + "  " + LIGHT_BOARD + "                          " + DARK_BOARD + "  " + "\n";
		}
		footer = DARK_BOARD + "                              " + RESET;
		System.out.println(header + body + footer);
	}

	public boolean checkWinner() {
		int redCount = 0, answerIndex = 0;
		String lastAnswer = systemSolutions.get(systemSolutions.size() - 1), winner = "";
		
		for (int i = 0; i < MAXPIECES; i++) {
			winner += RED + "  " + LIGHT_BOARD + " ";
		}

		while (answerIndex < lastAnswer.length()) {
			if (lastAnswer.substring(answerIndex, answerIndex + MAXLENGTH).equals(winner)) {
				redCount++;
			}
			
			answerIndex += MAXLENGTH;
		}
		
		if (redCount == MAXPIECES) {
			return true;
		} else {
			return false;
		}
	}
}
