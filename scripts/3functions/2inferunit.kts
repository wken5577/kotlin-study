// kotlin은 Unit이라는 특별한 타입을 사용한다. (Unit은 Java의 void와 비슷하다.)
// sayHello함수는 리턴값이 없기 때문에 kotlin은 타입을 Unit으로 추론한다. 따라서 message에 Unit을 할당하려고 하면 에러가 발생한다.

fun sayHello() = println("Well, hello there!")
val message : String = sayHello() // error: type mismatch: inferred type is Unit but String was expected