package inheritance
import inheritance.*

fun porcess(card : Card) = when (card) {
    is Ace -> "Ace"
    is King -> "King"
    is Queen -> "Queen"
    is Jack -> "Jack"
    is Pip -> card.number.toString()
}

fun main(){
    println(porcess(Ace("Spades")))
    println(porcess(King("Hearts")))
    println(porcess(Queen("Diamonds")))
    println(porcess(Jack("Clubs")))
    println(porcess(Pip("Hearts", 2)))
}