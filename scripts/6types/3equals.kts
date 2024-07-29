// kotlin은 in 연산자로 해당 객체가 특정 타입인지 검사할 수 있다.
// equals()함수는 other가 Animal 타입인지 검사한다.
// kotlin은 ==연산자를 equals() 함수에 매핑해놓았다.
// 따라서 ==연산자를 사용하면 equals() 함수를 호출하는 것과 같다.

// is연산자는 객체가 참조로 특정 타입을 가리키는지 확인한다. 여기서는 other가 Animal 클래스인지 확인한다
// 만약 other !is Animal 이런 식으로 사용한다면 other가 Animal이 아니라는 것을 확인하는 것임
class Animal{
    override operator fun equals(other: Any?) = other is Animal
}


// Any로 타입을 설정한 것은 만약 greet를 String, odie를 Animal 타입으로 선언했다면
// 코틀린 컴파일러는 타입 불일치 때문에 동등성 검사를 하지 않는다.
// 3equals.kts:18:9: error: operator '==' cannot be applied to '_3equals.Animal' and 'String'
// println(odie == greet) //false

val greet : Any = "hello"
val odie : Any = Animal()
val toto : Any = Animal()

println(odie == greet) //false
println(odie == toto) //true
println(odie === toto) //false -> 서로의 참조는 다르다

