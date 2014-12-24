//import java.util.*;
import java.lang.RuntimeException;
import java.util.EmptyStackException;
import java.util.StringTokenizer; 
public class Infix2PreFix{
      public enum Color { RED, BLUE }
      public static void main(String[] args) {
     String second = "";
     String reverse="";
     String output = "";
     String b = ")";
     int rpop = 0;
     int stacksize = 0;
     while(StdIn.isEmpty() != true){
      //( ( A * B ) + ( C / D ) )
       second = StdIn.readLine();
       reverse = new StringBuffer(second).reverse().toString();
       StringTokenizer st = new StringTokenizer(reverse, " ");
       stacksize = st.countTokens();
       DoubleStack<String> stack = new DoubleStack<String>(stacksize);
       while(st.hasMoreTokens()){
         reverse = st.nextToken();
        // StdOut.println("rev" + " " + reverse);
         if((stack.isOperator(reverse)==false) && (stack.leftPar(reverse)==false) && (stack.rightPar(reverse)==false)){
           output += " " + reverse;
          // StdOut.println("first outPut" + output);
         //  System.out.println("its an operand");
         }
         if(stack.rightPar(reverse)==true){
         //  System.out.println("its in operator");
           stack.push(reverse, DoubleStack.Color.RED);
        //   System.out.println(stack.redCount);
         }
         if(stack.isOperator(reverse)==true){
           if(stack.isEmpty(DoubleStack.Color.RED) == true){
             stack.push(reverse, DoubleStack.Color.RED);
         //    StdOut.println("in isempty");
           }
           if(!(stack.isEmpty(DoubleStack.Color.RED) == true)){
          //   StdOut.println("inside else");
             if(stack.top(DoubleStack.Color.RED).equals(b) || stack.checkPrior(reverse)){//(stack.priority(reverse) >= stack.priority(stack.top(DoubleStack.Color.RED)))){
               stack.push(reverse, DoubleStack.Color.RED);
          //     System.out.println("yes it has higher precedence");
             }else{
            //   StdOut.print("inside else, ready to pop");
               while(!(stack.checkPrior(reverse)== true) && stack.redCount!=1){
                 if((stack.top(DoubleStack.Color.RED).equals(b))){
                   break;
                 }
             //    StdOut.print("inside While");
                 stack.pop(DoubleStack.Color.RED);
                 output += " " + stack.pops;
             //    StdOut.print("RC" + stack.redCount);
             //    StdOut.println("second outPut" + output);
               }
               stack.push(reverse, DoubleStack.Color.RED);
             }
           }
         }if(stack.leftPar(reverse)==true){
          // StdOut.println("inside if");
           while(!(stack.top(DoubleStack.Color.RED).equals(b))){
            // StdOut.println("inside while if");
             stack.pop(DoubleStack.Color.RED);
             output += " " + stack.pops;
           //  StdOut.println("Third outPut" + output);
           }
           if(stack.top(DoubleStack.Color.RED).equals(b)){
             stack.pop(DoubleStack.Color.RED);
           //  StdOut.println("its Popped");
           }
         }
         }

         while(stack.isEmpty(DoubleStack.Color.RED)!= true){
             stack.pop(DoubleStack.Color.RED);
             output += " " + stack.pops;
            // StdOut.println("fourth outPut" + output);
             if(stack.redCount == 1){
              break; 
             }
         }
  String finalOutput = new StringBuffer(output).reverse().toString();
  output = "";
  if(rpop >= 2){
    StdOut.println();
  }
  StdOut.print(finalOutput.trim());
  rpop++;
  if(rpop == 1){
    StdOut.println();
   }
    }
       //   output = null;
     //StdOut.print(finalOutput);
	//   StdOut.println();
          
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
     if(c == DoubleStack.Color.RED){
       return redCount;
     }else{
       return blueCount;
     }
   }// Return the number of items in a stack
   public void push(T item, Color c){
     if(c == DoubleStack.Color.RED && isFull() == true || c == Color.BLUE && isFull() == true){
     //  throw new FullStackException() ;
     }
       if(c == DoubleStack.Color.RED){
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
     if(c == DoubleStack.Color.RED && isEmpty(DoubleStack.Color.RED)){
       throw new EmptyStackException() ;
     }else if(c == DoubleStack.Color.RED && isEmpty(DoubleStack.Color.RED) != true){
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
    if(c == DoubleStack.Color.RED && isEmpty(DoubleStack.Color.RED) || c == Color.BLUE && isEmpty(Color.BLUE)){
       throw new EmptyStackException() ;
     } 
     if(c == DoubleStack.Color.RED){ 
       if(isEmpty(DoubleStack.Color.RED) != true){
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
       if(c == DoubleStack.Color.RED){
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
     if(c == DoubleStack.Color.RED){
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
   public boolean checkPrior(String temp){
       T ttemp = top(DoubleStack.Color.RED);
       String ch = (String) ttemp;
       if(priority(temp) >= priority(ch)){
         return true;
       }else{
       return false;
     }
   }
   public int priority(String symbol){ 
     if(symbol.equals("*") || symbol.equals("/")){
       return 4;
     }
     if(symbol.equals("+") || symbol.equals("-")){
       return 2;
     }
     return 0;
   }
   public boolean isOperator(String temp){
     if((temp.equals("*") || temp.equals("/") || temp.equals("%")) || temp.equals("+") || temp.equals("-")){
       return true;
     }else{
      return false; 
     }
   }
   public boolean leftPar(String temp){
     if(temp.equals("(")){
       return true;
     }else{
       return false;
     }
   }
   public boolean rightPar(String temp){
     if(temp.equals(")")){
       return true;
     }else{
       return false;
     }
   }
}