import java.net.URL

/*
 * injecting을 통해서 메소드와 속성을 주입할 수 있다.
 * pointToString 메소드에서는 익스텐션 리시버와 (this) -> Pair, 디스패치 리시버 (this@Point) -> Point 두 가지가 생성된다.
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
data class Circle(val cx : Int, val cy : Int, val radius : Int)

/*
 * contains method를 circle에 주입한다.
 * Circle클래스에 contains 메소드가 추가되었다.
 * 코틀린의 확장 함수는 패키지의 static 메소드로 만들어진다
 * circle을 첫번째 인자로 전달하고 이어서 실제 파라미터를 전달한다.
 *
 * 확장 함수의 한계는 기존 클래스의 메소드와의 충돌문제, 그리고 인스턴스의 캡술화된 부분(private)에 접근할 수 없다는 것이다.
 */

// 해당 함수에 operator 키워드를 붙이면 연산자 오버로딩을 인젝트할 수 있다. 즉 point in circle이 가능해진다.
// infix를 이용하여 point1 in circle과 같은 중위 표기법을 사용할 수 있다.
operator infix fun Circle.contains(point : Point) = point.isInCircle(this)

val circle = Circle(100, 100, 25)
val point1 = Point(110, 110)
val point2 = Point(10, 100)
println(circle.contains(point1)) // true
println(circle.contains(point2)) // false
println(circle contains point1) // true
println(point2 in circle) // false


/*
 * 확장 속성은 클래스 내부에 존재하는 것이 아니기 때문에 백킹 필드를 가질 수 없다.
 * 즉 확장 속성은 field에 접근 불가능하다
 * circle에 area 속성을 주입한다.
 *
 * 아래에서 getter를 사용한 것 처럼 setter도 사용할 수 있지만 setter가 field에 접근할 수 없기 때문에 클래스의 다른 메소드에 의존해야 한다.
 */
val Circle.area : Double
    get() = Math.PI * radius * radius

println(circle.area) // 1963.4954084936207


/*
 * 다음과 같이 서드파티 클래스에 확장함수를 추가할 수 있다.
 * 기존에 존재하는 메소드를 확장하면 기존 메소드를 오버라이드한다.
 */

fun String.lastChar() : Char = this.get(this.length - 1)
fun String.toUpperCase() = this.lowercase()
val str = "Hello"
println(str.lastChar()) // o
println(str.toUpperCase()) // hello

/*
 * static 메소드 인젝팅
 * 컴패니언 객체에 인젝팅할 수 있다.
 * 클래스가 컴패니언 잭체를 가지고 있다면 static 메소드를 추가할 수 있다
 */
fun String.Companion.toURL(link : String) = URL(link)
val url : URL = String.toURL("http://kotlinlang.org")
println(url) // http://kotlinlang.org

