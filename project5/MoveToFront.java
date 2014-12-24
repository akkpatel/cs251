import java.util.*;
import java.util.Arrays;

public class MoveToFront {
    // apply move-to-front encoding, reading from standard input 
    // and writing to standard output
    public static void encode(){
		char c = ' ';
		int next;
		String s = "";
		String storeValue = "";
		int count = 0;
		for (int i=0; i<=255; i++) {
			s += ((char)i);
		}		
		while(BinaryStdIn.isEmpty() != true){
			char[] orignal = s.toCharArray();
			c = BinaryStdIn.readChar();
			for(int i = 0; i < orignal.length; i++){
				if(orignal[i]==(c)){
					count = i;
				}
			}
			if(count != 0){
				String temp = s.substring(count, count+1);
				s = temp.concat(s.substring(0,count)).concat(s.substring(count+1));
			}
			storeValue += (char)count;
		}
		BinaryStdOut.write(storeValue);
		BinaryStdOut.flush();
	}

    // apply move-to-front decoding, reading from standard input 
    // and writing to standard output
    public static void decode(){
		char c = ' ';
		char asd = ' ';
		int next;
		char s[] = new char[256];
		String storeValue = "";
		int count = 0;
		int ch =0;
		for (int i=0; i<256; i++) {
			s[i] = ((char)i);
		}		
		while(BinaryStdIn.isEmpty() != true){
//			char[] orignal = s.toCharArray();
			c = BinaryStdIn.readChar();
			ch = (int)c;
			asd = s[ch];
			storeValue += asd;
			char temp = s[ch];			
			for(int i = ch; i > 0; i--){
				s[i] = s[i-1];
			}
			s[0] = temp;
		}
		//StdOut.println(storeValue);
		BinaryStdOut.write(storeValue);
		BinaryStdOut.flush();
	}

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args){
		String arg = args[0];
		if(arg.equals("-")){
			encode();
		}
		if(arg.equals("+")){
			decode();
		}
	
	}
}