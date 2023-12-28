// Array<T> 클래스는 코틀린의 배열이다.

// friends 변수는 kotlin.Array<T> 이지만 실제 타입은 JAVA의 String[] 이다.
println("=== string array example ===")
val friends = arrayOf("Bob", "Jane", "Mark")

println(friends::class) ;
println(friends.javaClass) // [Ljava.lang.String;
println("friends[0] = ${friends[0]}")

// numbers 변수는 kotlin.Array<T> 이지만 실제 타입은 JAVA의 Integer[] 이다.
// Integer class로 작업을 하면 프리미티브 타입 int를 사용할 떄에 비해서 오버헤드가 크다
println("=== Integer array example ===")
val integers = arrayOf(1, 2, 3, 4, 5)
println(integers::class) // class kotlin.Array
println(integers.javaClass) // class [Ljava.lang.Integer;

// int[]을 만들기 위해서는 다음과 같이 intArrayOf() 함수를 사용한다.
println("=== int array example ===")
val ints = intArrayOf(1, 2, 3, 4, 5)
println(ints::class) // class kotlin.IntArray
println(ints.javaClass) // class [I