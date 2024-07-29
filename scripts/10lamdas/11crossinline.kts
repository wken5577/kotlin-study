import java.lang.RuntimeException

/*
 * 인라인을 사용하지 않는 람다는 논로컬 리턴을 사용할 수 없다. 만약 인라인이라고 생각했던 람다가 실제로 인라인이 아니라면?
 * 함수가 인라인으로 마크되었다면, 노인라인으로 마크되지 않는 람다 파라미터는 인라인으로 간주된다.
 * 만약 해당 함수가 주어진 람다 파라미터를 다른 함수로 전달하거나 call한 함수에 다시 돌려보낸다면?
 */

/*
 * invokeTwo에서 두번째 인자로 받은 action2람다를 리턴하는 형식으로 수정했다.
 * invokeTwo가 인라인일 때 내부의 호출인 action1(n)역시 인라인이 될 수 있다.
 * 하지만 invokeTwo가 action2를 직접 호출하지 않기 때문에 마지막 줄의 람
 * 다에 포함된 action2(input)은 인라인이 될 수 없다.
 * 하지만 invokeTwo가 인라인이기 때문에 action1, action2는 인라인이 되어야 한다. (여기서 충돌)
 * action2에 noinline을 선언하지 않았기 때문에 충돌이 발생하고 컴파일 에러가 발생한다.
 *
 * 이 문제를 해결하는 방법은 두가지이다.
 * 1. action2에 noinline을 사용한다. -> noinline을 사용하면 성능상의 이득이 없어지고 논로컬 리턴을 사용할 수도 없다.
 * 2. crossinline을 사용한다. -> 이 경우 action2함수는 invokeTwo 함수가 아니라 호출되는 부분에서 inline이 된다. 또한 논로컬 리턴을 사용할 수 없도록 된다.
 * 이유는 crossinline 키워드가 붙은 람다가 다른 실행 컨텍스트에서 호출될 수 있기 때문이다.
 * 예를 들어, 다른 스레드에서 실행되는 경우, 람다 함수의 실행이 완료되기 전에 논로컬 리턴이 발생하면 해당 스레드에서 람다를 호출한 함수를 예상치 못하게 종료시킬 수 있다.
 * 이는 동시성 문제를 일으킬 수 있다.
 */
inline fun invokeTwo(n : Int,
              action1 : (Int) -> Unit,
              crossinline action2 : (Int) -> Unit)
: (Int) -> Unit {
    println("enter invokeTwo $n")
    action1(n)
    println("exit invokeTwo $n")
    return { input: Int ->
        action2(input)
    }
}

fun callInvokeTwo(){
    val res = invokeTwo(1, { i ->
        if (i == 2) { return }
        report(i)
    }, { i ->
//        if (i == 2) { return } // error : return is not allowed here
        report(i)
    })
    res(2)
}

fun report(n : Int){
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().stackTrace
    println("Stack depth : ${stackTrace.size}")
    println("Partial listing of the stack : ")
    stackTrace.take(3).forEach(::println)
}

callInvokeTwo()