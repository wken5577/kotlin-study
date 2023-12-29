package kotlincoroutine

import kotlinx.coroutines.*

/*
*  Coroutine builders (launch, async, runBlocing -> 3가지의 대표적인 코루틴 생성 함수)
*  3. runBlocing
*  -> 보통 테스트에 많이 사용된다.
*/

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")
        val jobDefferd : Deferred<Unit> = async {
            println("thread work starts : ${Thread.currentThread().name}")
            delay(3000)
            println("thread work end : ${Thread.currentThread().name}")
        }
        println("main program ends : ${Thread.currentThread().name}")
    }
}

suspend fun myOwnSuspendingFunction() {
    delay(1000)
}