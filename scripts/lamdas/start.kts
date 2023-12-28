/*
 * kotlin 람다 표현식은 다음과 같은 구조로 되어있다
 * { parameter list -> body }
 * 바디는 일반적으로 단일 명령문 혹은 단일식이다. 필요하다면 여러 줄이 될 수도 있다.
 */

fun isPrime(n : Int) = n > 1 && (2 until n).none({ i : Int -> n % i == 0 })

// none이 파라미터를 하나만 받기 때문에 ()를 생략 가능하다
fun isPrime2(n : Int) = n > 1 && (2 until n).none{ i -> n % i == 0 }

//암시적 파라미터 사용 none의 i 처럼 람다가 하나의 파라미터만 받는다면 파라미터 정의 생략하고 it라는 이름의 특별한 암시적 파라미터 사용 가능
fun isPrime3(n : Int) = n > 1 && (2 until n).none{ n % it == 0 }