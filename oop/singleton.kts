// object 키워드와 {}블록 사이에 이름을 넣는다면 코틀린은 이를 표현식이 아니라 명령문 또는 선언으로 인식한다.
// 익명 객체를 만들땐 객체 표현식을 사용하고 싱들톤을 만들 땐 객체 선언을 사용하자

object Sun : Runnable {
    val radiusInKM = 696000
    var coreTemperatureInC = 15000000
    override fun run() {
        println("spin ...")
    }
}
fun moveIt (runnable : Runnable) = runnable.run()

println(Sun.radiusInKM)
moveIt(Sun)