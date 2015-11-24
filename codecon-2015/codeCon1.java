import java.util.Scanner;
import java.lang.StringBuffer;

//Your submission should *ONLY* use the following class name
public class codeCon1
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        //int num = in.nextInt();
        //num = 26;
        //System.out.println(num);

        for(int i = 1; i < 200; i++) convert(i);


    }

    public static void convert(int num) {
        StringBuffer sb = new StringBuffer();
        System.out.print(num + ":");
        
        while(num > 0) {

            int val = num%26;

            if(val == 0) {
                val = 90;
                num = num/ 26 - 1;
            }
            else {
                val += 64;
                num = num/26;
            }
                
            //if(val == 64) val = 90;
            
            char cur = (char) val;
            sb.append(cur);

            //if(num % 26 == 25) num -= 26;
            //else num = num/26;
        }
        System.out.println(sb.reverse().toString().toUpperCase());
    }

}
