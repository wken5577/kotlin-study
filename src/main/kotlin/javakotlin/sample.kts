import javakotlin.JavaClass

val javaClass = JavaClass()
println(javaClass.zero)
println(javaClass.convertToUpper(listOf("Jack", "Jill")))
javaClass.suspend()

// when은 kotlin키워드이므로 특별하게 호출한다.
println(javaClass.`when`())