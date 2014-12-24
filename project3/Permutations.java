import java.util.*;

public class Permutations {
static int count =0;
static String temp="";
    public static void main(String args[]) {
    String input = StdIn.readAll();
    int i = 0;
    int j = 0;
    int counts = 1;
    int length=0;
    String [] store = input.split("\\s");
    String temps;
    String reverse;
    String tem;
    String reReverse;
    String another;
    String s = "";
    for(i = 0; i < store.length; i++){
      temps = store[i];
      reverse = new StringBuffer(temps).reverse().toString();
      store[i] = reverse;
    }
    Arrays.sort(store);
    int lStr = longString(store);
    for(j = 0; j < store.length; j++){
      tem = store[j];
      reReverse = new StringBuffer(tem).reverse().toString();
      store[j] = reReverse;
    }
    for(j = 1; j < lStr; j++){
     brute("abcdefghijklmnopqrstuvwxyz", j, s, store);
    }
}
        public static void print(String a, int count) { 
          String [] store = a.split("\\s");
          Arrays.sort(store);
          for(int i = 0; i < store.length; i++){
            String temp = store[i];
            int length = temp.length()-count; 
            String st = new StringBuffer(temp).insert(length, "|").toString();
            store[i] = st;
          }
          StdOut.print("[ ");
          for(int j=0;j<store.length;j++){
            StdOut.print(store[j]);
            if(j<store.length-1){
              StdOut.print(", ");
            }
            
          }
          StdOut.println(" ]");
        }
    static void compare(String s, String[] store){
      int length = 0;
      int flag = 0;
      int tlen = 0;
      String s2;
      String [] temp = s.split("\\s");
      for(int j = 0; j< temp.length; j++){
        length = temp[j].length();
        s2 = temp[j];
        String storage = "";
        flag = 0;
        tlen = 0;
        for(int i = 0; i<store.length; i++){
          String another = store[i];
          int len = another.length()-length;
          if(len>=0){
            String s1 = another.substring(len);
            if(s1.equals(s2)){
              storage += another + " ";
              flag = 1;
              tlen++;
            }
            if(i==(store.length-1) && flag == 1 && tlen > 1){
              print(storage, length);
            }
          }
        }
      }
    }
    static void brute(String input, int depth, String output, String[] a) {
      if (depth == 0) {
        count++;
        temp += output + " ";
        if(count%26== 0){
           compare(temp, a);
           temp="";
        }
      } else {
            for (int i = 0; i < input.length(); i++) {
                output += input.charAt(i);
                brute(input, depth - 1, output, a);
          //      count++;
                output = output.substring(0,output.length()-1);

            }

        }
    }
    public static int longString(String[] a){
      int max = 0;
      for(int i = 0; i <a.length; i++){
        if(a[i].length() > max){
          max = a[i].length();
        }
      }
      return max;
    }
}