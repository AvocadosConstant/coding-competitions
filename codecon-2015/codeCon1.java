import java.util.Scanner;
import java.lang.StringBuffer;

public class codeCon1
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        convert(in.nextInt());
    }

    public static void convert(int num) {
        StringBuffer sb = new StringBuffer();
        System.out.print(num + ":");
        
        while(num > 0) {
            int val = num % 26;

            if(val == 0) {
                val = 90;
                num = num / 26 - 1;
            }
            else {
                val += 64;
                num = num / 26;
            }
            char cur = (char) val;
            sb.append(cur);
        }
        System.out.println(sb.reverse().toString().toUpperCase());
    }
}
