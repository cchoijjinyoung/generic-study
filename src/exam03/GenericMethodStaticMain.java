package exam03;

public class GenericMethodStaticMain {

  public static void main(String[] args) {
    Integer result1 = FruitBox.<Integer>genericMethodStatic(1);

    // 또한 '제네릭 메서드의 타입을 생략하고 호출할 수 있다.
    // 컴파일러가 100을 보고 제네릭 타입을 추정할 수 있기 때문이다.
    Integer result2 = FruitBox.genericMethodStatic(100);
  }
}
