import java.util.*;
import java.util.Arrays;


public class BurrowsWheeler {
	public static int count = 0;
    // apply Burrows-Wheeler encoding, reading from standard input 
    // and writing to standard output
  public static void rotate(int length, String[] arrInput, String[] tempStore){
	for( int i = 0; i < length; i++){
		tempStore[i] = arrInput[0].substring(i, length).concat(arrInput[0].substring(0,i));
	//	StdOut.println(i);
	}
  }  

  public static void encode(){
//	System.out.println("hi");
	String temps = "";
	while(BinaryStdIn.isEmpty() != true){
		String input = BinaryStdIn.readString();
		int length = input.length();
		String arrInput[] = new String[length];
		String tempStore[] = new String[length];
		arrInput[0] = input;
	//	StdOut.println("before rotate");
		rotate(length, arrInput, tempStore);
		/*for(int i = 0; i< length; i++){
			StdOut.println(arrInput[i]);
		}*/
		LSD.sort(tempStore, length);
		//for(int i = 0; i < length; i++){
	//		StdOut.println(tempStore[i]);
	//	}
		int count = Arrays.binarySearch(tempStore, input);
//		StdOut.println("count   " + count);
	//	StdOut.println("after count & before temps");
		for(int z = 0; z < length; z++){
			temps += tempStore[z].substring(length-1, length);
		}
	//	StdOut.println(temps);
//		StdOut.println("after temp and before write and flush");
		BinaryStdOut.write(count);
		BinaryStdOut.write(temps);
		BinaryStdOut.close();
		

	
	}
  }

    // apply Burrows-Wheeler decoding, reading from standard input 
    // and writing to standard output
  public static void decode(){
  //StdOut.println("hi");
		int flag = 0;
		int nextValue = BinaryStdIn.readInt();
//		StdOut.println(nextValue);
		String some = BinaryStdIn.readString();
		int length = some.length();
		int next[] = new int[length];
		String orgString[] = new String[length];
		String sortString[] = new String[length];
		for(int i = 0; i < length; i++){
			String temp = Integer.toString(i);
			orgString[i] = some.substring(i, i+1).concat(temp);
			next[i] = -1;
		}
		LSD.sort(orgString,1);
		for(int i = 0; i < length; i++){
			next[i] = Integer.parseInt(orgString[i].substring(1,orgString[i].length()));			
		}
		int value = nextValue;	
		for(int count = 0; count < length; count++){
			value = next[value];
			BinaryStdOut.write(some.charAt(value));
		}
	//	BinaryStdOut.flush();
		BinaryStdOut.close();
	
  }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
   public static void main(String[] args){
    //StdOut.println(args[1]);
	String arg = args[0];
	if(arg.equals("-")){
		encode();
	}
	if(arg.equals("+")){
		decode();
	}
   }
  
  
}
