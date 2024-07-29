// kotlin에서는 void함수도 Unit를 반환한다. 따라서 모든 함수는 표현식으로 취급될 수 있다.
// Unit 타입은 toString, hashCode, equals만을 가지고 있다.

fun sayHello () : Unit = println("Hello World")
val message : Unit = sayHello()
println("result = $message") // result = kotlin.Unit -> Unit타입의 toString()을 호출한 것임