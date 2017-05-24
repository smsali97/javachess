import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ChessBoard {
	protected GridPane board;
	public static int size = 40;
	protected StackPane[][] panes;
	protected Square[][] squares;
	
	// sets pieces
	private ChessPiece[] pawn = new Pawn[16];
//	private ChessPiece[] pawn = new WhitePawn[8];
	//private ChessPiece[] pawn = new Pawn[16];
	
	
	public ChessBoard() {
		// TODO Auto-generated constructor stub
		/*
		 * 0 1 2 3 4 5 6 7
		 * 
		 * 8 W B W B W B W B 0 7 B W B W B W B W 1 6 W B W B W B W B 2 5 B W B W
		 * B W B W 3 4 W B W B W B W B 4 3 B W B W B W B W 5 2 W B W B W B W B 6
		 * 1 B W B W B W B W 7
		 * 
		 * A B C D E F G H
		 */
		board = new GridPane();
		board.setHgap(0);
		board.setVgap(0);
		board.setAlignment(Pos.CENTER);

		panes = new StackPane[8][8];
		squares = new Square[8][8];

		for (int i = 0; i < 8; i++) {
			pawn[i] = new BlackPawn();
		}
		for (int i = 8; i < 16; i++) {
			pawn[i] = new WhitePawn();
		}
		
		
		// Color each square alternatively
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				setupBoard(squares, panes);
				
				if (j == 1 && pawn[i] instanceof BlackPawn) {
					
					pawn[i].setValues(i, j);
					panes[i][j].getChildren().add(pawn[i]);

				}

				else if (j == 6 && pawn[i+8] instanceof WhitePawn) {
					pawn[i].setValues(i,j);
					panes[i][j].getChildren().add(pawn[i+8]);
				}
				else
					panes[i][j].getChildren().add(new ChessPiece(ChessPiece.blankImage));
				
				
				
				board.setVgap(0);
				board.setHgap(0);
				board.setPadding(Insets.EMPTY);
				board.add(panes[i][j], i, j);
			}

		}
		

	}

	public GridPane getBoard() {
		return board;
	}
	
	public Square getSquare(int p, int q) {
		return squares[p][q];
	}
	
	public StackPane[][] getPanes() {
		return this.panes;
	}

	

	public static void setupBoard(Square[][] squares, StackPane[][] panes) {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				squares[i][j] = new Square(size, size);
				squares[i][j].setXval(i);
				squares[i][j].setYval(j);
				// set colors alternatively
				int rem = (i + j) % 2;
				if (rem == 0) {
					squares[i][j].setFill(Color.MAROON);
				} else {
					squares[i][j].setFill(Color.PALEGOLDENROD);

				}

				panes[i][j] = new StackPane(squares[i][j]);
				panes[i][j].setPadding(Insets.EMPTY);
			}
		}
	}

	}

