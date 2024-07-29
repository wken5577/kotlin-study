// kotlin ranges
// kotlin에서는 다음과 같이 반복을 할 수 있다 (for문을 사용하지 않고)

val oneToFive : IntRange = 1..5
val aToE : CharRange = 'a' .. 'e'
val seekHelp : ClosedRange<String> = "hell"  .. "help"

// 문자열이 범위 안에 존재하는지 확인
println("=== 문자열이 범위 안에 존재하는지 확인 ===")
println(seekHelp.contains("helm")) // true
println(seekHelp.contains("helq")) // false

// 정방향 반복
println("=== 정방향 반복 ===")
for (i in 1..5) {print("$i ")} // 1 2 3 4 5
println()
for (i in oneToFive) {print("$i ")} // 1 2 3 4 5
println()

//**
// seekHelp는 ClosedRange<String> 타입이므로 반복이 불가능하다 iterator가 없기 때문이다
// 서드파티 클래스 인젝팅을 확용해서 iterator를 만들 수 있다
// for (word in seekHelp) {print("$word ")} // error
// println()


// 역방향 반복
// 5..1로 범위를 만드려하면 동작하지 않는다. 이때는 downTo() 메소드를 활용하면 된다.
println("=== 역방향 반복 ===")
for (i in 5.downTo(1)) {print("$i ")} // 5 4 3 2 1
println()

// 중위표기법으로 간단하게 만들 수 있다. (.과 ()를 생략)
for (i in 5 downTo 1) {print("$i ")} // 5 4 3 2 1
println()


// 범위안의 값 건너뛰기
println("=== 범위안의 값 건너뛰기 ===")
for (i in 1 until 5) {print("$i ")} // 1 2 3 4 -> until은 마지막 값을 포함하지 않는다.
println()

// step을 사용해서 건너뛸 수 있다
for (i in 1..5 step 2) {print("$i ")} // 1 3 5 -> i += 2 처럼 동작
println()
for(i in 5 downTo 1 step 2) {print("$i ")} // 5 3 1
println()

// filter method로 세심하게 걸러낼 수 있다
for (i in (1..9).filter { it % 3 == 0 }) {print("$i ")} // 3 6 9