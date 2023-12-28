/*
 * 재귀를 사용하면 입력사이즈가 클때 런타임중에 stackoverflow가 발생할 수 있다.
 * tailrec 키워드를 사용하면 컴파일러가 재귀를 반복문으로 바꿔준다.
 * 단 재귀호출이 마지막일 경우에만 가능하다.
 */

import java.math.BigInteger

object Factorial{
    /*
 * 재귀호출이 마지막일 경우에만 tailrec 키워드를 사용할 수 있다.
 * 하지만 해당 함수의 마지막 실행은 n.toBigInteger() * factorialRec(n - 1) 에서 * 연산자가 실행되는 부분이다.
 * factorialRec이 재귀를 마칠 때까지 연산을 수행하지 않기 때문이다
 */
    fun factorialRec(n : Int) : BigInteger =
        if (n <= 1) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)

    /*
     * tailrec 키워드를 사용하고 재귀호출이 마지막이 되도록 수정하자
     */
    tailrec fun factorial(n : Int, result : BigInteger = 1.toBigInteger()) : BigInteger =
        if (n <= 1) result else factorial(n - 1, n.toBigInteger() * result)

}

//println(factorialRec(5))
//println(factorial(50000)) //정상동작