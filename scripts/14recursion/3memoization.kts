import kotlin.system.measureTimeMillis
import kotlin.reflect.KProperty

/**
 * 다음과 같이 피보나치 함수를 구현했다.
 * 이렇게 구현하면 f(2), f(3)같이 반복적인 결과를 계속 콜스텍을 타고 들어가서 계산하기 때문에 성능이 매우 느려질 수 있다.
 */

fun fib(n : Int) : Long = when(n){
    0, 1 -> 1L
    else -> fib(n - 1) + fib(n - 2)
}

/*
 * fib 함수를 memoize 함수로 감싸서 실행시간을 측정해보자
 * Groovy방식을 이용해서 memoziation을 구현했다
 *
 * memoize메서드를 람다 표현식에 인젝트하여 캐싱하는 로직을 추가했다.
 * memoize 함수에서 우리는 this를 로컬변수 original에 할당해서 오리지날 함수의 레퍼런스를 저장할 수 있다.
 * lateinit을 사용해서 우리가 fibmemo를 초기화하는 것을 잊은 것이 아니라는 것을 알려준다.
 */

fun <T, R> ((T) -> R).memoize() : (T) -> R {
    val original = this // fib함수가 될것임.
    val cache = mutableMapOf<T, R>()

    // 만약 map에 데이터가 있다면 데이터 리턴, 그렇지 않다면 두번째 파라미터의 람다식의 결과를 리턴한다
    return { n : T -> cache.getOrPut(n) { original(n) } }
}

lateinit var fibmemo : (Int) -> Long
fibmemo = { n : Int -> when(n){
    0, 1 -> 1L
    else -> fibmemo(n - 1) + fibmemo(n - 2)
}}.memoize()



/*
 * delegate를 사용해서 memoize를 구현해보자
 */

class Memoize<T, R>(val func: (T) -> R){
    val cache = mutableMapOf<T, R>()
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : (T) -> R =
        { n : T -> cache.getOrPut(n) { func(n) } }
}

val delegatefib : (Int) -> Long by Memoize {
    n : Int -> when(n){
        0, 1 -> 1L
        else -> delegatefib(n - 1) + delegatefib(n - 2)
    }

}

println(" == no memoization == ")
println(measureTimeMillis { fib (40) })
println(measureTimeMillis { fib (45) })

println(" == memoization == ")
println(measureTimeMillis { fibmemo (40) })
println(measureTimeMillis { fibmemo (45) })

println(measureTimeMillis { delegatefib (40) })
println(measureTimeMillis { delegatefib (45) })