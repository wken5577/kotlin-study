/*
 * 람다를 파라미터로 받는 람다를 만들어보자
 * 암시적 파라미터도 같이 사용했다
 */

// 파라미터의 마지막에 람다를 받도록 하면 간단한 코드를 짜는데 도움이 된다
fun walk1To(n : Int, action : (Int) -> Unit ) = (1..n).forEach{ action(it) }

// walk1To(5, { n -> print(n) }) -> 이것과 동일, 암시적 파라미터 it를 사용한것임
walk1To(5, { print(it) }) //12345

// 람다가 마지막 파라미터라면 괄호 밖으로 빼낼 수 있다
walk1To(5) { print(it) } //12345

/*
 * 함수 참조 사용하기
 * walk1To로 전해지는 람다는 단순히 받은 파라미터를 print함수로 전달하기만 한다.
 * 람다를 패스스루로 전달하면 훨씬 더 읽기 편해진다.
 * ({x -> someMethod(x) }) -> (::someMethod) 이렇게 바꿀 수 있다.
 * walk1To함수에서 forEach{ action(it) } 이부분을 다음과 같이 바꿔서 패스스루로 전달 가능하다
 * forEach(action)
 *
 * print함수는 action함수와 다르게 람다가 아니기 때문에 람다를 print로 대체할 수 없다.
 * 만약 함수가 람다에 적합하다면 함수이름 앞에 ::를 붙인다.
 */

walk1To(5, ::print) //12345

//만약 System.out.println을 람다식에 보낸다면 .을 ::로 바꾸어야 한다
walk1To(5, System.out::print)


fun send(n : Int) = println(n)
walk1To(5, this::send) //12345

object Terminal {
    fun write(n : Int) = println(n)
}
walk1To(5, Terminal::write) //12345