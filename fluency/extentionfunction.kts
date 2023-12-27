/*
 * 우리는 클래스에 메소드를 인제트한 것처럼 함수에 메소드를 인젝트할 수 있다.
 * Java는 andThen()이라는 메소드를 제공하지만, Kotlin은 andThen()을 제공하지 않는다.
 * 하지만 우리는 코틀린 fun에 확장함수를 사용하여 andThen()을 구현할 수 있다.
 */

/*
 * 확장함수의 시그니처를 보면 T타입 파라미터를 받고 R타입을 리턴하는 함수에 andThen()이 추가되었다.
 * andThen으로 전달되는 인자는 R타입을 받아서 U타입을 리턴하는 함수이다.
 * 결국 T -> R을 받아서 R -> U를 리턴하는 함수를 리턴하는 함수가 된다.
 */
fun <T, R, U> ((T) -> R).andThen(f: (R) -> U): (T) -> U {
    return { t: T -> f(this(t)) }
}

//위 함수를 사용해보자
fun increment(number : Int) : Double = number + 1.toDouble()
fun double(number : Double) : Double = number * 2
val incrementAndDouble = ::increment.andThen(::double)
println(incrementAndDouble(3)) // 8.0