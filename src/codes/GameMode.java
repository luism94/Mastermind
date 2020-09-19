package codes;

public enum GameMode {

	EASY(4, false, 8), NORMAL(4, 3, false, 8), MEDIUM(6, 3, true, 8);

	private int pieceNumber;
	private int colorNumber;
	private int trialMax;
	private boolean colorRepetition;

	GameMode(int pieces, int trials, boolean repetition, int colors) {
		pieceNumber = pieces;
		trialMax = trials;
		colorRepetition = repetition;
		colorNumber = colors;
	}
	
	GameMode(int pieces, boolean repeated, int colors) {
		pieceNumber = pieces;
		colorRepetition = repeated;
		colorNumber = colors;
	}

	public int getColorNumber() {
		return colorNumber;
	}
	
	public int getPieceNumber() {
		return pieceNumber;
	}
	
	public int getTrialMax() {
		return trialMax;
	}
	
	public boolean repeatedColors() {
		return colorRepetition;
	}
}

