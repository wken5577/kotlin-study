package async16

import kotlinx.coroutines.*
import java.net.URL

/**
 * timeout를 활용하면 코루틴에 시간제한을 걸고 그 이상의 시간이 사용된다면 CancellationException의 하위클래스인
 * TimeoutCancellationException을 받게할 수 있다
 */

suspend fun fetchResponse2(code: Int, delay: Int) = coroutineScope {
    try {
        val response = async {
            URL("http://httpstat.us/$code?sleep=$delay").readText()
        }.await()
        println(response)
    } catch (ex : CancellationException){
        println("${ex.message} for fetchResponse $code")
    }
}

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler {_, ex ->
            println("Exception handled : ${ex.message}")
        }
        val job = launch (Dispatchers.IO + handler) {
            withTimeout(3000) {
                launch { fetchResponse2(200, 5000) }
                launch { fetchResponse2(202, 1000) }
                launch { fetchResponse2(201, 2000) }
            }
        }
        job.join()
    }
}