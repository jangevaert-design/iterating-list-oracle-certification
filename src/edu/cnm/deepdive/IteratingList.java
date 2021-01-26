package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratingList {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(2);
    numbers.add(4);
    numbers.add(6);

    for (int i = 0; i < numbers.size(); i++) {
      System.out.println("element at index " + i + " is " + numbers.get(i));
      //numbers.remove(2); this will give an IndexOutOfBoundsException. We remove the element on
      //index 2 which, for the next iteration, only leaves us with index 0 and 1.
    }

    for (Integer number : numbers) {
      System.out.println("number" + number);
      //numbers.remove(2); throws a ConcurrentModificationException.
    }

    //better to use the class Iterator or ListIterator.

    for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {/*hasNext() returns
    a boolean*/
      //Iterator has three methods: boolean hasNext(); Object next() and void remove().
      Integer number = iterator.next();//next() returns the next item.
      System.out.println(number);
      iterator.remove();//removes the current item.
    }
    System.out.println(numbers);//prints 2 - 4 - 6 - []. prints 2 and then removes it.

    numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

    for (ListIterator<Integer> listIterator = numbers.listIterator(3);/* iterate from index 3*/
        listIterator.hasPrevious();/* to iterate backwards*/) {
      System.out.println(listIterator.previous());//ListIterator has more options than Iterator.
      listIterator.remove();
    }
      System.out.println(numbers);

  }
}
