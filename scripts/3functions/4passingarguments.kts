// 코틀린에서 함수 파라미터의 타입을 정의할 때는 candidate(후보) :Type 형태의 문법을 활용한다.
// 여기서 함수 arg는 mutable인지 immutable인지 궁금할 수 있다.

fun greet(name : String) : String {
//  name = "World" // error: val cannot be reassigned -> 함수에 전해지는 인자는 immutable이다
    return "Hello $name"
}
println(greet("Kotlin")) // Hello Kotlin