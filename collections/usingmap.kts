// kotlin에서는 map을 사용할 때 mapOf를 사용한다.
// key value를 같는 Pair를 to()로 만들어서 mapOf에 넣어주면 된다.

val sites = mapOf("pragprog" to "https://pragprog.com",
                  "google" to "https://google.com",
                  "oreilly" to "https://oreilly.com")

println(sites.size)
println(sites["pragprog"])

val size : String? = sites.get("aaaa") // 없다면 null이 나오기 때문에 Nullable 참조 타입 사용
println("size : $size")

// mapOf()함수는 읽기전용 참조만 전달해준다. 하지만 유리는 Pair를 +, - 연산자로 추가하거나 뺄 수 있다.
println("=== twitter 추가 ===")
val sites2 = sites + Pair("twitter", "https://twitter.com")
println(sites2)

println("=== twitter 제거 ===")
val sites3 = sites2 - "twitter"
println(sites3)

println("=== map 순회 ===")
for ((key, value) in sites) {
    println("$key : $value")
}