package Map;


import java.io.FileNotFoundException;

/**
 * Created by admin on 2016/12/20.
 */
//�̳�TileType�࣬���ڻ�ȡ��ͼ����������
public class Map extends TileType{
    private int numberOfMap[][];

public Map() throws FileNotFoundException {
    super("file.txt");
    numberOfMap = new int[7][9];
    for(int i = 0; i < 7; i++){
        for(int j = 0; j < 9; j++){
            numberOfMap[i][j] = this.getNumber()[i][j];
        }
    }
     }
     //���ص�ͼ����������
    public int[][] getNumberOfMap() {
        return numberOfMap;
    }
    }




