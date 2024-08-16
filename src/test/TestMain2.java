package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain2 {

  public static void main(String[] args) {
    List<Integer> iList = new ArrayList<>(Arrays.asList(1, 2, 3));
    List<String> sList = new ArrayList<>(Arrays.asList("a", "b", "c"));

    printW(iList);
    printW(sList);
    System.out.println("------");
    printT(iList);
    printT(sList);
  }

  public static void printW(List<?> list) {
    for (Object e : list) {
      System.out.print(e + " : " + e.getClass().getName() + ", ");
    }
    System.out.println();
  }

  public static <T> void printT(List<T> list) {
    for (T t : list) {
      System.out.print(t + " : " + t.getClass().getName() + ", ");
    }
    System.out.println();
  }

}
