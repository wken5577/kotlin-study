// raw문자열을 통해 우리는 이스케이프 문자 없이 문자열을 표현할 수 있다. 또한 멀티라인 문자열을 만들 수 있다
// trimMargin()을 통해 문자열의 앞부분을 제거할 수 있다.
// trimMargin()의 기본 구분자는 |이다. -> |가 시작점일 때 앞에 오는 모든 마진을 제거하고, 시작점이 |가 아니라면 무시한다.
// trimMargin()의 구분자를 변경하려면 trimMargin(">")와 같이 사용하면 된다.

fun createMemoFor(name: String): String {

    if (name == "EVE"){
        val memo = """Dear $name, a quick reminder about the 
                |party we have scheduled next Tuesday at
                |the 'Low Ceremony Cafe' at Noon. See you there. | Please bring your own mug.
                """.trimMargin()
        return memo
    }
    return ""
}

println(createMemoFor("EVE"))