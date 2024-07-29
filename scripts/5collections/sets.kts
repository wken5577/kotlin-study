// kotlin에서도 set을 사용할 수 있다.

// muitableSetOf() -> 뮤터블 셋 반환
// hashSetOf() -> java.util.HashSet 반환
// linkedSetOf() -> LinkedHashSet 반환
// sortedSetOf() -> TreeSet반환

val fruits : Set<String> = setOf("Apple", "Banana", "Orange", "Apple" )
println(fruits)
println(fruits::class)
println(fruits.javaClass)

