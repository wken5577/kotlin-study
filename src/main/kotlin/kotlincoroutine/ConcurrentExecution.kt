package kotlincoroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
    println("main program starts : ${Thread.currentThread().name}")
    val time = measureTimeMillis {
        val msgOne = async{getMessageOne()}
        val msgTwo = async{getMessageTwo()}
        println("The message is ${msgOne.await()} ${msgTwo.await()}")
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
