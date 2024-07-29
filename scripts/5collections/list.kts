import java.util.TreeSet

// kotlin의 List<T>는 뮤터블과 이뮤터블 두가지로 구분된다.
// listOf함수는 이뮤터블을 반환하고, mutableListOf함수는 뮤터블을 반환한다.
// kotlin.collections.List<T>의 인터페이스는 컴파일 시간에 Java의 Arrays.asList()로 만든 JDK객체의 뷰로 동작한다

val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
println(fruits) // [banana, avocado, apple, kiwifruit]
println(fruits[0]) // banana
println(fruits[1]) // avocado
println(fruits.get(2)) // apple

//fruits[0] = "pear" // error 이뮤터블이라 변경 불가

// collection에 값이 있는지 없는지 확인하기 위해서 contains(), in 연산자를 사용할 수 있다.
println(fruits.contains("apple")) // true
println("apple" in fruits) // true

// 이뮤터블 리스트에 새로운 요소를 추가하기 위해선 +, - 연산자를 사용해서 기존 리스트를 카피하면서 새로운 요소를 추가하거나 뺄 수 있다.
println("=== + 연산자로 watermelon 추가하기 ===")
val fruits2 = fruits + "watermelon"
println(fruits2) // [banana, avocado, apple, kiwifruit, watermelon]

println("=== - 연산자로 apple 제거하기 ===")
val fruits3 = fruits - "apple"
println(fruits3) // [banana, avocado, kiwifruit]

println("=== fruits의 type ===")
println(fruits.javaClass) // class java.util.Arrays$ArrayList
println(fruits::class)

// fruits순회
for(data in fruits)
    print("$data ")
println()