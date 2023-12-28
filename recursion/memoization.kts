import kotlin.system.measureTimeMillis
import kotlin.reflect.KProperty


fun fib(n : Int) : Long = when(n){
    0, 1 -> 1L
    else -> fib(n - 1) + fib(n - 2)
}

/*
 * fib 함수를 memoize 함수로 감싸서 실행시간을 측정해보자
 * Groovy방식을 이용해서 memoziation을 구현했다
 * lateinit을 사용해서 우리가 fibmemo를 초기화하는 것을 잊은 것이 아니라는 것을 알려준다.
 */

fun <T, R> ((T) -> R).memoize() : (T) -> R {
    val original = this
    val cache = mutableMapOf<T, R>()
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
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : (T) -> R = { n : T -> cache.getOrPut(n) { func(n) } }
}
val delegatefib : (Int) -> Long by Memoize {
    n : Int -> when(n){
        0, 1 -> 1L
        else -> delegatefib(n - 1) + delegatefib(n - 2)
    }

}


println(measureTimeMillis { fib (40) })
println(measureTimeMillis { fib (45) })
println(measureTimeMillis { fibmemo (40) })
println(measureTimeMillis { fibmemo (45) })
println(measureTimeMillis { delegatefib (40) })
println(measureTimeMillis { delegatefib (45) })