/*
 *  enum으로 특정한 정해진 문자를 처리할 수 있다
 *  valueOf함수를 자동으로 제공해준다
 */

enum class Suit {
    HEARTS, SPADES, DIAMONDS, CLUBS
}

sealed class Card(val suit : Suit)
class Ace(suit : Suit) : Card(suit)
class King(suit : Suit) : Card(suit)

println(Ace(Suit.HEARTS).suit) // HEARTS
val diamonds = Suit.valueOf("DIAMONDS")

for (suit in Suit.values()) {
    println("$suit has value ${suit.ordinal}")
}