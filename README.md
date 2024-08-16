# generic-study
: **클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법**

- `?` vs `T`의 차이
    - 와일드 카드는 특정 타입을 알 필요없고, 어떤 제네릭 타입이든 유연하게 받아들이고자 사용
    - 타입 매개변수는 타입 안정성을 유지하면서 제네릭 클래스나 제네릭 메서드를 설계할 때 사용
- `?`는 어디서 쓰는 것인가
    - `<T>` 는 제네릭 인터페이스, 제네릭 클래스, 제네릭 메서드에만 사용 가능
    - 와일드카드는 `class Fruit<T>` 처럼 제네릭 타입 매개변수를 선언할 때는 사용할 수 없다.
        - `class Fruit<?>` (❌)
        - 타입 매개변수 선언 시에는 반드시 구체적인 타입 변수를 사용해야한다.(`T`, `E` 등)
        - 와일드카드는 꺽쇠 안에서만 사용할 수 있다.
- `<? super T>`는 어디서 쓸 수 있는건가?
    - 아래에서 다뤄보자

- 제네릭 기호를 `<T>` 로 표현했지만, 사실 문법적으로는 정해진 것이 없다.
- `for`문을 사용할 때 변수를 `i` 로 지정해서 사용하듯이, 제네릭의 표현 변수를 `T`로 표현한다고 보면 된다.
- 그래도 대중적으로 통하는 통상적인 네이밍이 있기 때문에 컨벤션이 존재한다.
    - `<T>` : 타입
    - `<E>` : 요소(Element), 예를 들어 List의 요소
    - `<K>` : 키(Key), `Map<K, V>`
    - `<V>` : 리턴 값 또는 매핑된 값
    - `<N>` : 숫자
    - `<S, U, V>` : 2번째, 3번째, 4번째에 선언된 타입
- ![[스크린샷 2024-08-16 16.09.59.png]]

### 제네릭 메서드
**: 메서드의 선언부에 `<T>`가 선언된 메서드**

- 제네릭 클래스에 정의된 타입 매개변수와 제네릭 메서드에 정의된 타입 매개변수는 별개이다.
- 제네릭 메서드의 제네릭 타입 선언 위치는 메서드 반환 타입 바로 앞이다.
- ![[스크린샷 2024-08-16 16.27.01.png]]
-  `List` 클래스의 `toArray(T[] a)`\

```java
public class FruitBox<T> {
	public static T addBox(T fruit) {
		// T를 알 수 없기 때문에 컴파일 에러가 남.
	}
	
	/**  
	 * 그러나, 제네릭 메서드는 가능하다.  
	 * 이 때 아래의 <T>는 FruitBox<T> 의 T와는 독립적으로 운용된다. (서로 다르다!)  
	 */
	public static <T> T genericMethodStatic(T t) {  
		return t;  
	}
}
```


### 'super, extends 서로 반대 아닌가?' 알아보기
1. `<? extends T>`
```java
List<? extends Fruit> list = new ArrayList<>();
// 이 리스트는 분명히 Fruit 또는 Fruit의 하위클래스를 수용하는 리스트다.
// 하지만, 컴파일러는 이 리스트가 정확히 어떤 타입의 리스트인지는 알 수 없다.
// Apple인지.. Banana인지.. Fruit인지..
// 따라서 add 연산은 막아버린다.

// 반면에, 이 리스트는 최소 Fruit 타입의 객체를 포함하고 있음으로,
// get 연산 같은 경우는 리턴 값을 Fruit으로 안전하게 처리할 수 있다.
Fruit fruit = list.get(0);
```
<u>list에 add를 못하는데 get할 때 안정성 있어봤자 무슨 이점이 있지? 가져올 것도 없지 않나?</u>



- 다음과 같은 상황에 사용할 수 있을 것 같다.

```java
List<Apple> apples = new ArrayList<>();
apples.add(new Apple());

List<Banana> bananas = new ArrayList<>();
apples.add(new Banana());

// 이미 과일이 담긴 리스트를 해당 메서드의 아규먼트로 넘길 때,
// <? extends Fruit>과 같이 사용하면 유연하게 사용할 수 있을 것이다.
public void print(List<? extends Fruit> fruits) {
	for (Fruit fruit : fruits) {
		System.out.println(fruit);
	}
}
// T 클래스를 produce하기 위해 List가 필요한 경우에 extends를 쓰는데,
// 위와 같은 메서드에서 Fruit으로 구성된 무언가를 만든다라고해서,
// "Producer는 extends다." 라고한다.
```
따라서 `<? extends T>` 같은 경우는 쓰기 작업보다는 읽기 전용으로 사용된다고 한다.

2. `<? super T>`
```java
List<? super Fruit> list = new ArrayList<>();
[Fruit, Class1, Class2, Object]
// 여기서 List는 분명히 Fruit의 상위클래스들을 수용하는 리스트가 분명하다.

// list는 Fruit 혹은 Fruit의 부모 타입이기 때문에, 
// Fruit과 그 하위타입을 추가할 수 있다는 것을 보장한다.

// 이 말이 많이 헷갈리는데, 나는 이렇게 이해했다.
// 위의 와일드카드의 범위는 [Fruit, Object] 일 것이다.
// 띠라서 List가 생성될 수 있는 경우의 수는 아래의 경우가 있을 것이다.
List<Fruit> list = new ArrayList<>();
List<Class1> list = new ArrayList<>();
List<Class2> list = new ArrayList<>();
List<Object> list = new ArrayList<>();
// 수용가능한 변수는 Fruit 객체밖에 없어.
// Fruit의 하위클래스만 넣을 수 있따.

Object obj = new Object();
list.add(obj); (x) // Fruit 이하 하위클래스만 넣을 수 있따.

// 이걸 보면 조금 느낌이 올 것이다. 결국에 list에는 Fruit의 하위 타입밖에 들어갈 수 없다.
// 왜냐하면 최소 범위가 Fruit이기 때문에, 
// 컴파일러는 최소한 해당 list에 들어간 원소가 Fruit 이상의 상위 타입이락고 생각할 것이기 때문이다.

list.add(new Apple());
list.add(new Banana());

// 반대로, get의 리턴값으로는 Object로만 반환되기 때문에,
// 무엇을 읽어오는지 중요하지 않을 때 사용된다.


List<Fruit> list = new ArrayList<>();
public void add(List<? super Fruit> fruits) {
	for (int i = 0; i < list.size(); i++) {
		fruits.add(list.get(i));
	}
}
```

T(Fruit) 클래스를 consume하기 위해 list에 add하는 경우에 사용한다.(super)
