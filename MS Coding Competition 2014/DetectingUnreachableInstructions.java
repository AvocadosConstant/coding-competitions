import java.util.ArrayList;

public class DetectingUnreachableInstructions 
{
	public ArrayList<String> detect(ArrayList<String> input)
	{
		//Creates arraylist to output
		ArrayList<String> lineNumbers = new ArrayList<String>();	
		
		lineNumbers.add("");
		
		//fills output arraylist with all line numbers in each index
		for(int i = 1; i < input.size(); i++)						
		{
			lineNumbers.add(new Integer(i).toString());
		}
		
		int i = 1;
		
		while(true)
		{
			//lines that have been touched are replaced with a blank string. 
			//If the current line is blank, break out of the loop.
			if(lineNumbers.get(i) == "") break;
			
			//sets current line number which has been touched to ""
			lineNumbers.set(i, "");
						
			//if the current line says next, go to the next line.
			if(input.get(i) == "NEXT") i++;
			
			//if not, it says GOTO X. X is the 5th index.
			//Set the current line number to the number at the 5th index.
			else i = Integer.parseInt(input.get(i).substring(5));
		}
				
		return lineNumbers;
	}
	
	public static void main(String[]args)
	{
//		NEXT
//		NEXT
//		GOTO 5
//		NEXT
//		GOTO 1
//		NEXT
		
		DetectingUnreachableInstructions name = new DetectingUnreachableInstructions();
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("");input.add("NEXT");input.add("NEXT");input.add("GOTO 5");input.add("NEXT");input.add("GOTO 1");input.add("NEXT");
		
		ArrayList<String> output = new ArrayList<String>();
		
		output = name.detect(input);
		
		for(int i = 0; i < output.size(); i++)
		{
			if(output.get(i).compareTo("") == 0) output.remove(i);
		}
		
		for(String s: output)
		{
			System.out.println(s);
		}
	}
}
