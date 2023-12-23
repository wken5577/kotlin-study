// kotlin은 null가능 타입이 있는데 타입 옆에 ?를 붙여주면 컴파일 에러가 나지 않는다.
// ?붙어있는 타입을 참조하려면 null인지 항상 검사해야 한다.
// 참조시?를 붙여서 null 검사를 우아하게 할 수 있다
// ?:엘비스 연산자를 사용하면 null일 때 기본값을 지정할 수 있다.

fun nickName (name : String?) : String{
    // if (name != null) return name.reversed() else return "No one"
    return name?.reversed() ?: "No one"
}

println("""nickName("William") = ${nickName("William")}""")
println("""nickName("John") = ${nickName("John")}""")
 println("""nickName("John") = ${nickName(null)}""")