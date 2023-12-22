// kotlin에서는 js처럼 destructuring을 지원한다.
// 함수의 리턴타입이 Pair나 Triple, 다른 데이터 클래스일 경우 destructuring을 사용할 수 있다.

fun getFullName() = Triple("John", "Quincy", "Adams")

val result = getFullName()
val first = result.first
val middle = result.second
val last = result.third
println("$first $middle $last") // John Quincy Adams

//**
// 모든 속성 가져오기
// val (first, middle, last) = getFullName()
// println("$first $middle $last") // John Quincy Adams
// **/

//**
// 일부 속성 가져오기
// val (first, _, last) = getFullName()
// println("$first $last") // John Adams
// **/

