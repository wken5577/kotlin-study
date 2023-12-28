package inheritance

/*
 * kotlin의 sealed class는 동일한 파일에 작성된 다른 클래스들에 확장이 어용되지만 그 외의 클래스들은 확장이 불가능하다
 * sealed 클래스의 생성자는 private이 표기되어 있지 않아도 private 취금된다.
 * sealed 클래스를 상속받은 클래스의 생성자를 private로 명시하지 않으면 상속받은 클래스를 통해 객체를 생성할 수 있다.
 */

sealed class Card(val suit :String)
class Ace (suit : String) : Card(suit)
class King (suit : String) : Card(suit) {
    override fun toString(): String {
        return "King of $suit"
    }
}
class Queen (suit : String) : Card(suit){
    override fun toString(): String {
        return "Queen of $suit"
    }
}
class Jack (suit : String) : Card(suit){
    override fun toString(): String {
        return "Jack of $suit"
    }
}
class Pip (suit : String, val number : Int) : Card(suit){
    init {
        if (number < 2 || number > 10) {
            throw IllegalArgumentException("Pip number must be between 2 and 10")
        }
    }
}
