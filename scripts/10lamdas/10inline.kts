import java.lang.RuntimeException

/*
 * inline을 활용하면 함수를 호출하는 대신 함수의 바이트코드가 함수를 호출하는 위치에 들어가게 된다.
 * 이렇게 해서 함수 호출의 오버헤드는 줄이지만 바이트코드가 커지게 된다.
 *
 * 어떤 이유로 람다 호출을 최적화하지 않는다면 noinline으로 표시하여 최적화를 제거할 수 있다.
 * invokeTwo 함수를 inline으로 만들면, 그 영향으로 action1, action2도 인라인이 된다.
 * 이때 noinline action1 : (Int) -> Unit 이렇게 선언하면 인라인 최적화에서 제외할 수 있다.
 *
 * action2에는 noinline을 붙여서 최적화에서 제외해봤다.
 * action1, action2 report를 확인하면 action2가 콜스텍이 더 깊다.
 */

inline fun invokeTwo(n : Int,
              action1 : (Int) -> Unit,
              noinline action2 : (Int) -> Unit)
        : (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return { _ : Int -> println("lamda returned from invokeTwo") }
}

fun callInvokeTwo(){
    invokeTwo(1, { n ->
//        if (n == 1) return // action1은 inline이기 때문에 논로컬 리턴이 가능하다
        report(n)
     }, ::report)
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
 * 확실히 콜스택이 줄어든것을 확인할 수 있다.
 */
callInvokeTwo()