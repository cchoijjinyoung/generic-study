package test2;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

  public static void main(String[] args) {
    List<Apple> list = new ArrayList<>();
    list.add(new Apple());
    list.add(new Apple());
    list.add(new Apple());
    print(list);
    printT(list);
  }

  public static void add(List<? super Fruit> list) {
    // 다양한 과일들을 추가할 수 있다는 장점 존재
    list.add(new Apple());
    list.add(new Banana());
  }

  public static void print(List<? extends Fruit> list) {
    for (Fruit fruit : list) {
      System.out.println(fruit.getClass());
    }
  }

  public static <T> void printT(List<T> list) {
    for (T t : list) {
      System.out.println(t.getClass());
    }
  }
}

class Fruit {}

class Apple extends Fruit {}
class Banana extends Fruit {}
