/*
 * 코루틴을 만들어보자
 */

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun task1() {
    println("start task1 in Thread ${Thread.currentThread().name}")
    println("end task1 in Thread ${Thread.currentThread().name}")
}

fun task2() {
    println("start task2 in Thread ${Thread.currentThread().name}")
    println("end task2 in Thread ${Thread.currentThread().name}")
}

/*
 * runBlocking은 람다를 아규먼트로 받고 코루틴에서 실행한다.
 * launch은 주어진 람다를 실행하기 위해 새로운 코루틴을 시작시킨다.
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
