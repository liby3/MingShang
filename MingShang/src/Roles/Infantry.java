package Roles;

import Player.PlayerActions;
import javafx.scene.image.Image;

public class Infantry extends Character {

	public Infantry(int initX, int initY, int team) {
		super(initX, initY, team);
		level = Character.infantry;
		attackDistance = Character.attackDistanceShort;
		moveDistance = Character.moveDistanceShort;
		currentDistance = Character.moveDistanceShort;
		if (team == PlayerActions.LEFT_PLAYER) {
			figure = new Image("pic/roles/infantryLeft.png");
		}
		else {
			
			figure = new Image("pic/roles/infantryRight.png");
		}
		setCharacterViewAttribute();
	}
	
	
}