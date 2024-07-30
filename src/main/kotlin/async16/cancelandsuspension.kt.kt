package async16

import kotlinx.coroutines.*
import java.net.URL

/**
 * 코루틴의 취소는 cancel() 메소드나 cancelAndJoin 메소드를 통해 할 수 있다.
 * 단, 코루틴이 yield(), delay(), await() 같은 서스펜션 포인트에 진입해있다면 CancellationException을 발생시킨다.
 * isActive 프로퍼티로 취소요청을 확인할 수도 있다.
 */

suspend fun compute(checkActive : Boolean) = coroutineScope {
    var count = 0L;
    val max = 10000000000
    while(if (checkActive) {isActive} else (count < max)) {
        count++
    }
    if (count == max) {
        println("compute, checkActive $checkActive ignored cancellation")
    }else {
        println("compute, checkActive $checkActive bailed out early")
    }
}

val url = "http://httpstat.us/200?sleep=2000"
fun getResponse() = URL(url).readText()

suspend fun fetchResponse(callAsync: Boolean) = coroutineScope {
    try {
        val response = if (callAsync) {
            async { getResponse() }.await()
        } else {
            getResponse()
        }
        println(response)
    } catch (ex : CancellationException) {
        println("fetchResponse CancellationEx $callAsync : ${ex.message}")
    }
}

fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            launch { compute(checkActive = false) }
            launch { compute(checkActive = true) }
            launch { fetchResponse(callAsync = false) }
            launch { fetchResponse(callAsync = true) }
        }
        println("run ...")
        Thread.sleep(1000)
        println("cancel start,,")
        job.cancelAndJoin()
    }
}