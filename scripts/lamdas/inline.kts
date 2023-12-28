import java.lang.RuntimeException

/*
 * inline을 활용하면 함수를 호출하는 대신 함수의 바이트코드가 함수를 호출하는 위치에 들어가게 된다.
 * 이렇게 해서 함수 호출의 오버헤드는 줄이지만 바이트코드가 커지게 된다.
 */

inline fun invokeTwo(n : Int,
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
    invokeTwo(1, ::report, ::report)
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