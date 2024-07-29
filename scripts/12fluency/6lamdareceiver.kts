/*
 * 암시적 리시버
 * String.(Int) -> Unit은 람다가 String의 인스턴스의 컨텍스트에서 실행된다는 의미를 가지고 있다.
 * 리시버를 사용하는 람다를 호출할 때 우리는 추가적인 아규먼트를 전달해줘야 한다.
 * 즉 내부에서 this에 바운딩 될 컨텍스트 또는 리시버가 필요하다.
 *
 * length는 렉시컬 스코프에 값이 아니고 리시버의 length를 사용한다.
 */
var length = 100
val printIt: String.(Int) -> Unit = { n : Int ->
    println("n is $n, length is $length")
    println("this : $this")
}

// 리시버를 사용하는 람다를 호출할 때 리시버를 람다 내부에서 this에서 바인딩하는 방법중 하나
printIt("Hello", 42)

// 리시버를 사용하는 람다를 리시버의 멤버 함수처럼 사용할 수도 있다.
"Hello".printIt(42)

// String과 Int 리시버에서 동작하는 2개의 함수
fun top(func : String.() -> Unit) = "hello".func()
fun nested(func : Int.() -> Unit) = (-2).func()

top {
    println("In outer lamda $this and $length")
    nested {
        println("In nested lambda $this and ${toDouble()}")
        println("length = $length")
        println("this@top = ${this@top}")
    }
}