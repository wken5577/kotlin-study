// kotlin은 null가능 타입이 있는데 타입 옆에 ?를 붙여주면 컴파일 에러가 나지 않는다.
// ?붙어있는 타입을 참조하려면 null인지 항상 검사해야 한다.
// 참조시 ?를 붙여서 null 검사를 우아하게 할 수 있다 name?.reversed() -> name이 null이라면 결과는 null이다

fun nickName (name : String?) : String{
    // if (name != null) return name.reversed() else return "No one"
    return name?.reversed() ?: "No one"
}

println("""nickName("William") = ${nickName("William")}""")
println("""nickName("John") = ${nickName("John")}""")
 println("""nickName("null") = ${nickName(null)}""")


 /**
  *  ?:엘비스 연산자를 사용하면 null일 때 기본값을 지정할 수 있다.
  *  val result = name?.reversed()?.toUpperCase()
  *  return if (result == null) "Joker" else result
  *
  *  -> ?:엘비스 연산자 사용하여 다음과 같이 수정 가능
  *  return name?.reversed()?.toUpperCase() ?: "Joker"
  */

/**
 * !!연산자를 횔용해서 null이 아닌 것이 확실한 변수에 사용할 수도 있다.
 * return name!!.reversed().toUpperCase()
 * name이 null이 아니라고 확신했지만 혹시나 null이라면?? 실행중 NullPointerException이 발생할 수 있다.
 * 웬만하면 사용하지 말자
 */