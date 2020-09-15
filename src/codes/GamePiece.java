package codes;

import static codes.Colors.*;

public class GamePiece {

	private String pieceColor;
	
	public String getPieceColor() {
		return pieceColor;
	}

	public GamePiece(String color) {
		pieceColor = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof GamePiece) {
			if (pieceColor == ((GamePiece)obj).pieceColor) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pieceColor + "ficha" + RESET;
	}

	public void assignColor(String color) {
		setPieceColor(color);
	}

	private void setPieceColor(String pieceColor) {
		this.pieceColor = pieceColor;
	}

	public String drawPiece() {
		return pieceColor + "  ";
	}
}
