package test3;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Number> list = new ArrayList<>();
    Object object = new Object();
    Integer integer = 1;
    list.add(integer); // 컴파일에러!
  }
}
