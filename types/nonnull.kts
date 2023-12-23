// 참조타입이 null불가인 곳에 null을 리턴하려고 하면 컴파일 오류가 난다.

fun nickname(name : String) : String {
    if (name == "William") {
        return "Bill"
    }
    return null // error: type mismatch: inferred type is <null> but String was expected
}

println("""nickname("William") = ${nickname("William")}""")
println("""nickname("John") = ${nickname("John")}""")
println("""nickname("John") = ${nickname(null)}""") // error: the integer literal does not conform to the expected type String