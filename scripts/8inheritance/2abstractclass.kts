/**
 * abstract로 시작하는 클래스는 추상 클래스이다.
 * 또한 추상 메서드는 abstract라고 표시한다.
 *
 * 추상 클래스 vs 인터페이스
 * 인터페이스에 정의된 속성엔 백킹 필드가 없다. 반변 추상 클래스는 백킹 필드를 가진다.
 * 여러 클래스 사이에서 상태를 다시 사용해야 한다면 추상 클래스
 * 하나 이상의 명세와 요구사항을 만족하는 클래스들을 원하지만 각각의 클래스들이 각각의 구현을 원한다면 인터페이스
 */

abstract class Musician(val name : String, val activeFrom : Int){
    abstract fun instrumentType() : String
}

class Cellist(name : String, activeFrom : Int) : Musician(name, activeFrom) {
    override fun instrumentType(): String {
        return "name : $name , activeFrom : $activeFrom"
    }
}

val ma = Cellist("Yo-Yo Ma", 1961)
println(ma.instrumentType())