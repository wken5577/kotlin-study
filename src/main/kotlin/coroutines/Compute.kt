package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Compute {
    fun compute1(n : Long) : Long = n * 2
    suspend fun compute2(n : Long) : Long {
        val factor = 2
        println("$n received : Thread : ${Thread.currentThread().name}")
        delay(n * 1000)
        val result = n * factor
        println("$n, returning $result : Thread : ${Thread.currentThread().name}")
        return result
    }
}

fun main(){
    runBlocking {
        val compute = Compute()
        launch(Dispatchers.Default) {
            compute.compute2(2)
        }
        launch(Dispatchers.Default) {
            compute.compute2(3)
        }
    }
}