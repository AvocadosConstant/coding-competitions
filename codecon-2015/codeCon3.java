//Problem        : Funny Elevators
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


// THIS CODE IS NON-FUNCTIONAL
// RAN OUT OF TIME AND READ THE QUESTION INCORRECTLY
public class codeCon3
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        int floors = in.nextInt();
        int e = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();

        int[][] elevators = new int[e][2];
        
        int min = floors;
        int max = 0;

        for(int i = 0; i < e ; i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(a < min) min = a;
            if(b < min) min = b;
            if(a > max) max = a;
            if(b > max) max = b;

            elevators[i][0] = (a<b) ? a : b;
            elevators[i][1] = (a>b) ? a : b;
        }

       
        int lower = (start<end) ? start : end;
        int higher = (start>end) ? start : end;

        boolean possible = false;

        while(higher - lower > 0) {

            if(max < higher || min > lower) {
                break;
            }
            boolean movedUp = false;

            for(int i = e-1; i >= 0; i--) {

                if(elevators[i][0] <= lower) {
                    lower = elevators[i][1];
                    movedUp = true;
                    //System.out.printf("lower : %d", lower);

                    if(lower >= higher) {
                        possible = true;

                    }
                }

            } 
            if(movedUp == false) {
                //System.out.println("moved Up = false");
                break;
            }
        }
        String s = "HI";

        if(possible) {
            s = "1";
        }
        else {
            s = "0";
        }
        System.out.println(s);

    }


}
