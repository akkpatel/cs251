public class rotate {

	public static void encode(){
	int count = 0 ;
	String lastRow = "";
	String temp = BinaryStdIn.readString();
	String[] tarray = new String[temp.length()];
	for(int i=0;i<temp.length();i++){
		tarray[i] = String.valueOf(temp.charAt(i));
	}
	/*MSD.sort(tarray);
	for(int i = 0; i < temp.length(); i++){
		StdOut.println(tarray[i]);
	}*/
	SuffixArray suffix = new SuffixArray(temp);
	int value [] = new int[temp.length()];
	for(int i = 0; i < temp.length(); i++){
		int index = suffix.index(i);
		value[i] = index;
		String hi = suffix.select(i);
		if(value[i] == 0){
			count = i;
		}
	}
	for(int i = 0; i < tarray.length; i++){
		int store = value[i]-1;
		if(store<0){
			store = tarray.length-1;
		}
		lastRow += tarray[store];
	}
	//	StdOut.println(count);
		BinaryStdOut.write(count);
		BinaryStdOut.flush();
		BinaryStdOut.write(lastRow);
		BinaryStdOut.flush();
	
	}
	
	
	
	
	public static void main(String[] args){
    //StdOut.println(args[1]);
	String arg = args[0];
	if(arg.equals("-")){
		encode();
	}
   }
  
  
}