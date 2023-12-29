package kotlincoroutine

import kotlinx.coroutines.*

/*
 * 코루틴은 delay와 같은 suspending function을 사용중일 때 cancel할 수 있다.
 * 또는
 * isActive를 사용하여 코루틴이 취소되었는지 확인할 수 있다.
 */

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")

        val job : Job = launch(Dispatchers.Default){
            for (i in 0..500){
                print("$i.")
                if (!isActive) {
                    return@launch
                }
//                delay(50)
//                yield()
            }
        }
        delay(10)
        job.cancelAndJoin()
        println("\nmain program ends : ${Thread.currentThread().name}")
    }
}
