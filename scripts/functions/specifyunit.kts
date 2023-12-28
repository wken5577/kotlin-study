// kotlin에서는 void함수도 Unit를 반환한다.
// Unit 타입은 toString, hashCode, equals만을 가지고 있다.

fun sayHello () : Unit = print("Hello World")
val message : Unit = sayHello()
println("result = $message") // result = kotlin.Unit