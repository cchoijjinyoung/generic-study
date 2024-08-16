package test4;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

  List<? super Number> list = new ArrayList<>();

  public void push(Number number) {
    list.add(number);
  }

  public Number pop(int index) {
    return (Number) list.get(index);
  }
}
