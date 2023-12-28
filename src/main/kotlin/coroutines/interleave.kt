package coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

private suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread().name}")
    yield()
    println("end task1 in Thread ${Thread.currentThread().name}")
}

private suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread().name}")
    yield()
    println("end task2 in Thread ${Thread.currentThread().name}")
}

/*
 * kotlin의 코루틴 라이브러리는 서스펜션 포인트(중단점)을 포함하고 있다.
 * 작업을 중간에 중단시키고 다른 작업을 실행시킬 수 있는데 이를 delay와 yield 함수로 지원한다.
 * delay는 함수가 현재 실행중인 작업을 지정된밀리초만큼 멈추게 하는 함수이다.
 * yield는 명시적인 지연을 만들지 않는다. (yield를 사용하면 작업이 더 중요한 작업들의 실행을 기다린다.)
 * 두 메소드 모두 대기중인 다른 작업을 실행할 기회를 준다.
 *
 * kotlin은 suspend 키워드를 어노테이트된 함수에서만 서스펜션 포인트를 지원한다.
 *
 * 실행결과
    start
    called task1 and task2 from Thread main
    start task1 in Thread main
    start task2 in Thread main
    end task1 in Thread main
    end task2 in Thread main
    done
 * task1이 첫번째 라인을 실행하고 실행흐름을 넘겨줬다 (yield)
 * 따라서 task2가 실행되었고 첫번째 라인을 실행시킨 후 다시 실행 흐름을 넘였다 (yield)
 * 이는 동시 실행의 아주 좋은 예제로 작동하였다.
 */

fun main(){
    println("start")
    runBlocking {
        launch { task1() }
        launch { task2() }
        println("called task1 and task2 from Thread ${Thread.currentThread().name}")
    }

    println("done")
}
