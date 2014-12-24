import java.util.Iterator;
import java.util.EmptyStackException;
import java.util.StringTokenizer; 
public class MyQueue<T> implements Iterable<T> {
  int qSize=30;
  int front=0;
  int store=0;
  int end=0;
  int qCount=0;
  int popss = 0;
  String finalOut = "";
  String r = "";
  int peeks = 0;
  T[] queue;
  T temp;
  public MyQueue(){
    queue = (T[]) new Object[qSize];
    front = 0;
    end = 0;
    qCount = 0;
  };                 // construct an empty Queue
  public int size(){
    return qCount;
  };                // return number of items in Queue
  public boolean isEmpty (){
    if(qCount == 0){
      return true;
    }else{
      return false;
    }
  }// test if queue is empty
  public boolean isFull (){
    if(qCount == qSize){
      return true;
    }else{
      return false;
    }
  }// test if queue is full
  public void enqueue (T item){
    if(isFull() == true){
      resize();
    }
    queue[front++] = item;
    qCount++;
  }// Add item to the queue
  public T dequeue (){
    if(isEmpty() == true){
      throw new EmptyStackException();
    }else{
      temp = queue[front-qCount];
      store = front-qCount;
      qCount--;
      finalOut += temp + " ";
      return temp;
    }
  }// Remove element from the queue
  public T peek (){
    if(isEmpty()== true){
      return null;
    }else{
 //     StdOut.print(queue[front-qCount] + " ");
      finalOut += queue[front-qCount] + " ";
      store = front-qCount;
      return queue[front-qCount];
    }
  };                 // Return element at front of the queue w/o removing it
  public T lookup (int i){
    if((store+i) > qSize && ((store-1)+i) > qSize){
      throw new RuntimeException("Ith element is not in queue");
    }
      if(popss == 1){
        finalOut += (queue[(store)+i] + " ");
      }else{
        finalOut += (queue[(store-1)+i] + " ");
      }
    return queue[i];
    }// Look up i-th element in queue if available, 
                                     // throw exception otherwise
   public void resize(){
     int newSize = 2*qSize;
     T[] secondQueue = (T[]) new Object[newSize];
     int i = 0;
     for(i = 0; i < qCount; i++){
       secondQueue[i] = queue[(front+i) % queue.length];
     }
     queue = secondQueue;
     front = 0;
     end = qCount;
   }
   public Iterator<T> iterator(){
     return new newIterator();
   }
   private class newIterator implements Iterator<T>{
     int j = 0;
     public boolean hasNext(){
       if(j < qSize){
         return true;
       }else{
         return false;
       }
     }
     public void remove(){
       throw new UnsupportedOperationException();
     }
     public T next(){
       if(hasNext() == false){
         return null;
       }else{
           T temp = queue[j %queue.length];
           j++;
           return temp;
         }
     }
   }
   public static void main(String[] args) {
     String store = "";
     String tempStore = "";
     while(StdIn.isEmpty() != true){
       String second = StdIn.readLine();
       StringTokenizer st = new StringTokenizer(second, " ");
        MyQueue<String> q = new MyQueue<String>();
        while(st.hasMoreTokens()){
         store = st.nextToken();
          if(!(store.equals("*")) && !(store.equals("-")) && !(store.equals("?"))){
            q.enqueue(store);
          }
          if(store.equals("*")){
            q.peeks = 1;
            q.popss = 0;
            q.peek();
          }
          if(store.equals("-")){
            q.peeks = 0;
            q.popss = 1;
            q.dequeue();
          }
          if(store.equals("?")){
            tempStore = st.nextToken();
            int t = Integer.parseInt(tempStore);
            q.lookup(t);
          }
        }
           StdOut.println(q.finalOut);
           StdOut.println(q.qCount);
     }
   }
}