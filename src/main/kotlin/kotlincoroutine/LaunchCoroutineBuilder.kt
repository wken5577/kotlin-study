package kotlincoroutine

import kotlinx.coroutines.*

/*
*  Coroutine builders (launch, async, runBlocing -> 3가지의 대표적인 코루틴 생성 함수)
*  1. launch, (GlobalScope.launch)
*  -> launch function은 해당 local scope가 내려가면 (예를들어 호출한 함수) launch로 생성한 코루틴도 같이 내려간다. (끝이 나던 말건)
*  하지만 GlobalScope.launch를 사용하면 해당 코루틴은 프로그램이 끝날때까지 살아있게 된다. (스코프를 global로 확장)
*
*  GlobalScope는 사용 후 잊게되면 프로그램이 끝날때까지 살아있기 때문에 메모리 누수의 원인이 될 수 있다. 따라서 신중히 사용하자
*  launch 함수는 Job 객체를 리턴하는데 이것으로 해당 코루틴을 컨트롤할 수 있다.
*
*  보통 runBlocking { launch {} } 이런식으로 2개의 코루틴을 생성하면 launch는 runBlocking의 코루틴의 스코프와 쓰레드를 상속한다.
*/

fun main () {
    runBlocking {
        println("main program starts : ${Thread.currentThread().name}")
        val job : Job = launch { // Thread T1
            println("thread work starts : ${Thread.currentThread().name}")
            delay(3000) // 이 코루틴 블록은 suspended되지만 Thread T1은 block되지 않고 free해진다.(다른 코루틴에 가서 작업 가능)
            println("thread work end : ${Thread.currentThread().name}") // Thread T1 이거나 다른 스레드일수 있다.
        } // 현재 main thread를 블록하는 코루틴을 생성
        job.join() // job이 끝날때까지 기다린다.
        println("main program ends : ${Thread.currentThread().name}")
    }
}
