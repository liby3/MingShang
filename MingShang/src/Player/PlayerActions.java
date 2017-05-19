package Player;

import GameRule.Control;
import GameRule.GameHistory;
import Roles.Character;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PlayerActions {
	
	public final static int LEFT_PLAYER = 1;
	public final static int RIGHT_PLAYER = -1;

	private
		int currentPlayer;
		Rectangle left;
		Rectangle right;
	public PlayerActions() {
		currentPlayer = LEFT_PLAYER;
		left = new Rectangle();
        left.setFill(Color.YELLOW);
        left.setWidth(40);
        left.setHeight(40);
        left.setLayoutX(10);
        left.setLayoutY(10);
        left.setEffect(new GaussianBlur(100));
        FadeTransition ft = new FadeTransition(Duration.millis(400),left);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.play();
        left.setVisible(false);
        
        right = new Rectangle();
        right.setFill(Color.YELLOW);
        right.setWidth(40);
        right.setHeight(40);
        right.setLayoutX(800);
        right.setLayoutY(10);
        right.setEffect(new GaussianBlur(100));
        FadeTransition rg = new FadeTransition(Duration.millis(400),right);
        rg.setToValue(0.0);
        rg.setAutoReverse(true);
        rg.setCycleCount(Animation.INDEFINITE);
        rg.play();
        right.setVisible(false);
	}
	
	public void changePlayer() {
		if (currentPlayer == LEFT_PLAYER) {
			currentPlayer = RIGHT_PLAYER;
		}
		else {
			currentPlayer = LEFT_PLAYER;
		}
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void action(int direction, int[][] theTeam, int[][] numberOfRoles, Character[][] rolesImage, int i, int j, Control c, GameHistory h) {
		switch(direction) {
		case Control.UP:
			changePlayer();
			c.up(rolesImage[i][j].getMoveDistance(), theTeam, numberOfRoles, rolesImage, i, j);
			h.addCurrentSteps();
			h.saveRolesHistory(numberOfRoles,h.getCurrentSteps());
			h.saveTeamHistory(theTeam, h.getCurrentSteps());
			break;
		case Control.DOWN:
			changePlayer();
			c.down(rolesImage[i][j].getMoveDistance(), theTeam, numberOfRoles, rolesImage, i, j);
			h.addCurrentSteps();
			h.saveRolesHistory(numberOfRoles,h.getCurrentSteps());
			h.saveTeamHistory(theTeam, h.getCurrentSteps());
			break;
		case Control.LEFT:
			changePlayer();
			c.left(rolesImage[i][j].getMoveDistance(), theTeam, numberOfRoles, rolesImage, i, j);
			h.addCurrentSteps();
			h.saveRolesHistory(numberOfRoles,h.getCurrentSteps());
			h.saveTeamHistory(theTeam, h.getCurrentSteps());
			break;
		case Control.RIGHT:
			changePlayer();
			c.right(rolesImage[i][j].getMoveDistance(), theTeam, numberOfRoles, rolesImage, i, j);
			h.addCurrentSteps();
			h.saveRolesHistory(numberOfRoles,h.getCurrentSteps());
			h.saveTeamHistory(theTeam, h.getCurrentSteps());
			break;
		}
	}
	
	
	public void setPlayer() {
		if (currentPlayer == LEFT_PLAYER) {
			left.setVisible(true);
            right.setVisible(false);
		}
		else {
			right.setVisible(true);
            left.setVisible(false);
		}
	}
	
	public void resetPlayer() {
		currentPlayer = LEFT_PLAYER;
	}
	
	public Rectangle getLeftPlayer() {
		return left;
	}

	public Rectangle getRightPlayer() {
		return right;
	}

}