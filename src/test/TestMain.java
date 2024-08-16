package test;

import exam03.FruitBox;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

  public static void main(String[] args) {
    List<? extends Fruit> list1 = new ArrayList<>();
    List<? extends Fruit> apples = new ArrayList<Apple>();
    // Apple, Banana, Fruit 수용
    // list1.add(new Apple()); --- 컴파일 에러!
    // list1.add(new Fruit()); --- 마찬가지로 컴파일 에러!
//    apples.add(new Apple());

    // 와일드카드는 무슨 타입인지 신경쓰지 않는다.
    // List<? extends Fruit>이란 것은
    // List<Apple> 일수도, List<Banana> 일수도, List<Fruit> 있어서,
    // 해당 타입이 무엇일지 컴파일러는 알 수가 없다. 따라서 안정성을 위해 add를 허용하지 않는다.

    List<? super Fruit> list2 = new ArrayList<>();
    // Fruit, Thing, Object 수용 가능

    list2.add(new Apple());
    list2.add(new Banana());
    // list2.add(new Student()); --- 컴파일 에러!
    // Fruit 의 하위타입이 아니면 못들어간다.
      // Fruit 의 상위타입이 될 수 있는 가능성이 존재하기 때문.
      // 예를 들어, Fruit 도 Thing 이라는 클래스를 상속받는다면,
      // list2에 들어간 원소는 Thing 이 될 수 있어야한다.

    for (int i = 0; i < list2.size(); i++) {
      // list2가 Fruit 의 부모만 가능하기 때문에, get 했을 시, Object 타입으로 반환받는다.
      Object object = list2.get(1);
      System.out.println(object.getClass().getName());
      // 그런데 어떻게 Banana로 출력이 되는걸까?
        // 자바는 런타임에 객체의 실제 타입을 유지한다고 한다.
        // Object로 변환되었다고 해서 객체 자체의 타입 정보는 사라지지 않는다.
    }
  }
}

class Thing {}
class Fruit extends Thing {}

class Apple extends Fruit {}
class Banana extends Fruit {}
class Student {}
