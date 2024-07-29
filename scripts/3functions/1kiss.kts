// kotlin으로 함수를 간결하게 작성하려면 다음과 같이 {} 블록이 아닌 = 기호를 통해 arg와 body를 구분할 수 있다.
// 이때 return문은 사용할 수 없고, 마지막 표현식이 함수의 반환값이 된다.

fun greet () = "hello world"
println(greet())

// 타입 추론
// 1kiss.kts:10:21: error: type mismatch: inferred type is String but Int was expected
// 다음과 같이 함수에서 String을 반환하려고 했지만, Int 변수에 대입하려고 한다면 타입 불일치 오류가 발생한다.
val message : Int = greet()

