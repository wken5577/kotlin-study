/*
* 주 생성자를 작성하지 않았다면 kotlin은 아규먼트가 없는 기본 생성자를 생성한다.
* 만약에 주 생성자가 모든 파라미터를 위한 아규먼트를 가지고 있다면 코틀린은 주 생성자와 함께 아규먼트가 없는 생성자를 생정한다.
* 이렇게 만드는 생성자를 보조 생성자라고 한다.
* 보조 생성자는 주 생성자를 호출하거나, 다른 보조 생성자를 호출해야만 한다. 보조 생성자의 파라미터도 역시 val이나 var을 사용 불가능하다.
* 보조 생성자에서는 속성을 선언할 수 없고, 주 생성자와 클래스 내부에서만 속성을 정의할 수 있다.
* */

/*
* perspn의 주 생성자는 2개의 속성 first와 last를 val로 선언했다. 주 생성자에서 constructor키워드는 선택사항이다.
* 두 개의 보조 생성자는 constructor키워드로 선언했다.
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

    override fun toString(): String = "$first $last $fulltime $location"
}

println(Person("Jane", "Doe"))
println(Person("Jane", "Doe", false))
println(Person("Jane", "Doe", "home"))