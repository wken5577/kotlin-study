import java.time.DayOfWeek

// Unit(void)를 제와한 값을 리턴할때는 else를 꼭 써야한다.
// Unit(void)를 리턴할때는 else를 쓰지 않아도 된다.
// when은 순차적으로 비교해서 처음으로 조건이 만족되는 상태대로 결과가 반환된다.

// 표현식으로써의 when
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

// 명령문으로써의 when
fun printWhatToDo(dayOfWeek: Any) {
    when(dayOfWeek) {
        "Saturday", "Sunday" -> println("Relax")
        in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> println("Work hard")
        in 2..4 -> println("Work hard")
        "Friday" -> println("Party")
        is String -> println("What?")
    }
}
