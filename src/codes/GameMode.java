package codes;

public enum GameMode {

	EASY(4, false, 8), NORMAL(4, 3, false, 8), MEDIUM(6, 3, true, 8);

	private int pieceNum;
	private int colorNum;
	private int trialNum;
	private boolean canBeRepeated;

	GameMode(int pieces, int trials, boolean repeated, int colors) {
		pieceNum = pieces;
		trialNum = trials;
		canBeRepeated = repeated;
		colorNum = colors;
	}
	
	GameMode(int pieces, boolean repeated, int colors) {
		pieceNum = pieces;
		canBeRepeated = repeated;
		colorNum = colors;
	}

	public int getColorNum() {
		return colorNum;
	}
	
	public int getPieceNum() {
		return pieceNum;
	}
	
	public int getTrialNum() {
		return trialNum;
	}
	
	public boolean isRepeated() {
		return canBeRepeated;
	}
}

