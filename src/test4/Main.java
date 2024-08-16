package test4;

public class Main {

  public static void main(String[] args) {
    TestClass testClass = new TestClass();

    testClass.push(1);
    testClass.push(1L);
    testClass.push(1.0d);
    testClass.push(1.0f);

    for (int i = 0; i < testClass.list.size(); i++) {
      System.out.println(testClass.pop(i) + " : " + testClass.pop(i).getClass().getName());
    }
  }
}