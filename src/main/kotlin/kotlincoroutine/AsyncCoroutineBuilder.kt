package kotlincoroutine

import kotlinx.coroutines.*

/*
*  Coroutine builders (launch, async, runBlocing -> 3가지의 대표적인 코루틴 생성 함수)
*  2. async, (GlobalScope.async)
*  -> async는 launch와 비슷하지만 리턴값이 있다는 점이 다르다. (Deferred 객체를 리턴)
*  async도 부모 코루틴의 스코프와 쓰레드를 상속한다.
*/

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")
        val jobDefferd : Deferred<Unit> = async {
            println("thread work starts : ${Thread.currentThread().name}")
            delay(3000)
            println("thread work end : ${Thread.currentThread().name}")
        }
        val res : Unit = jobDefferd.await() // await() -> return값이 필요할 때
//        jobDefferd.join() -> return값이 필요 없을 때
        println("main program ends : ${Thread.currentThread().name}")
    }
}
