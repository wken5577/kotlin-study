/*
 * enum class는 상태와 메서드를 가질 수 있다. 메소드를 정의할 때는 값이 끝나는 곳에 세미콜론을 붙어야한다.
 * display 메소드는 각각의 enum 상수에 대해 오버라이드 될 수 있다. (각 enum이 class같은 느낌이다)
 * 만약 display 메소드를 추상 메소드로 정의했다면 각 enum 상수는 반드시 오버라이드 해야한다.
 * 더욱이 open으로 정의하여 Hearts enum은 display 메소드를 오버라이드 해서 사용했다.
 * Hearts는 Suit의 인스턴스가 아니고 display 메소드를 오버라이드 하는 익명 내부 클래스다
 *
 * 메서드를 오버리이드 하길 원하는 suit엔 display를 오버라이드하고 그렇지 않은 suit는 이미 구현된 메소드를 사용
 */

enum class Suit(val symbol : Char){
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665'){
        override fun display() {
            println("$symbol $name $symbol")
        }
    },
    SPADES('\u2660');
    open fun display() = println("$symbol $name")
}

for (suit in Suit.values()) {
    suit.display()
    println(suit.javaClass)
}