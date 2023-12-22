// 여기서 함수 arg는 mutable인지 immutable인지 궁금할 수 있다

fun greet(name : String) : String {
    name = "World" // error: val cannot be reassigned -> 함수에 전해지는 인자는 immutable이다
    return "Hello $name"
}
println(greet("Kotlin")) // Hello Kotlin