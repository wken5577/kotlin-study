package kotlincoroutine

import kotlinx.coroutines.*

/*
 * withTimeout은 코루틴을 실행하는 도중에 지정된 시간이 지나면 코루틴을 종료시킨다.
 * withTimeout은 코루틴을 종료시키는 것이기 때문에 TimeoutCancellationException이 발생한다.
 * withTimeoutOrNull 은 TimeoutCancellationException이 발생하지 않고 null을 반환한다.
 *
 */

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")

        // 2000ms가 지나면 TimeoutCancellationException 발생 그전에 람다식이 끝나야함
        withTimeout(2000){
            try{
                for(i in 0..500){
                    print(i)
                    delay(500)
                }
            }catch (e : TimeoutCancellationException){
                println("\n exception : ${e.message}")
            }finally {
                println("\nwithTimeout finally")
            }
        }
        coroutineScope {  }
        println("\nmain program ends : ${Thread.currentThread().name}")
    }
}