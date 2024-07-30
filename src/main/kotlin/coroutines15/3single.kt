package coroutines15

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.util.concurrent.Executors

/*
 * runBlocking 함수와 launch함수를 호출하면 호출자의 코루틴 스코프와 같은 스레드에서 코루틴을 실행시킨다.
 * 하지만 코루틴의 실행 컨택스트와 스레드를 원하는 곳으로 변경할 수 있다.
 *
 * single thread pool에서 직접 thread를 가져와서 launch함수에게 전해주면 해당 thread에서 함수를 실행시킨다.
 * 이제 동시실행이 아니라 병렬 실행이기 때문에 yield는 별 역할을 하지 않는다.
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

    // use함수를 사용하면 스레드를 사용 후 자원을 안전하게 정리해준다.
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