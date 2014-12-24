import java.lang.RuntimeException;
import java.util.EmptyStackException;
import java.util.StringTokenizer; 
public class EvalPrefix{
  public enum Color { RED, BLUE }
        public static void main(String[] args) {
     String second = "";
     int rpop = 0;
     int i=0;
/*     String a = "10";
     String d = "20";
     String op = "/";
  DoubleStack<String> stack = new DoubleStack<String>(stacksize);
 int total = stack.result(a, d, op);
 StdOut.println(total);*/
     while(StdIn.isEmpty() != true){
      //( ( A * B ) + ( C / D ) )
       second = StdIn.readLine();
       StringTokenizer st = new StringTokenizer(second, " ");
       int length = st.countTokens();
       DoubleStack<String> stack = new DoubleStack<String>(length);
       String[] hi = new String[length];
       for(i = 0; i < length; i++){
         hi[i] = st.nextToken();
       }
       for(i = (length-1); i>=0; i--){
         if(stack.isOperator(hi[i])!=true){
           stack.push(hi[i], DoubleStack.Color.RED);
         }else{
           stack.pop(DoubleStack.Color.RED);
           String tstore = stack.pops;
           stack.pop(DoubleStack.Color.RED);
           String tstore2 = stack.pops;
           int total = stack.result(tstore, tstore2, hi[i]);
           String temps = "" + total;
           stack.push(temps, DoubleStack.Color.RED);
         }
       }
        stack.pop(DoubleStack.Color.RED);
	  if(rpop >= 2){
	    StdOut.println();
	  }
	  StdOut.print(stack.pops);
	  rpop++;
	  if(rpop == 1){
	    StdOut.println();
	   }
     }
   }
}
class DoubleStack<T> {
   T[] arr;
   int red;
   int blue;
   int temp;
   int size;
   T pops;
   int redCount=0;
   int blueCount=0;
   public enum Color { RED, BLUE }
   public DoubleStack(int N){
     arr = (T[]) new Object[N];
     red = N;
     blue = 0;
     size = N;
   }// Construct empty DoubleStack of capacity N
   public int size(Color c){
     if(c == Color.RED){
       return redCount;
     }else{
       return blueCount;
     }
   }// Return the number of items in a stack
   public void push(T item, Color c){
     if(c == Color.RED && isFull() == true || c == Color.BLUE && isFull() == true){
     //  throw new FullStackException() ;
     }
       if(c == Color.RED){
         if(isFull() != true){
           arr[--red] = item;
           redCount++;
         }
       }
       else if(c == Color.BLUE){
         if(isFull()!=true){
           arr[++blue] = item;
           blueCount++;
         }
       }
     }// Add item to a stack.
   
   public T pop(Color c){
     if(c == Color.RED && isEmpty(Color.RED)){
       throw new EmptyStackException() ;
     }else if(c == Color.RED && isEmpty(Color.RED) != true){
   //      System.out.println("entered red");
           //System.out.println("entered second if");
           //red++;
           redCount--;
           //pops = red;
    //       System.out.println("red is:"+red);
           pops = arr[red];
     //      StdOut.println(pops);
     //      StdOut.println(arr[red]+" ");
           arr[red] = null;
           red++;
       }
     if(c == Color.BLUE && isEmpty(Color.BLUE)){
       throw new EmptyStackException();
     }else if(c == Color.BLUE  && isEmpty(Color.BLUE)!= true){
           blueCount--;
           StdOut.println(arr[blue]+" ");
           arr[blue] = null;
           blue--;
       }
      return null;
   }// Pop most recent item from a stack
   
   public T peek(Color c){
    if(c == Color.RED && isEmpty(Color.RED) || c == Color.BLUE && isEmpty(Color.BLUE)){
       throw new EmptyStackException() ;
     } 
     if(c == Color.RED){ 
       if(isEmpty(Color.RED) != true){
         //StdOut.println("peeked");
         StdOut.println(arr[red]);
       }
     }else if(c == Color.BLUE){
       if(isEmpty(Color.BLUE) != true){
         StdOut.println(arr[blue]);
       }
     }
     return null;
   }// Look at object on top of stack w/o removing it
   public boolean isEmpty(Color c){
  /*   if((redCount+blueCount)<(size-1)){
       return true;
     }else{
       return false;
     }*/
       if(c == Color.RED){
         if(redCount == 0){
           return true;
         }
         else{
            return false;
         }
       }
       if(c == Color.BLUE){
         if(blueCount == 0){
           return true;
         }
         else{
           return false;
         }
       }else{
         return false;
       }
   }// Test if a stack is empty
// Test if a stack is empty
   public T top(Color c){
     if(c == Color.RED){
       return arr[red];
     }else{
       return null;
     }
   }
   public boolean isFull(){
     if((redCount+blueCount)>=size){
       return true;
     }else{
       return false;
     }
   }// Test if DoubleStack is full
   public boolean isOperator(String temp){
     if((temp.equals("*") || temp.equals("/") || temp.equals("%")) || temp.equals("+") || temp.equals("-")){
       return true;
     }else{
      return false; 
     }
   }
   public int result(String a, String b, String temp){
     int first = Integer.parseInt(a);
     int second = Integer.parseInt(b);
  //   StdOut.println("first" + first + "second" + second);
     if((temp.equals("+"))){
       return first + second;
     }else if(temp.equals("-")){
       return first - second;
     }else if(temp.equals("*")){
       return first * second;
     }else if(temp.equals("/")){
       return first/second;
     }
     return 0;
   }
}