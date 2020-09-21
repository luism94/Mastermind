package codes;

import static codes.Colors.*;
import static codes.Constants.*;

public class GamePiece {

	private String pieceColor;
	
	public GamePiece(String color) {
		pieceColor = color;
	}

	public GamePiece() {
		pieceColor = NULL;
	}

	public String getPieceColor() {
		return pieceColor;
	}

	private void setPieceColor(String pieceColor) {
		this.pieceColor = pieceColor;
	}

	public void assignColor(String color) {
		setPieceColor(color);
	}

	public void generatePiece(int colorOption) {
		assignColor(pickColorPiece(colorOption));
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
		return pieceColor + "Ficha";
	}

	protected String drawPiece() {
		return pieceColor + "  ";
	}

	protected String pickColorPiece(int colorOption) {
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
}
