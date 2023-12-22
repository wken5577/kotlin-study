// pair를 활용해보기
// **
// Pair("Tom", "Jerry") == ("Tom", "Jerry")
// mapOf("Tom" to "Jerry", "Alice" to "Bob") -> {Tom=Jerry, Alice=Bob}
// 페어와 트리플은 모두 이뮤터블이다
// **

fun getTemperatureAtAirport(code :String) : String = "${Math.round(Math.random() * 30) + code.count() } C"

val airportCodes : List<String> = listOf("LAX", "SFO", "PDX", "SEA")

val temperatures = airportCodes.map { code -> code to getTemperatureAtAirport(code) }

for(temp in temperatures){
    println("The temperature at ${temp.first} is ${temp.second}")
}