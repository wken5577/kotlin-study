// 익명 객체
// 익명 객체의 내부 타입은 함수나 메소드의 리턴 타입이 될 수 없다.
// 익명 객체의 내부 타입은 함수나 메소드의 파라미터가 될 수 없다.
// 익명 객체는 지역변수들을 그룹핑할 때만 유용하다.
// 익명 객체를 인터페이스의 구현체로 사용 가능하다.

fun drawCircle(){
    // 객체 표현식을 활용하여 익명 객체 생성
    val circle = object {
        val x = 10
        val y = 20
        val radius = 30
    }
    println("Circle x : ${circle.x} y : ${circle.y} radius : ${circle.radius} ")
}

drawCircle()

fun createRunnable() : Runnable {
    val runnable = object : Runnable {
        override fun run() {
            println("hello")
        }
    }
    return runnable
}
val aRunnable = createRunnable()
aRunnable.run()