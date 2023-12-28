import java.lang.RuntimeException

/*
* 클래스 안의 메소드를 정의할 때는 fun 키워드를 사용한다. 메소드는 기본으로 public이 된다.
* fun 키워드 앞에 접근제어자 (private, protected, internel)를 이용해서 메소드의 접근 권한을 설정할 수 있다.
* */

class Person(val first : String, val last : String){
    var fulltime = true
    var location : String = "-"
    constructor(first : String, last : String, fte : Boolean) : this(first, last){
        fulltime = fte
    }
    constructor(first : String, last : String, loc : String) : this(first, last, false){
        location = loc
    }

    internal fun fullName() = "$last, $first"
    private fun yearsOfService () : Int = throw RuntimeException("not impled")

    override fun toString(): String = "$first $last $fulltime $location"
}

println(Person("Jane", "Doe"))
println(Person("Jane", "Doe", false))
println(Person("Jane", "Doe", "home").fullName())