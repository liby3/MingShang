package FileOperation;

import java.io.FileNotFoundException;



public class ReadRoles extends TileType {
	private int team[][];
	private int roles[][];

	public ReadRoles() throws FileNotFoundException {
        super("role.txt");
        roles = new int[10][10];
        team = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                roles[i][j] = this.getNumber()[i][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
               if (roles[i][j] != 0 && j <= 4) {
                   team[i][j] = 1;
                   if (roles[i][j] == 1) {

                   }
                   else if (roles[i][j] == 2) {
                	   
                   }
               }
               else if (roles[i][j] != 0 && j > 4) {
                   team[i][j] = -1;
                   if (roles[i][j] == 1) {

                   }
                   else if (roles[i][j] == 2) {
                	   
                   }
               }
               else {
                   team[i][j] = 0;
               }
            }
        }
    }
	
	public int[][] getNumberOfRoles() {
        return roles;
    }

    public int[][] getTheTeam(){
        return team;
    }

}
