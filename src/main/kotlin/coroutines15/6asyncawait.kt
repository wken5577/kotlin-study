package coroutines15

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * lauhch 함수는 Job객체를 리턴한다. 이를 통해 코루틴의 종료를 기다리거나 취소를 기다릴 수 있다.
 * 따라서 launch 함수는 무조건 Job를 리턴하기 때문에 람다의 결과를 받을 수 없다.
 * 작업을 비동기로 실행사고 실행결과도 받고 싶다면 launch대신 async를 사용해야 한다.
 *
 * async는 launch와 동일한 파라미터를 받는다.
 * 차이점은 async는 Deffered<T> 퓨처 객체를 리턴 한다는 점이다.
 */

fun main() {
    runBlocking {
        val count: Deferred<Int> = async(Dispatchers.Default) {
            println("fetching in ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }

        println("Called the function in ${Thread.currentThread()}")
        println("Number of cores is ${count.await()}")
    }
}