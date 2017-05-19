package Roles;

import Player.PlayerActions;
import javafx.scene.image.Image;

public class Archer extends Character {
	public Archer(int initX, int initY, int team) {
		super(initX, initY, team);
		level = Character.archer;
		attackDistance = Character.attackDistanceLong;
		moveDistance = Character.moveDistanceShort;
		currentDistance = Character.moveDistanceShort;
		if (team == PlayerActions.LEFT_PLAYER) {
			figure = new Image("pic/roles/archerLeft.png");
		}
		else {
			
			figure = new Image("pic/roles/archerRight.png");
		}
		setCharacterViewAttribute();
	}
	
}