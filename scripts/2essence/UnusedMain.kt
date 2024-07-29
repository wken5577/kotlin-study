// 사용하지 않는 파라미터가 있다면 컴파일시에 warning 로그를 띄운다
//  UnusedMain.kt:3:13: warning: parameter 'n' is never used
//  fun compute(n : Int) = 0
//            ^

fun compute(n : Int) = 0
fun main() = println(compute(3))