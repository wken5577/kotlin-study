// RAW문자열
// 이스케이프 문자를 사용하면 코드가 드러워진다. RAW문자열을 사용하면 이스케이프 문자를 제거할 수 있다.


val name = "Eve"

val memo = """Dear $name, a quick reminder about the
picnic on Saturday at the park.
'See you there.' | "Please Do Not Late""""
println(memo)
