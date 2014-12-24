import java.util.*;

public class HelloWorld { 
   public static void main(String[] args) {
 /*    while(StdIn.isEmpty()!=true){
       int input = StdIn.readInt();
	System.out.println(input);
       int[] storage = new int[input];
       char[] digit = new char[input];
       int i;
       String hello = "HelloWorld";
       for(i = 0; i<input; i++){
         int second = StdIn.readByte();
         storage[i] = second;
         digit[i] = (char)storage[i];
         hello = hello + digit[i];
       }
       int total = StdIn.readByte();
       for(int j = 0; j<total;j++){
         StdOut.print(hello + " ");
       }
	  StdOut.print("\n");
     }*/
	 int[] next = { 3, 0, 6, 7, 8, 9, 10, 11, 5, 2, 1, 4 };
int N = next.length;
String t = "ARD!RCAAAABB";
int i = 3;
for (int count = 0; count < N; count++) {
  i = next[i];
  System.out.write(t.charAt(i));
  System.out.println(t.charAt(i));
}
   }
}
