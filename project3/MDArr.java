import java.util.Arrays;
import java.util.Comparator;

public class MDArr {
  static int tflag = 1;
  public static void printArray(String[][] names, int k){
    Arrays.sort(names,new ColumnComparator(0));
             StdOut.print("[ ");
             for(int i = 0; i<=k; i++){              

               StdOut.print(names[i][0]+"|"+names[i][1]);
               if(i<k){
                 StdOut.print(", "); 
               }
             }
             
            StdOut.print(" ]");
            StdOut.println();
            tflag = 0;
  }
   public static void main(String[] args) {
     String input = StdIn.readAll();
     String [] store = input.split("\\s");
     int longest = longString(store);
     String [][] names = new String[store.length][2];
     int count = 1;
     for(count = 1; count <= longest; count++){         
       for(int i = 0; i<store.length; i++){
         String hi = store[i];
         int size = hi.length();
         int check =hi.length()-count; 
         if(check>=0){
           names[i][0] = hi.substring(0,check);
           names[i][1] = hi.substring(check,size);
         }
      }
       Arrays.sort(names,new ColumnComparator(1));
       int counter = 1;
       int k = 0;
       int tflag = 1;
       int tcount = 0;
       while(k<=store.length){
         if(counter<store.length){
           if(names[k][1].equals(names[counter][1])){
             counter++;
             k++;
             tcount++;
           }
         }
         else{
           for(int i = 0; i <=k;i++){
            String temp = names[i][0]+names[i][1];
           }
           printArray(names,k);
           break;
         }
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
class ColumnComparator implements Comparator {
 int columnToSort;
 ColumnComparator(int columnToSort) {
  this.columnToSort = columnToSort;
 }
 //overriding compare method
 public int compare(Object o1, Object o2) {
  String[] row1 = (String[]) o1;
  String[] row2 = (String[]) o2;
  //compare the columns to sort
  return row1[columnToSort].compareTo(row2[columnToSort]);
 }
}