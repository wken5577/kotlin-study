/*
 * 클래스 내부에서도 확장함수 구현이 가능하다
 * Point 클래스에서 Pair로 확장함수를 인젝트했다. 만약 외부에서 확장함수를 끄려고 하면 컴파일 에러가 난다.
 *
 * pointToString함수는 클래스 내부에 생성되었기 때문에 확장함수에는 this와 this@Point 두개의 리시버가 생긴다.
 * 하나는 익스텐션 리시버(this) -> Pair를 가리킴
 * 하나는 디스패치 리시버(this@Point) -> Point를 가리킴
 * pointToString 안에서 언급한 프로퍼티나 메서드는 익스텐션 리시버, 디스패치 리시버 순서로 확인하여 바인딩한다.
 * 즉, 익스텐션 리시버가 우선순위를 같는다. 속성에 충돌이 있을 때 익스텐션 리시버를 무시하고 디스패치 리시버로 바인딩하려면 this@Outer 문법을 사용하면 된다.
 */

class Point(x: Int, y: Int){
    private val pair = Pair(x, y)
    private val firstsign = if (pair.first < 0) "-" else "+"
    private val secondsign = if (pair.second < 0) "-" else "+"

    fun isInCircle(circle : Circle) : Boolean {
        val dx = circle.cx - pair.first
        val dy = circle.cy - pair.second
        return dx * dx + dy * dy <= circle.radius * circle.radius
    }

    override fun toString(): String = pair.pointToString()
    fun Pair<Int,Int>.pointToString() = "($firstsign${first}, $this@Point.secondsign${this.second})"
}