/*
 * 코루틴을 시작하기 전에 함수 호출을 순차적으로 하는 코드로 시작해보자.
 */

fun task1() {
    println("start task1 in Thread ${Thread.currentThread().name}")
    println("end task1 in Thread ${Thread.currentThread().name}")
}

fun task2() {
    println("start task2 in Thread ${Thread.currentThread().name}")
    println("end task2 in Thread ${Thread.currentThread().name}")
}

println("start")
run {
    task1()
    task2()
    println("called task1 and task2 from Thread ${Thread.currentThread().name}")
}

println("done")
