// 우리는 이전처럼 for(x in ...) 문법을 이용해서 배열을 반복할 수 있다.
// arrayOf() 함수는 배열을 생성한다.

val array = arrayOf(1, 2, 3)
for (i in array) {
    print("$i ")
}
println()


//listOf() 함수는 List<T>를 생성한다.
val list = listOf(1, 2, 3)
println(list.javaClass) // class java.util.Arrays$ArrayList
for (i in list) {
    print("$i ")
}
println()

// indices 프로퍼티는 배열의 인덱스 범위를 반환한다.
for (i in array.indices) {
    println("idx = $i, element = ${array[i]}")
}

// index와 element를 동시에 얻을 수 있다. destructuring을 이용한다.
for ((idx, element) in array.withIndex()) {
    println("idx = $idx, element = $element")
}