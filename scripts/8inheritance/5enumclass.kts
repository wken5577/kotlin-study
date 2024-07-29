/*
 *  enum으로 특정한 정해진 문자를 처리할 수 있다
 */

enum class Suit {
    HEARTS, SPADES, DIAMONDS, CLUBS
}

sealed class Card(val suit : Suit)
class Ace(suit : Suit) : Card(suit)
class King(suit : Suit) : Card(suit)

println(Ace(Suit.HEARTS).suit) // HEARTS

// valueOf함수를 자동으로 제공해준다
// 이를 통해 해당하는 enum 인스턴스를 얻을 수 있다.
val diamonds = Suit.valueOf("DIAMONDS")

// values는 enum클래스의 인스턴스의 모든 값을 배열로 제공해 준다.
// enum 인스턴스의 name과 ordinal 속성이 이름과 인스턴스에 정의된 인덱스로 리턴된다.
for (suit in Suit.values()) {
    println("$suit has value ${suit.ordinal}")
}