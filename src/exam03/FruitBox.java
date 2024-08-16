package exam03;

public class FruitBox<T> {

  private T[] fruits;

  /**
   * static 멤버나 메서드에 제네릭 타입이 올 수 없다.
   * 왜냐하면 static 은 제네릭 객체가 생성되기도 전에 이미 자료 타입이 정해져 있어야하기 때문이다.
   */
  public /*static*/ void addBox(T fruit, int index) {
    fruits[index] = fruit;
  }

  public /*static*/ T getFruit(int index) {
    return fruits[index];
  }

  /**
   * 그러나, 제네릭 메서드는 가능하다.
   * 이 때 아래의 <T>는 FruitBox<T> 의 T와는 독립적으로 운용된다. (서로 다르다!)
   */
  public static <D> D genericMethodStatic(D d) {
    return null;
  }
}
