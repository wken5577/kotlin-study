/*
 * Boolean 중복로직과 같은 단축 평가 (지금까지 진행한 식의 평가가 결과를 도출하기에 충분할 경우 식의 실행을 건너뜀)
 * 지연 델리게이션은 이런 접근의 영역을 넓혀준다.
 * 가상의 getTEmperature함수는 웹 서비스에 원격 호출을 해야하기 때문에 호출 시 사용요금을 내야한다 가정해보자
 * 단축 평가는 자연스럽게 호출을 줄일 수 있다
 */

fun getTemperature(city : String) : Double {
    println("fetch from web service for $city")
    return 30.0
}

/*
 * val showTemperature = false
 * val temperature = getTemperature(city) // fetch from website
 * if (showTemperature && temperature > 20)
 *    println("warm")
 * else
 *    println("not")
 * -> 이런식의 getTemperature 호출은 비효율적이다 if의 단축평가 때문에 temperature는 사용되지도 않았기 때문이다.
 *
 * 지연 델리게이션을 사용한다면 컴파일러에게 식의 실행을 지연하라고 요청할 수 있다
 * 변수 temperature를 by 키워드를 사용해서 델리게이션 속성으로 변경했다.
 * lazy함수는 연산을 실행할 수 있는 람다 표현식을 아규먼트로 받는다. 그리고 필요한 순간에만 실행한다.
 * 해당 코드에서 getTemperature는 temperature >= 30의 평가가 필요한 시점에서 실행이 된다.
 */

val showTemperature = true
val temperature by lazy { getTemperature("Seoul") }
if (showTemperature && temperature >= 30) {
    println("Hot!")
}