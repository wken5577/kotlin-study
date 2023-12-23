// kotlin은 참조의 타입이 확인되면 스마트 캐스팅을 한다.
// equals() 메서드에 더이상 ((Animal) other).age 이런식으로 캐스팅 할 필요가 없다.

class Animal(val age : Int){
    override operator fun equals(other: Any?) : Boolean{
        return if (other is Animal) age == other.age else false
    }
}

val odie  = Animal(2)
val toto  = Animal(2)
val butch = Animal(3)

println(odie == toto) //true
println(odie == butch) //false