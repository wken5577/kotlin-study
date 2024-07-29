/*
 * kotlin closures
 * 람다는 클로저라고 불린다. 왜냐하면 람다는 스코프를 로컬이 아닌 속성과 메소드로 확장할 수 있기 때문이다.
 *
 * doubleIt에 할당된 함수 바디에는 factor가 없다. (로컬 변수가 아니다)
 * 컴파일러는 factor 변수에 대한 클로저의 범위 즉 클로저의 바디가 정의된 곳을 살핀다.
 * factor 변수가 클로저의 바디에 정의되지 않았기 때문에 컴파일러는 다시 스코프를 한단계 확장해서 찾아보고 이런식으로 찾을때까지 반복한다. -> 렉시컬 스코핑
 */

var factor = 2
val doubleIt = { e: Int -> e * factor }

/*
 * 코틀린은 클로저 안에서 뮤터블 변수의 값을 읽거나 변경하는 것을 막지 않는다.
 * 위 예시에서 factor가 var로 선언되어 있었다면 클로저 안에서 해당 변수의 값을 변경할 수 있었을 것이다.
 * 이는 혼란을 야기할 수 있다.
 *
 * 클로저 함수가 정의된 후에 클로저에서 사용한 변수의 값을 변경하면 어떻게 될까?
 * list에서는 factor가 생성될 때의 factor의 값을 사용하고, sequence에서는 실행될 때의 factor의 값을 사용한다.
 */

val doubled = listOf(1, 2).map { it * factor } // 이때 factor의 값은 2이기 때문에 이후 0으로 바뀌더라도 2를 사용
val doubleAlso = sequenceOf(1, 2).map{ it * factor } // 이후 factor가 0으로 바뀌기 때문에 0을 사용
factor = 0
doubled.forEach { println(it) }
println("==================")
doubleAlso.forEach { println(it) }
