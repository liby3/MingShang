package Map;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawRectangle {
	private Rectangle rectangle[][];
	public DrawRectangle() {
		rectangle = new Rectangle[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				rectangle[i][j] = new Rectangle();
                rectangle[i][j].setOpacity(0.2);
                rectangle[i][j].setFill(Color.GREY);
                rectangle[i][j].setHeight(60);
                rectangle[i][j].setWidth(60);
                rectangle[i][j].setLayoutX(60 * j + 100);
                rectangle[i][j].setLayoutY(60 + 60 * i);
			}
		}
	}
	
	public void setVisible(int i, int j) {
		rectangle[i][j].setVisible(true);
	}
	
	public void setInVisible(int i, int j) {
		rectangle[i][j].setVisible(false);
	}
	
	public void setOpacity(double value, int i, int j) {
		rectangle[i][j].setOpacity(value);
	}
	
	public Rectangle[][] getRectangle() {
		return rectangle;
	}
	
	public void setYellow(int i, int j) {
		rectangle[i][j].setFill(Color.YELLOW);
	}
	
	public void setBlue(int i, int j) {
		rectangle[i][j].setFill(Color.BLUE);
	}
}