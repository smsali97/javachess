import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessGame extends Application {
	protected static ChessBoard board;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		board = new ChessBoard();
		
		
		
		
		Scene scene = new Scene(board.getBoard(),8*ChessBoard.size, 8*ChessBoard.size);
		primaryStage.setTitle("ChessBoard");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);
		// TODO Auto-generated method stub
		
	}

}
