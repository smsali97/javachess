import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
	private Color color;
	protected int xval;
	protected int yval;
	
	public Square(int x, int y) {
		super(x,y);
	}
	
	public void setXval(int xval) {
		this.xval = xval;
	}
	public void setYval(int yval) {
		this.yval = yval;
	}
	public int getXval() {
		return xval;
	}
	public int getYval() {
		return yval;
	}
	
	public Square(Color color) {
		if (color.equals(Color.BLACK)) {
			this.color = color;
		}
		else if (color.equals(Color.WHITE)) {
			this.color = color;
		}
		
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
