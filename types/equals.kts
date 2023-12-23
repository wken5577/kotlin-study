// kotlin은 in 연산자로 해당 객체가 특정 타입인지 검사할 수 있다.
// equals()함수는 other가 Animal 타입인지 검사한다.
// kotlin은 ==연산자를 equals() 함수에 매핑해놓았다.
// 따라서 ==연산자를 사용하면 equals() 함수를 호출하는 것과 같다.

class Animal{
    override operator fun equals(other: Any?) = other is Animal
}

val greet : Any = "hello"
val odie : Any = Animal()
val toto : Any = Animal()

println(odie == greet) //false
println(odie == toto) //true

