package coroutines15

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * suspend 함수는 데이터를 리턴할 수 있다.
 * 하지만 코루틴은 해당 함수를 중간에 중단시키고 실행시킬 수 있는데 어떻게 상태가 스레드 사이에서 보존되고 전파될까?
 *
 * [예제 실행결과]
 * 2 received : Thread : DefaultDispatcher-worker-1
 * 3 received : Thread : DefaultDispatcher-worker-2
 * 2, returning 4 : Thread : DefaultDispatcher-worker-1
 * 3, returning 6 : Thread : DefaultDispatcher-worker-1
 *
 * 아래 예제를 보면 입력값 3으로 compute2를 실행시키는 코루틴은 스레드가 중간에 변경되었다.
 * 하지만 정확하게 중간 상태가 보존되고 6이라는 결과를 잘 리턴한다.
 * 이를 가능하게 하는 것이 컨테뉴에이션이다.
 * 컨테뉴에이션은 한 스레드에서의 실행 상태를 포착하고 보존한다. 그리고 다른 스레드에서 필요로 할때 불러올 수 있다.
 */

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