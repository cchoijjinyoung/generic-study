package exam04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericBoundedMain {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    printExtends(list);
    printSuper(list);
    // print(list); 컴파일 에러
  }

  // 나는 List<Number> 아니면 안받아! 느낌인 것 같다. 상위 하위 클래스 상관없이.
  public static void print(List<Number> list) {
    for (Object e : list) {
      System.out.println(e);
      System.out.println(e.getClass());
    }
  }

  public static void printExtends(List<? extends Number> list) {
    for (Object e : list) {
      System.out.println(e);
      System.out.println(e.getClass());
    }
  }

  public static void printSuper(List<? super Integer> list) {
    for (Object e : list) {
      System.out.println(e);
      System.out.println(e.getClass());
    }
  }
}
