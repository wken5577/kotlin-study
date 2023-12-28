/*
 * 람다를 파라미터로 받는 람다를 만들어보자
 * 암시적 파라미터도 같이 사용했다
 */

// 파라미터의 마지막에 람다를 받도록 하면 간단한 코드를 짜는데 도움이 된다
fun walk1To(n : Int, action : (Int) -> Unit ) = (1..n).forEach(action)

walk1To(5, { print(it) }) //12345

// 람다가 마지막 파라미터라면 괄호 밖으로 빼낼 수 있다
walk1To(5) { print(it) } //12345

/*
 * 함수 참조 사용하기
 * 람다를 패스스루로 사용하면 훨씬 더 읽기 편해진다
 * walk1To에 전달된 람다에서 파라미터는 print()로 전달되기만 했다. 이를 간단하게 바꿀 수 있다
 * 만약 다른 람다로 패스스루 된다면 ::는 필요 없다 action은 람다식이기 때문에 ::제거 가능하다
 * 하지만 print는 람다식이 아니기 때문에 ::가 필요하다
 */
walk1To(5, ::print) //12345

fun send(n : Int) = println(n)
walk1To(5, this::send) //12345

object Terminal {
    fun write(n : Int) = println(n)
}
walk1To(5, Terminal::write) //12345