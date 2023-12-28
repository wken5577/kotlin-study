package coroutines

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.util.*
import java.util.concurrent.Executors

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

/*
 * single thread pool에서 직접 thread를 가져와서 launch함수에게 전해주면
 * 해당 thread에서 함수를 실행시킨다.
 *
 * 이제 동시실행이 아니라 병렬 실행이기 때문에 yield는 별 역할을 하지 않는다.
 */

fun main(){
    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { context ->
        println("start")
        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("called task1 and task2 from Thread ${Thread.currentThread().name}")
        }
        println("done")
    }
}