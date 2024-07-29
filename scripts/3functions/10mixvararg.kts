// 다음과 같이 vararg를 사용하면서 추가적인 인자를 받을 수 있다.
// vararg는 인자 가장 마지막에 사용하는 것을 추천, 그렇지 않으면 명시적 인자를 사용해야 한다. greetMany("1", "2", msg = "hello")

fun greetManny(msg : String, vararg names : String) {
    println("$msg ${names.joinToString(", " )}")
}

greetManny("Hello", "Dolly", "Manny", "Moe", "Jack", "Jill")