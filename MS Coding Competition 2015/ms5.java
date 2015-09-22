import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        
        String currentLine;
        while(in.hasNextLine()) {
            currentLine = in.nextLine();
            
            while(currentLine.indexOf('.') >= 0 || currentLine.indexOf('?') >= 0 || currentLine.indexOf('!') >= 0) {
                int index = -2;
                if(currentLine.indexOf('.') != -1) {
                    if(index == -2) index = currentLine.indexOf('.');
                }
                if(currentLine.indexOf('?') != -1) {
                    if(index == -2) index = currentLine.indexOf('?');
                    else index = (index < currentLine.indexOf('?')) ? index : currentLine.indexOf('?');
                }
                if(currentLine.indexOf('!') != -1) {
                    if(index == -2) index = currentLine.indexOf('!');
                    else index = (index < currentLine.indexOf('!')) ? index : currentLine.indexOf('!');
                }
                if(currentLine.substring(0, index + 1).startsWith(" ")) input.add(currentLine.substring(1, index + 1));
                else input.add(currentLine.substring(0, index + 1));
                currentLine = currentLine.substring(index + 1, currentLine.length());
            }
            input.add("END OF LINE");
        }
        
        for(int i = 0; i < input.size(); i++) {
            if(! input.get(i).equals("END OF LINE")) 
                input.set(i, input.get(i).substring(0, 1).toUpperCase() + input.get(i).substring(1).toLowerCase());
        }
        
        for(int i = 0; i < input.size(); i++) {
            if(input.get(i).equals("END OF LINE")) System.out.println("");
            else {
                System.out.print(input.get(i));
                if(i<input.size() && !input.get(i+1).equals("END OF LINE")) {
                    if(!(input.get(i+1).equals(".") || input.get(i+1).equals("!") || input.get(i+1).equals("?")))
                        System.out.print(" ");
                }
            }
        }
    }
}