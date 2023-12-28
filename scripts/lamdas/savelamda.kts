/*
 * 변수에 람다식 저장
 */


val names = listOf<String>("Sarah", "John", "Peter", "Susan", "Meghan", "Kimberly")

// 람다식 저장
val checkLength5 = {name : String -> name.length == 5}
println(names.find(checkLength5))

// 익명 함수 저장
val checkLength4 = fun (name : String) : Boolean = name.length == 4
println(names.find(checkLength4))