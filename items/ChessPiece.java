

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public  class ChessPiece extends ImageView {
	// color attribute of the chess piece
	public static Image blankImage = new Image("file:empty.png");
	
	
	
	
	private boolean isBlack;
	protected int xval;
	protected int yval;
	private static int tempx = -1;
	private static int tempy = -1;
	protected Image image;
	
	public ChessPiece(Image img) {
		super(img);
		image = img;
		super.setFitHeight(ChessBoard.size*0.75);
		super.setFitWidth(ChessBoard.size*0.75);
		
		if (img == ChessPiece.blankImage) {
			this.setOpacity(0);
			//System.out.println("Hello!");
		}
		
		this.setOnDragDetected(e -> {
			Dragboard db = this.startDragAndDrop(TransferMode.MOVE);
			ClipboardContent cc = new ClipboardContent();
			tempx = this.xval;
			tempy = this.yval;
			cc.putImage(this.getImage());
			db.setContent(cc);
			e.consume();
			
			
		});
		
		this.setOnDragDone(e -> {
			if (e.getTransferMode() == TransferMode.MOVE && image != null){
				this.image = ChessPiece.blankImage;
				System.out.println("duhn.");
				this.remove(ChessGame.board.getPanes());
				e.consume();
				this.setOpacity(0);
			}
		});

		this.setOnDragOver(e -> {
			if (e.getGestureSource() != this &&  (e.getDragboard().hasImage()) ) {
				e.acceptTransferModes(TransferMode.MOVE);
				e.consume();
			}
		});

		this.setOnDragEntered(e -> {
			if (e.getGestureSource() != this && e.getDragboard().hasImage()) {
				DropShadow ds = new DropShadow(0.4, Color.BLACK);
				ChessGame.board.getSquare(this.xval, this.yval).setFill(Color.BLUE);
				this.setEffect(ds);
				e.consume();
			}
		});

		this.setOnDragExited(e -> {
			DropShadow ds = new DropShadow(0, Color.BLACK);
			this.setEffect(ds);
			e.consume();
		});

		this.setOnDragDropped(e -> {
			
			Dragboard db2 = e.getDragboard();
			boolean success = false;
			if (db2.hasImage() && tempx != -1) {
				this.setImage(db2.getImage());
				success = true;
				xval = tempx;
				yval = tempy;
				tempx = -1;
				tempy = -1;
				this.setOpacity(100);
			}
			e.setDropCompleted(success);
			e.consume();
		});

		
		
	}
	
	public int getXval() {
		return xval;
	}
	public int getYval() {
		return yval;
	}
	
	public void setValues(int x, int y) {
		this.xval = x;
		this.yval = y;
	}
		
	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	// how the chess piece moves

	
	// adds a chess piece to a pane
	public void add(StackPane[][] panes, int x, int y) {
		panes[x][y].getChildren().add(this);
	}
	
	// removes chess piece from pane
	public void remove(StackPane[][] panes) {
		panes[xval][yval].getChildren().remove(this);
	}
	
	
	
}
