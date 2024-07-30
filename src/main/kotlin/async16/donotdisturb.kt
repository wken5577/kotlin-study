package async16

import kotlinx.coroutines.*

/**
 *  종종 작업이 중간에 취소되지 않기를 원할 수 있다.
 *  withContext(NonCancellable) 함수를 호출하면 코루틴은 중간에 취소되지 않는다
 *
 *  doWork는 호출자의 코루틴의 컨텍스트에서 실행된다. 번저 실행된 함수는 취소가 가능하다
 *  그후 withContext(NonCancellable) 블럭으로 진입하는데 이 때 발생하는 delay는 취소가 불가능하다
 *  하지만 취소 명령이 들어오면 isActive 프로퍼티는 변경된다.
 */

suspend fun doWork(id: Int, sleep : Long) = coroutineScope {
    try {
        println("$id: entered $sleep")
        delay(sleep)
        println("$id: finished nap $sleep")
        withContext(NonCancellable) {
            println("$id: do not disturb, plz")
            delay(5000)
            println("$id: Ok, you can talk to me now")
        }
        println("$id: outside the restricted context")
        println("$id: isActive : $isActive")
    } catch (ex: CancellationException) {
        println("$id : doWork($sleep) was cancelled")
    }
}

fun main() {
    runBlocking {
        val job = launch (Dispatchers.Default){
            launch { doWork(1, 3000) }
            launch { doWork(2, 1000) }
        }
        Thread.sleep(2000)
        job.cancel()
        println("cancelling")
        job.join()
        println("done")
    }
}