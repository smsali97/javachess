import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pawn extends ChessPiece {

	public static Image whiteImage;
	public static Image blackImage;
	private boolean isBlack;

	public Pawn(Color color, Image img) {
		super(img);

		if (color.equals(Color.BLACK)) {
			isBlack = true;

		} else if (color.equals(Color.WHITE)) {
			isBlack = false;

			

		}

	}

	static {
		whiteImage = new Image("file:white_pawn.png");
		blackImage = new Image("file:black_pawn.png");
	}

	public boolean isBlack() {
		return isBlack;
	}

	public int[] possiblePaths() {
		int[] arry = new int[7 - this.yval];

		for (int i = this.yval; i < 7; i++) {
			arry[i] = i;
		}

		return arry;
	}

}
