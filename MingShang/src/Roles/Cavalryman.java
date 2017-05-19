package Roles;

import Player.PlayerActions;
import javafx.scene.image.Image;

public class Cavalryman extends Character {
	public Cavalryman(int initX, int initY, int team) {
		super(initX, initY, team);
		level = Character.cavalryman;
		attackDistance = Character.attackDistanceShort;
		moveDistance = Character.moveDistanceLong;
		currentDistance = Character.moveDistanceShort;
		if (team == PlayerActions.LEFT_PLAYER) {
			figure = new Image("pic/roles/cavalrymanLeft.png");
		}
		else {
			
			figure = new Image("pic/roles/cavalrymanRight.png");
		}
		setCharacterViewAttribute();
	}
}