package Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by admin on 2016/12/21.
 */
//�����ⲿ�ļ���������ת��Ϊ��������
public class TileType {
   private  File mapOfFile;
    private  String stringOfMap;
    private Scanner scanner;
    private int number[][];

    public TileType(){
    }

    public TileType(String string) throws FileNotFoundException {
        mapOfFile = new File(string);
        scanner = new Scanner(mapOfFile);
        number = new int[7][9];
         stringOfMap = "";
        for (int i = 0; i < 7; i++) {
            stringOfMap += scanner.nextLine();
            stringOfMap += '\n';
        }
        for(int i = 0; i <7; i++ ){
            for (int j = 0; j < 9;j++){
                number[i][j] = Integer.parseInt(String.valueOf(stringOfMap.charAt(i * 10 + j)));
            }
        }
    }

    //������������
    public int[][] getNumber(){
        return number;
    }

}
