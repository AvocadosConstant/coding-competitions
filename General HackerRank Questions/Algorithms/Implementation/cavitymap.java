import java.io.*;
import java.util.*;

public class cavitymap {

    public static void printMap(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static boolean validateOnBoard(char x, char y, char[][]map) {
        return x >= '0' && x < Character.toChar(map.length) && y>='0' && y < Character.toChar(map[0].length);
    }
    
    public static boolean validateCavity(int x, int y, int[][]map) {
        
        if(validateOnBoard(x,y-1, map)) {
            if(map[x][y-1] > map[x][y]) return false;
        }
        else return false;
        
        if(validateOnBoard(x-1,y, map)) {
            if(map[x-1][y] > map[x][y]) return false;
        }
        else return false;
        
        if(validateOnBoard(x,y+1, map)) {
            if(map[x][y+1] > map[x][y]) return false;
        }
        else return false;
        
        if(validateOnBoard(x+1,y, map)) {
            if(map[x+1][y] > map[x][y]) return false;
        }
        else return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        char[][] map = new char[size][size];
        
        for(int i = 0; i < size; i++) {
            String row = in.nextLine();
            for(int j = 0; j < size; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        
        in.close();
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                //CANT DO THIS need to first save all locations
                //then replace after.
                //X will mess with ValidatePosition.
                if(validateCavity(i,j,map)) map[i][j] = 'X';
            }
        }
        
        printMap(map);
    }
}