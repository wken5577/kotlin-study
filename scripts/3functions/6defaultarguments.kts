// kotlin 함수는 다음과 같이 default arguments를 가질 수 있다.
// msg를 전달하지 않는다면 "Hello"가 기본값으로 사용된다.

fun greet(name : String, msg : String = "Hello") : String = "$msg $name"
println(greet("Kotlin")) // Hello Kotlin
println(greet("Kotlin", "Hi")) // Hi Kotlin

