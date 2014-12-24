public class Quick3wayBM1{
  public static int i,j,p,q,copyP,copyQ;
  public static int buffer = 0;
  public static void sort(Comparable[] a){
    sort(a, 0, a.length-1);
  }
  private static void sort(Comparable[] a, int lo, int hi){
    if(((hi-lo)+1) <= 8){
      for(int z=lo; z<=hi;z++){
        for(int x=z;x>lo;x--){
          if(a[x].compareTo(a[x-1]) < 0){
            exch(a,x,x-1);
          }else{break;}
        }
      }
      //StdOut.println("(Insertion_Sort, "+lo+", "+hi+")");
      return;
    }else if(hi <= ((lo+40)-1)){
      int mid = medianOf3(a, lo, ((lo+hi+1)/2), hi);
      exch(a, lo, mid);
      StdOut.println("(median_Of_3, "+lo+", "+", "+p+", "+i+", "+j+", "+q+", "+hi+")");

    }else{
      int length = (hi-lo+1);
      int mid1 = medianOf3(a, lo, lo+length/8, lo+length/4);
      int mid2 = medianOf3(a, lo+length/2-length/8, lo+length/2, lo+length/2+length/8);
      int mid3 = medianOf3(a, hi-length/4, hi-length/8, hi);
      int n = medianOf3(a, mid1, mid2, mid3);
      exch(a, n, lo);
      StdOut.println("(Tukey_Ninther, "+lo+", "+", "+p+", "+i+", "+j+", "+q+", "+hi+")");
    }
    Comparable v = a[lo];
    i = lo+1;
    j = hi;
    p = lo;
    q = hi+1;
    while(i<=j){
      while(a[i].compareTo(v) < 0){
        i++;
      }
      while(a[j].compareTo(v) > 0){
        j--;
      }
      if(i<j){
        exch(a,i,j);
      }
      if(a[i].compareTo(v) == 0){
        exch(a,i,++p);
      }
      if(a[j].compareTo(v) == 0){
        exch(a,j,--q);
      }
    }
    StdOut.println("jj::"+j);
    copyP = p;
    copyQ = q;
    while(copyP >= 0){
      exch(a,copyP--,j--);
      StdOut.println("j:"+j);
    }
    while(copyQ <= hi){
      exch(a,copyQ++,i++);
    }
   //StdOut.println("First:::"+"i:"+i+"j:"+j+"lo:"+lo+"hi:"+hi+"v:"+v+"p:"+p+"q:"+q);
    sort(a,lo,j);
    //StdOut.println("Second:::"+"i:"+i+"j:"+j+"lo:"+lo+"hi:"+hi+"v:"+v+"p:"+p+"q:"+q);
    sort(a,i,hi);
  }
  public static void exch(Comparable[] a, int x, int y){
    Comparable temp;
    temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }
  public static int medianOf3(Comparable[] a, int x, int y, int z){
    if(a[x].compareTo(a[y]) > 0){
      exch(a, x, y);
    }
    if(a[x].compareTo(a[z]) > 0){
      exch(a, x, z);
    }
    if(a[y].compareTo(a[z]) > 0){
      exch(a, y, z);
    }
    return y;
  }
  public static void main(String[] args){
    int index = 0;
    int len = StdIn.readInt();
    Comparable[] array = new Comparable[len];
    while(!StdIn.isEmpty()){
    int in = StdIn.readInt();
    array[index++] = in;
    }
    sort(array);
  }
}