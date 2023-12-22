// Unit(void)를 제와한 값을 리턴할때는 else를 꼭 써야한다.
// Unit(void)를 리턴할때는 else를 쓰지 않아도 된다.

fun whatToDo(dayOfWeek: Any) = when(dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No clue"
}

println(whatToDo("Monday")) // Work hard
println(whatToDo("Saturday")) // Relax
println(whatToDo(3)) // Work hard
println(whatToDo("Friday")) // Party
println(whatToDo("other")) // what?
println(whatToDo(1)) // No clue