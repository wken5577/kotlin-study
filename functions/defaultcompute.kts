// 기본 argument에는 값이 아닌 표현식을 사용해도 된다.
// 여기서 msg와 name의 위치를 바꾸면 컴파일 오류가 발생한다. msg가 기본값을 생성할 때 name이 정의되어 있어야 하기 때문이다.

fun greet(name : String, msg : String = "Hi ${name.length}") : String = "$msg $name"
println(greet("Kotlin")) // Hi 6 Kotlin
println(greet("Kotlin", "Hello")) // Hello Kotlin