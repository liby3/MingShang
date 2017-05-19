package FileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liboyang on 2017.4.9
 */

public class TileType {
    private File mapOfFile;
    private String stringOfMap;
    private Scanner scanner;
    private int number[][];

    public TileType() {
    
    }

    public TileType(String string) throws FileNotFoundException {
        mapOfFile = new File(string);
        scanner = new Scanner(mapOfFile);
        number = new int[10][10];
        stringOfMap = "";
        for (int i = 0; i < 10; i++) {
            stringOfMap += scanner.nextLine();
            stringOfMap += '\n';
        }
        for (int i = 0; i < 10; i++ ) {
            for (int j = 0; j < 10;j++) {
                number[i][j] = Integer.parseInt(String.valueOf(stringOfMap.charAt(i * 11 + j)));
            }
        }
    }

    public int[][] getNumber() {
        return number;
    }
}