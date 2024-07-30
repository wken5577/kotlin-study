package coroutines15

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/*
 * 코루틴을 한 컨텍스트에서 실행하다가 중간에 컨텍스트를 바꾸고 싶다면 어떨까??
 * kotlin은 이를 위해 withContext()함수를 가지고 있다.
 *
 * withContext는 새로운 코루틴을 실행시키지 않는다. 반면에 launch로 실행시킨 람다는 새로운 코루틴에서 실행된다.
 * runBlocking과 launch 함수에 CoroutineName() 인스턴스를 전달하여 이름 설정 가능
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