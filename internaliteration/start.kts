/*
 * kotlin의 외부 반복자와 내부 반복자를 비교해보자
 */

val numbers = listOf(10, 12, 15, 17, 18, 19)

//외부 반복자
for (i in numbers){
    if (i % 2 == 0){
        print("$i ")
    }
}
println()
//내부 반복자
numbers.filter { it % 2 == 0 }.forEach { print("$it ") }


println()
println("=== double list ===")

val doubled = mutableListOf<Int>()

//외부 반복자
for (i in numbers){
    if (i % 2 == 0){
        doubled.add(i * 2)
    }
}
println(doubled)

//내부 반복자
val doubledEven = numbers.filter { it % 2 == 0 }.map { it * 2 }
println(doubledEven)