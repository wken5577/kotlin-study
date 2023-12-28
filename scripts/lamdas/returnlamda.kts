/*
 * 람다를 리턴하는 함수
 */

fun predicatioOfLength(length : Int) : (String) -> Boolean {
    return { input : String -> input.length == length }
}

val names = listOf<String>("Sarah", "John", "Peter", "Susan", "Meghan", "Kimberly")
println(names.find(predicatioOfLength(5)))
println(names.find(predicatioOfLength(4)))
