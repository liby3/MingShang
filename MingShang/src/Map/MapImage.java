package Map;

import java.io.FileNotFoundException;

import Player.PlayerActions;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapImage {
	private ImageView mapImage[][];
	public MapImage(int theTeam[][], int numberOfMap[][]) throws FileNotFoundException {
		mapImage = new ImageView[10][10];
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapImage[i][j] = new ImageView();
                if (theTeam[i][j] == PlayerActions.LEFT_PLAYER) {
                    switch (numberOfMap[i][j]) {
                        case 9:
                        	Image capitalCityLeft = new Image("pic/map/capitalCityLeft.png");
                        	mapImage[i][j].setImage(capitalCityLeft);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                            break;
                        case 1:
                        	Image city1 = new Image("pic/map/city1.png");
                        	mapImage[i][j].setImage(city1);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                            break;
                        case 2:
                        	Image city2 = new Image("pic/map/city2.png");
                        	mapImage[i][j].setImage(city2);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                            break;
                            
                        default:
                            mapImage[i][j] = new ImageView();
                            break;
                    }
                }
                else if (theTeam[i][j] == PlayerActions.RIGHT_PLAYER) {
                	switch (numberOfMap[i][j]) {
                    	case 9:
                    		Image capitalCityRight = new Image("pic/map/capitalCityRight.png");
                        	mapImage[i][j].setImage(capitalCityRight);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                        	break;
                    	case 1:
                        	Image city1 = new Image("pic/map/city1.png");
                        	mapImage[i][j].setImage(city1);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                            break;
                        case 2:
                        	Image city2 = new Image("pic/map/city2.png");
                        	mapImage[i][j].setImage(city2);
                        	mapImage[i][j].setFitWidth(100);
                        	mapImage[i][j].setFitHeight(70);
                        	mapImage[i][j].setLayoutX(60 * j + 100);
                        	mapImage[i][j].setLayoutY(50 + 60 * i);
                            break;
                    	default:
                    		mapImage[i][j] = new ImageView();
                    		break;
                	}
                }
                else {
                	mapImage[i][j].setFitWidth(60);
                	mapImage[i][j].setFitHeight(60);
                	mapImage[i][j].setLayoutX(60 * j + 100);
                	mapImage[i][j].setLayoutY(50 + 60 * i);
                }
            }
        }
    }
    public ImageView[][] getMapImage(){
        return mapImage;
    }
}