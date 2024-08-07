import java.lang.RuntimeException

/*
 * 코틀린은 람다 호출 오버헤드를 제거하고 성능을 향상시키기 위해 inline키워드를 제공한다.
 * invokeTwo를 inline으로 만들면, 그 영향으로 action1도 인라인이 된다. 하지만 noinline을 action2에 사용하면 action2는 최적회에서 제외할 수 있다.
 * 또한 인라인 람다에서는 논로컬 리턴이 가능하다. 왜냐하면 인라인 람다는 함수 내에서 확장되기 때문이다
 *
 */

fun invokeTwo(n : Int,
              action1 : (Int) -> Unit,
              action2 : (Int) -> Unit)
: (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return { _ : Int -> println("lamda returned from invokeTwo") }
}

fun callInvokeTwo(){
    invokeTwo(1, { i ->
        report(i)
    }, { i ->
        report(i)
    })
}

fun report(n : Int){
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().stackTrace
    println("Stack depth : ${stackTrace.size}")
    println("Partial listing of the stack : ")
    stackTrace.take(3).forEach(::println)
}

/*
 * callInvokeTwo, 함수를 호출하면 invokeTwo 함수를 호출하고 invokeTwo함수에서는 action1인 report를 호출한다
 * 호출 스택이 3개인 것이다.
 * inline을 활용하면 성능을 향상시킬 수 있다.
 */
callInvokeTwo()