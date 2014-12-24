//import java.util.*;
import java.lang.RuntimeException;
import java.util.EmptyStackException;
public class DoubleStack<T> {
   T[] arr;
   int red;
   int blue;
   int size;
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
       throw new RuntimeException();
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
           //System.out.println("entered second if");
           //red++;
           redCount--;
           //System.out.println("red is:"+red);
           StdOut.print(arr[red]+" ");
           arr[red] = null;
           red++;
       }
     if(c == Color.BLUE && isEmpty(Color.BLUE)){
       throw new EmptyStackException();
     }else if(c == Color.BLUE  && isEmpty(Color.BLUE)!= true){
           blueCount--;
           StdOut.print(arr[blue]+" ");
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
         StdOut.print(arr[red]+" ");
       }
     }else if(c == Color.BLUE){
       if(isEmpty(Color.BLUE) != true){
         StdOut.print(arr[blue]+ " ");
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
   public boolean isFull(){
     if((redCount+blueCount)>=size){
       return true;
     }else{
       return false;
     }
   }// Test if DoubleStack is full
      public static void main(String[] args) {
     String second = "";
     int redStack = 1;
     int blueStack = 0;
     String inBlue = "";
     String inRed = "";
  //   int rpop = 0;
  //   int bpop = 0;
  //   int rpeek = 0;
  //   int bpeek = 0;
    int input = StdIn.readInt();
    DoubleStack<String> stack = new DoubleStack<String>(input);
 // System.out.println(stack.size);
     while(StdIn.isEmpty()!=true){
       second = StdIn.readString();
    //   System.out.println(second);
       if(!(second.equals("--blue")) && !(second.equals("-")) && !(second.equals("?")) && blueStack == 0 || second.equals("--red")){
    //     System.out.println("inside");
         redStack = 1;
         blueStack = 0;
       }
       if(second.equals("--blue")){
     //    System.out.println("--b");
         redStack = 0;
         blueStack = 1;
       }
       if(redStack == 1){
      //   System.out.println("inside rstack");
         if(!(second.equals("--red")) && !(second.equals("-")) && !(second.equals("?"))){
           //insert push
           stack.push(second,Color.RED);
           inRed += second + " ";
         }
       }
       if(blueStack == 1){
         if(!(second.equals("--blue")) && !(second.equals("-")) && !(second.equals("?"))){
           //insert push
           stack.push(second,Color.BLUE);
           inBlue += second + " ";
         }
       }
       if(second.equals("-")){
         //pop
           if(redStack == 1){
             stack.pop(Color.RED);
           }
           if(blueStack == 1){
           stack.pop(Color.BLUE);
           //bpop++;
           }
       }
       if(second.equals("?")){
         if(redStack == 1){
           stack.peek(Color.RED);
           //rpeek++;
         }
         if(blueStack == 1){
           stack.peek(Color.BLUE);
           //bpeek++;
         }
       }
      // System.out.println("red" + redStack);
      // System.out.println("blue" + blueStack);
     }
     //System.out.println("redin" + inRed);
     //System.out.println("blue in" + inBlue);
     //System.out.println("redp" + rpop);
     //System.out.println("bluep" + bpop);
     //System.out.println("redpe" + rpeek);
     //System.out.println("blupe" + bpeek);
     StdOut.println();
     StdOut.print("(" + stack.size(Color.RED) + " left on RED stack, " + stack.size(Color.BLUE) + " left on BLUE stack)");
   }
}
