import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        
        char[][] board = new char[m][n];
        
        for(int j = 0; j < n; j++) {
            String row = in.nextLine();
            for(int i = 0; i < m; i++) {    //iterate through elements of row
                board[i][j] = row.charAt(i);
            }
        }
        
        //printBoard(board);
        
        //System.out.println("Solutions: " + recur(board, 0));
        System.out.println(recur(board, 0));
        //printBoard(board);
        in.close();
    }
    
    public static int recur(char[][] board, int row) {
        if(board == null) return 0;
        if(row == board[0].length) {
            //System.out.println("Found a solution!");
            return 1;
        }
        int sols = 0;

        for (int i = 0; i<board.length; i++) {
            sols += recur(validateAtPos(board, i, row), row+1);
        }
        return sols;
    }

    //returns null if doesn't validate
    public static char[][] validateAtPos(char[][] board, int x, int y) {
        
        if(board[x][y] == '*') return null;
        
        //System.out.println("Validating pos (" + x + "," + y + ")");
        
        int a, b, c = 1, d = 1;
        for (int i = 0; i < 4; i++) {
            
            switch (i) {
                case 1: c = -1; d =  1; break;
                case 2: c =  1; d = -1; break;
                case 3: c = -1; d = -1; break;
            }
            a = x + c;
            b = y + d;
            while(a < board.length && b < board[0].length && a >= 0 && b >= 0) {
                
                //System.out.println("Checking pos (" + a + "," + b + ")");
                
                if(board[a][b] == 'B') {
                    //System.out.println("    Ran into a B at (" + a + "," + b + ")"); 
                    return null;
                }
                if(board[a][b] == '*') break;
                board[a][b] = 'X';  //signifies a sightline
                a+=c;
                b+=d;
            }
        }
        board[x][y] = 'B';
        //printBoard(board);
        return board;
    }
    
    public static void printBoard(char[][] board) {
        for(int i = 0; i < board[0].length; i++) {        //iterate through rows
            for(int j = 0; j < board.length; j++) {    //iterate through elements of row
                System.out.print(board[j][i]);
            }
            System.out.println("");
        }
    }
}

/*
8 8
........
........
........
........
........
........
........
........
*/

/*

3 5
.**..
.*...
*....

*/