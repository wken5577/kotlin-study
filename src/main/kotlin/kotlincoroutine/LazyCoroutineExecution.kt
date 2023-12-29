package kotlincoroutine

import kotlinx.coroutines.*

/*
 * start =LAZY는 await()가 호출되기 전까지는 코루틴을 실행하지 않는다.
 */

fun main() {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")

        val msgOne = async (start = CoroutineStart.LAZY){ getMessageOne() }
        val msgTwo = async (start = CoroutineStart.LAZY){ getMessageTwo() }

        println("The message is ${msgOne.await()} ${msgTwo.await()}")

        println("main program ends : ${Thread.currentThread().name}")
    }
}

private suspend fun getMessageOne() : String {
    println("After delay in getMessageOne Thread ${Thread.currentThread().name}")
    delay(1000)
    return "Hello"
}

private suspend fun getMessageTwo() : String {
    println("After delay in getMessageTwo Thread ${Thread.currentThread().name}")
    delay(1000)
    return "World"
}
