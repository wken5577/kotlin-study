// 다음과 같이 vararg를 사용하면서 추가적인 인자를 받을 수 있따.

fun greetManny(msg : String, vararg names : String) {
    println("$msg ${names.joinToString(", " )}")
}

greetManny("Hello", "Dolly", "Manny", "Moe", "Jack", "Jill")