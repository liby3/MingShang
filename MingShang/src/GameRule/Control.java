package GameRule;


import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;

/**
 * Created by admin on 2016/12/30.
 */
@SuppressWarnings("unused")
public class Control {
    public Control()  {
    }

    //һ�������ƶ�
    public void turnUp(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i - 1][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i - 1][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i - 1][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //һ�������ƶ�
    public void turnDown(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i + 1][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i + 1][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i + 1][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //һ�������ƶ�
    public void turnLeft(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j - 1] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j - 1] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j - 1].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //һ�������ƶ�
    public void turnRight(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j + 1] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j + 1] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j + 1].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //ʨ����������
    public void jumpUp(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i - 3][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i - 3][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i - 3][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //ʨ����������
    public void jumpDowwn(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i + 3][j] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i + 3][j] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i + 3][j].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);

    }

    //ʨ����������
    public void jumpLeft(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j - 4] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j - 4] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j - 4].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

   // ʨ����������
    public void jumpRight(int[][] theTeam, int[][] numberOfAnimal, ImageView[][] animalImage, int i, int j, boolean player) {
        theTeam[i][j + 4] = theTeam[i][j];
        theTeam[i][j] = 0;
        numberOfAnimal[i][j + 4] = numberOfAnimal[i][j];
        numberOfAnimal[i][j] = 0;
        animalImage[i][j + 4].setImage(animalImage[i][j].getImage());
        animalImage[i][j].setImage(null);
    }

    //�ı������rectangles�ɷ���
    public void setDisable(int[][] theTeam, boolean player, Rectangle[][] rectangles) {
     if(player){
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 9; j++) {
                 if(theTeam[i][j] == -1)
                     rectangles[i][j].setDisable(true);
                 else
                     rectangles[i][j].setDisable(false);
     }
         }
     }else {
         for (int i = 0; i < 7; i++) {
             for (int j = 0; j < 9; j++) {
                 if(theTeam[i][j] == 1)
                     rectangles[i][j].setDisable(true);
                 else
                     rectangles[i][j].setDisable(false);
             }
         }
     }
    }

    //�жϵ�ǰ�����Ƿ��ѵ��һ������
    public boolean isClick(Rectangle[][] rectangle) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (rectangle[i][j].getOpacity() < 0.3) {
                    count++;
                }
            }
        }
        if (count == 63)
            return false;
        else
            return true;
    }
    }
