package kotlincoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
    println("main program starts : ${Thread.currentThread().name}")
    val time = measureTimeMillis {
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()
        println("The message is $msgOne $msgTwo")
    }
    println("Time taken $time")
    println("main program ends : ${Thread.currentThread().name}")
}

private suspend fun getMessageOne() : String {
    delay(1000)
    return "Hello"
}

private suspend fun getMessageTwo() : String {
    delay(1000)
    return "World"
}
