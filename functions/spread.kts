// javascript처럼 spread 연산자를 사용 가능하다. *를 사용한다.

fun max(vararg numbers: Int): Int {
    var large = Int.MIN_VALUE
    for (number in numbers) {
        large = if (number > large) number else large
    }
    return large
}

println(max(*intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // 10
println(max (*listOf(1, 2, 3).toIntArray())) // 3