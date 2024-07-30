package async16

import kotlinx.coroutines.*
import java.net.URL

/**
 * 코루틴이 처리해놓은 cancellation 예외가 아닌 다른 예외를 만난다면 코루틴은 자동으로 취소된다.
 * 코루틴이 취소되면 부모 코루틴도 취소되고 부모 코루틴의 모든 자식 코루틴도 취소된다.
 * supervisorScope를 활용하면 각각의 코루틴이 독립적으로 실행돼서 취소가 전파되지 않는다.
 * SupervisorJob를 활용하면 자식 코루틴의 에러가 부모에게 전파되지 않는다. (다른 형제 코루틴들은 취소되긴 함)
 */

suspend fun fetchResponse(code: Int, delay: Int) = coroutineScope {
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
        val job = launch (Dispatchers.IO + SupervisorJob() + handler) {
            launch { fetchResponse(200, 5000) }
            launch { fetchResponse(202, 1000) }
            launch { fetchResponse(404, 2000) }
        }
        job.join()
    }
}

