import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int loops = 0;  //Need to calculate number of loops
            int n = in.nextInt();  //number of towns
            int[] bridges = new int[n+1]; //array of bridge destinations, size is towns+1
            int[] visited = new int[n+1]; 
            ArrayList<Integer> towns = new ArrayList<Integer>();
            
            //add each int in input to bridges
            //bridges[0] will be empty so index 1 corresponds with bridge 1 etc
            for(int j = 1; j <= n; j++) {
                bridges[j] = in.nextInt();
                visited[j] = 0;
                towns.add(j);
            }
            
            while(!towns.isEmpty()) {
                int current = towns.get(0);
                while(visited[current] == 0) {
                    towns.remove(new Integer(current)); //remove current from towns to know we've visited it
                    visited[current] = 1;
                    current = bridges[current];         //new current is town that current town's bridge leads to
                }
                loops++;
            }
            System.out.println(loops - 1);
        }
        in.close();
    }
}