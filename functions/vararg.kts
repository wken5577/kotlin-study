// kotlin에서 다음과 같이 다중 인자를 받을 수 있다.

fun max(vararg numbers: Int): Int {
    var large = Int.MIN_VALUE
    for (number in numbers) {
        large = if (number > large) number else large
    }
    return large
}

println(max(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) // 10
println(max (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 1000, 10000)) // 10000