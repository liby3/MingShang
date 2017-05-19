package Roles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class Character {
	public final static int infantry = 1;
	public final static int archer = 2;
	public final static int cavalryman = 3;
	public final static int nocharacter = -1;

	public final static int attackDistanceShort = 1;
	public final static int attackDistanceLong = 2;
	
	public final static int moveDistanceShort = 1;
	public final static int moveDistanceLong = 2;
	
	protected		
		int team;
		int level;
		int moveDistance;
		int currentDistance;
		int attackDistance;
		int initX;
		int initY;
		int currentX;
		int currentY;
		Image figure;
		ImageView characterview;

	
	public Character(int x, int y, int _team) {
		team = _team;
		initX = x;
		initY = y;
		currentX = x;
		currentY = y;
		figure = null;
		level = -1;
		moveDistance = -1;
		currentDistance = -1;
		attackDistance = -1;
		characterview = new ImageView();
	}
	
	public int getTeam() {
		return team;
	}
	
	public int getinitX() {
		return initX;
	}
	
	public int getinitY() {
		return initY;
	}
	
	public int getCurrentX() {
		return currentX;
	}
	
	public int getCurrentY() {
		return currentY;
	}
	
	public int getMoveDistance() {
		return currentDistance;
	}
	
	public int getAttackDistance() {
		return attackDistance;
	}
	
	public int getLevel() {
		return level;
	}

	public Image getFigure() {
		return figure;
	}
	
	public ImageView getCharacterView() {
		return characterview;
	}
	
	public void setCurrentMoveDistance(int distance) {
		currentDistance = distance;
	}
	
	protected void setCharacterViewAttribute() {
		characterview = new ImageView();		
		if (figure != null) {
			characterview.setImage(figure);
			characterview.setFitWidth(40);
			characterview.setFitHeight(60);
			characterview.setLayoutX(60 * currentY + 100);
			characterview.setLayoutY(60 + 60 * currentX);
		}
		else {
			
			characterview.setFitWidth(40);
			characterview.setFitHeight(60);
			characterview.setLayoutX(60 * currentY + 100);
			characterview.setLayoutY(60 + 60 * currentX);
		}
	}
};
