package coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/*
 * 서스펜션 포인트 이후에 다른 스레드로 스위치 하고 싶다면 어떻게 해야할까?
 * 우리는 이런 작업을 CoroutineStart, CoroutineContext를 활용하여 할 수 있다.
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

/*
 * 코루틴을 현재 컨텍스트에서 실행시키기 위해서는 launch()의 두번째 옵셔널 전달인자인 CoroutineStart (optional) 값을 DEFAULT로 설정해야 한다.
 * CoroutineStart에는 DEFAULT, LAZY, ATOMIC, UNDISPATCHED 중 하나를 선택할 수 있다.
 * LAZY -> 명시적으로 start()가 호출되기 전까지 실행을 연기한다.
 * ATOMIC을 고르면 중달할 수 없는 모드로 실행한다.
 * UNDISPATCHED의 경우 처음엔 현재 컨텍스트에서 실행되지만 서스펜션 포인트 이후엔 스레드를 스위치해서 실행한다.
 *
 */

fun main(){
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher()
        .use { context ->
            println("start")
            runBlocking {
                launch(context = context, start = CoroutineStart.UNDISPATCHED) { task1() }
                launch { task2() }
                println("called task1 and task2 from Thread ${Thread.currentThread().name}")
            }
            println("done")
        }
}