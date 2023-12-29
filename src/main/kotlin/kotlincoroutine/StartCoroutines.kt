package kotlincoroutine

import kotlinx.coroutines.*

/*
 * launch 함수는 non-blocking으로 코루틴을 실행한다. 하지만 runBlocking 함수는 blocking으로 코루틴을 실행한다.
 */

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")
        GlobalScope.launch { // Thread T1
            println("thread work starts : ${Thread.currentThread().name}")
            mySuspendFunction(1000) // 이 코루틴 블록은 suspended되지만 Thread T1은 block되지 않고 free해진다.(다른 코루틴에 가서 작업 가능)
            println("thread work end : ${Thread.currentThread().name}") // Thread T1 이거나 다른 스레드일수 있다.
        } // 현재 main thread를 블록하는 코루틴을 생성
        mySuspendFunction(2000)
        println("main program ends : ${Thread.currentThread().name}")
    }
}

suspend fun mySuspendFunction(time : Long) {
    delay(time)
}