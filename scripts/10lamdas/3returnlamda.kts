/*
 * 람다를 리턴하는 함수
 */

fun predicatioOfLength(length : Int) : (String) -> Boolean {
    return { input : String -> input.length == length }
}

// find 함수는 String을 받고 Boolean을 리턴하는 함수를 인자로 받는다.
val names = listOf<String>("Sarah", "John", "Peter", "Susan", "Meghan", "Kimberly")

println(names.find { name -> name.length == 5 })
println(names.find { name -> name.length == 4 })

// 다음과 같이 람다를 리턴하는 함수를 활용해서 간단하게 할 수 있다.
println(names.find(predicatioOfLength(5)))
println(names.find(predicatioOfLength(4)))
