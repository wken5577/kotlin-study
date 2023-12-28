package coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/*
 * 코루틴을 한 컨텍스트에서 실행하다가 중간에 컨텍스트를 바꾸고 싶다면 어떨까??
 * kotlin은 이를 위해 withContext()함수를 가지고 있다.
 */

private suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread().name}")
    yield()
    println("end task1 in Thread ${Thread.currentThread().name}")
}

private suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread().name}")
    yield()
    println("end task2 in Thread ${Thread.currentThread().name}")
}


fun main(){
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher()
        .use { context ->
            println("start")
            runBlocking {
                withContext(Dispatchers.Default) { task1() }
                launch { task2() }
                println("called task1 and task2 from Thread ${Thread.currentThread().name}")
            }
            println("done")
        }
}