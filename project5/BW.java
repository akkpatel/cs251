import java.util.*;
import java.util.Arrays;
/*
public class BW
{
       
       
        private static void reverse(StringBuilder sb, int head, int tail)
        {
                char temp;
                while(head<tail)
                {
                        temp = sb.charAt(head);
                        sb.setCharAt(head, sb.charAt(tail));
                        sb.setCharAt(tail, temp);
                        head++;
                        tail--;
                }
               
        }
       
        private static String rotate(String s, int i, int j)
        {
                StringBuilder temp = new StringBuilder(s);
                reverse(temp, 0, i-1);
                reverse(temp, i, j-1);
                reverse(temp, 0, j-1);
                return temp.toString();
        }
       
        public static void sort(String[] a, int W)
        {
                int R = 256;
                int N = a.length;
                String[] aux = new String[N];
                 for (int d = W-1; d >= 0; d--)
                 {
                    int[] count = new int[R+1];
                    for (int i = 0; i < N; i++)
                       count[a[i].charAt(d) + 1]++;
                    for (int r = 0; r < R; r++)
                       count[r+1] += count[r];
                    for (int i = 0; i < N; i++)
                       aux[count[a[i].charAt(d)]++] = a[i];
                    for (int i = 0; i < N; i++)
                       a[i] = aux[i];
                 }
        }
        public static void decodeSort(char[] a)
        {
                int R = 256;
                int N = a.length;
                char[] aux = new char[N];
                int[] count = new int[R+1];
               
                for (int i = 0; i < N; i++)
                        count[a[i]+1]++;
               
                for (int r = 0; r < R; r++)
                        count[r+1] += count[r];
               
                for (int i = 0; i < N; i++)
                        aux[count[a[i]]++] = a[i];
               
                for (int i = 0; i < N; i++)
                        a[i] = aux[i];
        }
       
       
        // apply Burrows-Wheeler encoding, reading from standard input
    // and writing to standard output
    public static void encode()
    {
 
        String s = BinaryStdIn.readString();
        //String s = "ABRACADABRA!";
        int len = s.length();
        int key = 0;
       
        // generating rotating string table
        String[] table = new String[len];
        for (int i = 0 ; i < len; i++)
        {
                table[i] = rotate(s, i, len);
        }
       
        // sort the table
        String[] sorted = new String[len];
        for(int i = 0 ; i < len; i++)
        {
                sorted[i] = table[i];
        }
        sort(sorted, len);
       
        //generating encoded string
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < len; i++)
                result.append(sorted[i].charAt(len-1));
       
        //find the key index   
        for(int i = 0 ; i < table.length; i++)
        {
                if(sorted[i].equals(s))
                {
                        key = i;
                        break;
                }
        }
               
        // output part
       
        BinaryStdOut.write(key);
       
        for(int i = 0 ; i < len; i++)
                BinaryStdOut.write(result.charAt(i)); // generate the output character by character
       
        BinaryStdOut.close();
       
    }
 
    // apply Burrows-Wheeler decoding, reading from standard input
    // and writing to standard output
    public static void decode()
    {
       
       
        int a = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        int len = t.length();
       
        //variables for generating next[] array
        int[] next = new int[len];
        char[] original = t.toCharArray();
        char[] temp = t.toCharArray();
        boolean[] flag = new boolean[len];
        for(int i = 0 ; i < len; i++)
        {
                flag[i] = true;
        }
       
        //sort the encoded string
        decodeSort(temp);
       
        //generating next[] array
        for(int i = 0 ; i < len; i++)
        {
                for(int j = 0 ; j < len; j++)
                {
                        if(flag[j])
                        {      
                                if(original[j]==temp[i])
                                {
                                        next[i] = j;
                                        flag[j]=false;
                                        break;
                                }
                        }
                }
               
        }
   
        // decode procedure
        int key = a;
        for (int count = 0; count < len; count++) {
          key = next[key];
          BinaryStdOut.write(t.charAt(key));
        }
        BinaryStdOut.close();
    }
 
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
        String c = args[0];
        if(c.equals("-"))
                encode();
        else if(c.equals("+"))
                decode();
   
    }
}

*/



public class BW
{
       
        // apply Burrows-Wheeler encoding, reading from standard input
    // and writing to standard output
	
/*	
	public static String rotate(int length, String arrInput){
		String temp = "";
		temp = arrInput.substring(0,1);
		arrInput = arrInput.substring(1, length);
		arrInput += temp;
		return arrInput;
	}  
	public static void encode(){
	//StdOut.println("gi");
		String hi = BinaryStdIn.readString();
		int len = hi.length();
		StdOut.println(len);
		int lastindex = len-1;
		char[] outString = hi.toCharArray();
		String newString[] = new String[len];
		
		
	} 
 */
         public static void encode(){
 
 
				String input = BinaryStdIn.readString();
                String bwtOutput = "";
 
                int startIndex = 0;
 
 
 
                // TODO:
 
                /**
 
                 * PART 1 --> insert implementation of Burrows-Wheeler-Transformation
 
                 * here
 
                 **/
 
 
 
                String[] allRotations = new String[input.length()];
 
 
 
                // compute all rotations:
 
                for (int i = 0; i < input.length(); i++) {
 
                        allRotations[i] = input.substring(i) + input.substring(0, i);
 
                }
 
 
 
                // sort rotations alphabetically:
 
                Arrays.sort(allRotations);
 
 
 
                for (int i = 0; i < input.length(); i++) {
 
                        // L (last) =BWT
 
                        bwtOutput += allRotations[i].charAt(input.length() - 1);
 
                        // E (end of Input)
 
                        if (allRotations[i].equals(input)) {
 
                                startIndex = i;
 
                        }
 
                }
 
				BinaryStdOut.write(startIndex);
				BinaryStdOut.flush();
				BinaryStdOut.write(bwtOutput);
				BinaryStdOut.flush();

              //  return new BWT(bwtOutput, startIndex);
 
        }
 
 
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
        String c = args[0];
        if(c.equals("-"))
                encode();
     //   else if(c.equals("+"))
       //         decode();
   
    }
}