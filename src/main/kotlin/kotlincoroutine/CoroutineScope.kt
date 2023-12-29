package kotlincoroutine

import kotlinx.coroutines.*

/*
 * 코루린 스코프는 각 스코프마다 고유하다
 * 하지만 코루틴 컨텍스트는 부모에서 자식으로 상속될 수 있다.
 *
 * 코루틴 컨텍스트는 Job, Dispatcher, CoroutineName, CoroutineExceptionHandler 등으로 이루어져 있다.
 * Job -> 코루틴의 상태를 관리한다.
 *
 */

fun main(): Unit = runBlocking { //Thread : main
    // this : CoroutineScope
    // coroutineContext : CoroutineContext instance

    // coroutineContext 상속
    launch {
        println("C1 : ${Thread.currentThread().name}") // Thread : main
        delay(1000L)
        println("C1 : ${Thread.currentThread().name}") // Thread : main
    }

    // Global 스코프에 자신의 코루틴 컨텍스트를 생성
    launch(Dispatchers.Default) {
        println("C2 : ${Thread.currentThread().name}") // Thread : T1
        delay(1000L)
        println("C2 : ${Thread.currentThread().name}") // Thread : T1 or other thread
    }

    //처음엔 부모의 컨텍스트를 상속 -> 이후에 새로운 코루틴 컨텍스트로 변경
    launch(Dispatchers.Unconfined) {
        println("C3 : ${Thread.currentThread().name}") // Thread : T1
        delay(1000L)
        println("C3 : ${Thread.currentThread().name}") // Thread : other thread
        launch (coroutineContext){
            println("C4 : ${Thread.currentThread().name}") // Thread : println("C3 : ${Thread.currentThread().name}")를 실행한 스레드
            delay(1000L)
            println("C4 : ${Thread.currentThread().name}") // Thread : println("C3 : ${Thread.currentThread().name}")를 실행한 스레드
        }
    }

}