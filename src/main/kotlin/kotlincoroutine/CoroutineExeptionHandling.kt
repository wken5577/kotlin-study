package kotlincoroutine

import kotlinx.coroutines.*


/*
 * 코루틴이 취소되면 suspend function (delay, yield 등) 실행시 CancellationException이 발생한다.
 * finally블록에서 suspend function을 사용하지 못한다 (이미 해당 코루틴이 취소됐기 때문), 만약 사용한다면 또다른 exception이 발생한다.
 * 만약 finally블록에서 suspend function을 사용하고 싶다면 withContext(NonCancellable)을 사용하면 된다.
 */

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")

        val job : Job = launch(Dispatchers.Default){
            try{
                for (i in 0..500){
                    print("$i.")
                    delay(5)
                }
            }catch (e : Exception){
                println("\nException : ${e.message}")
            }finally {
                withContext(NonCancellable){
                    println("finally block executed")
                    delay(1000)
                    println("delay in finally block")
                }
            }
        }
        delay(10)
        job.cancel(CancellationException("My own message")) //다음과 같이 메세지 전달 가능
        job.join()
        println("\nmain program ends : ${Thread.currentThread().name}")
    }
}
