package codes;

public class GamePiece {

	private String pieceColor;
	
	public GamePiece(String color) {
		pieceColor = color;
	}

	public void assignColor(String color) {
		setPieceColor(color);
	}

	public String getPieceColor() {
		return pieceColor;
	}

	private void setPieceColor(String pieceColor) {
		this.pieceColor = pieceColor;
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
		return pieceColor + "Ficha";
	}

	protected String drawPiece() {
		return pieceColor + "  ";
	}
}
