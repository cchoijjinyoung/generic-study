package exam02;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭 사용
 */
class Apple extends Fruit {}

class Banana extends Fruit {}

class Fruit {
  public void cut() {
    // 과일을 반으로 자름
  }

}

class FruitBox<T extends Fruit> {

  private final List<T> fruitList = new ArrayList<>();

  private final T[] fruit;

  public FruitBox(T[] fruit) {
    this.fruit = fruit;
  }

  public T getFruit(int index) {
    return fruit[index];
  }
}

public class FruitBoxMain2 {

  public static void main(String[] args) {
    Apple[] apples = {new Apple(), new Apple()};

    FruitBox<Apple> box = new FruitBox<>(apples);

    Apple apple = box.getFruit(0);
    // 타입을 미리 지정 & 제한해놓기 때문에 형변환의 번거로움을 줄일 수 있음.

    // Banana banana = (Banana) box.getFruit(1);
    // 컴파일 타임에 미리 잘못된 것을 잡아 알려줄 수 있다.
  }
}
