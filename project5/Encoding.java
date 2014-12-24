import java.util.*;
import java.util.Arrays;

public class Encoding {
	
	public static String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}


   public static void encode(){
     while(BinaryStdIn.isEmpty()!=true){
		String input = BinaryStdIn.readString();
		String cinput = input;
		String tinput = "";
		int len = input.length();
		String temp[] = new String[len];
		for(int i = 0; i < len; i++){
			if(i == 0){
				tinput = input.substring(0,5).concat(input.substring(len-1));
			}else{
				input = input.substring(1,len).concat(input.substring(0,1));
				tinput = input.substring(0,5).concat(input.substring(len-1));//.concat(Integer.toString(i));
				}
				temp[i] = (tinput);
		//		StdOut.println(temp[i]);
				tinput = "";
		}

		Heap.sort(temp);
		String store = "";
		for(int i = 0; i < len; i++){
			store += temp[i].substring(temp[i].length()-1);
		}
			int tempest = 0;
			tempest = 45885;
			BinaryStdOut.write(tempest);
			BinaryStdOut.write(store);
		BinaryStdOut.close();
		
	 }
   }
   public static void main(String[] args){
    //StdOut.println(args[1]);
      String arg = args[0];
      if(arg.equals("-")){
        encode();
      }
   }
}
  