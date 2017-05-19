package FileOperation;


import java.io.FileNotFoundException;

/**
 * Created by liboyang on 2017.4.9
 */
//�̳�TileType�࣬���ڻ�ȡ��ͼ����������
public class ReadMap extends TileType {
    private int numberOfMap[][];
    private int[][] theTeam;
    public ReadMap() throws FileNotFoundException {
    	super("file.txt");
    	numberOfMap = new int[10][10];
    	theTeam = new int[10][10];
    	for(int i = 0; i < 10; i++) {
    		for(int j = 0; j < 10; j++) {
    			numberOfMap[i][j] = this.getNumber()[i][j];
    		}
    	}
    	
    	for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
               if (numberOfMap[i][j] != 0 && j < 4) {
                   theTeam[i][j] = 1;
               }
               else if (numberOfMap[i][j] != 0 && j > 4) {
                   theTeam[i][j] = -1;
               }
               else {
                   theTeam[i][j] = 0;
               }
            }
        }
    }

    public int[][] getNumberOfMap() {
        return numberOfMap;
    }
    
    public int[][] getTheTeam(){
        return theTeam;
    }
}



