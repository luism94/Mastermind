package codes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static codes.Constants.*;
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

	protected void addTrial(Combination playerComb, String solution) {
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
		String combDrawing = "", header = "", body = "", footer = "", answer = "";
		Iterator<Combination> combinationIterator = playerTrials.iterator(); 
		Iterator<String> answerIterator = systemSolutions.iterator();
		Combination playerComb = null;
		
		if (!gm.repeatedColors()) {
			header = DARK_BOARD + BOARD_LENGTH + "\n";
			body = DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGTH_INNER + DARK_BOARD + BOARD_PIECE + "\n";
			body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_TITLE + DARK_BOARD + BOARD_PIECE + "\n";
			body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGTH_INNER + DARK_BOARD + BOARD_PIECE + "\n";
			while (combinationIterator.hasNext() && answerIterator.hasNext()) {
				playerComb = (Combination) combinationIterator.next();
				combDrawing = playerComb.drawPlayerCombination();
				answer = (String) answerIterator.next();
				body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + " " + combDrawing + DARK_BOARD + " " + LIGHT_BOARD
						+ " " + answer + DARK_BOARD + BOARD_PIECE + "\n";
				body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGTH_INNER + DARK_BOARD + BOARD_PIECE + "\n";
			}
			footer = DARK_BOARD + BOARD_LENGTH + RESET;
		} else {
			header = DARK_BOARD + BOARD_LENGTH_MED + "\n";
			body = DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGHT_INNER_MED + DARK_BOARD + BOARD_PIECE + "\n";
			body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_TITLE_MED + DARK_BOARD + BOARD_PIECE + "\n";
			body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGHT_INNER_MED + DARK_BOARD + BOARD_PIECE + "\n";
			while (combinationIterator.hasNext() && answerIterator.hasNext()) {
				playerComb = (Combination) combinationIterator.next();
				combDrawing = playerComb.drawPlayerCombination();
				answer = (String) answerIterator.next();
				body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + " " + combDrawing + DARK_BOARD + " " + LIGHT_BOARD
						+ " " + answer + DARK_BOARD + BOARD_PIECE + "\n";
				body += DARK_BOARD + BOARD_PIECE + LIGHT_BOARD + BOARD_LENGHT_INNER_MED + DARK_BOARD + BOARD_PIECE + "\n";
			}
			footer = DARK_BOARD + BOARD_LENGTH_MED + RESET;
		}
		System.out.println(header + body + footer);
	}

	public boolean checkWinner() {
		String lastAnswer = systemSolutions.get(systemSolutions.size() - 1), winner = "";
		
		for (int i = 0; i < gm.getPieceNumber(); i++) {
			winner += RED + "  " + LIGHT_BOARD + " ";
		}
		
		if (lastAnswer.equals(winner)) {
			return true;
		} else {
			return false;
		}
	}
}
