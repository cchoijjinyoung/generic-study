package exam01;

/**
 * 제네릭이 없었을 때: 여러 타입을 다루기 위해 파라미터나 리턴값으로 Object 를 사용함.
 */
class Apple {}

class Banana {}

class FruitBox {

  // 모든 클래스 타입을 받기 위해 최고 조상인 Object 타입으로 설정
  private final Object[] fruit;

  public FruitBox(Object[] fruit) {
    this.fruit = fruit;
  }

  public Object getFruit(int index) {
    return fruit[index];
  }
}

public class FruitBoxMain1 {

  public static void main(String[] args) {
    Apple[] apples = {new Apple(), new Apple()};

    FruitBox box = new FruitBox(apples);

    Apple apple = (Apple) box.getFruit(0);
    Banana banana = (Banana) box.getFruit(1); // 컴파일 에러가 안남.

    // 실행을 해야 비로소 ClassCastException 이 발생함.
  }
}




