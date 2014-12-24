 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alpha {
  public static void main(String[] args) {
    List numbers = new ArrayList();

//    for (int i = 0; i < 25; i++) {
      numbers.add("hi bye");
 //   }

    System.out.println(Arrays.toString(numbers.toArray()));

    Collections.rotate(numbers, 3);

    System.out.println(Arrays.toString(numbers.toArray()));
  }
}
 