/*
 * 변수 델리게이션
 * 우리는 지역변수의 읽기와 쓰기에 대한 접근을 모두 가로챌 수 있다.
 * String 변수에 대한 접근을 가로채는 커스텀 델리게이션.
 */

package stringfilter

import kotlin.reflect.KProperty

/*
 * PoliteString 클래스는 델리게이션으로만 작동하도록 되어있다.
 * 코틀린에서는 인터페이스를 구현할 필요도 없이 단지 메소드만 있으면 된다. (getValue, setValue)
 *
 * content라는 뮤터블한 속성을 받는다. getValue 함수에서 문제가 되는 단어를 필터링한다.
 * 메소드들은 operator로 작성되어 = 기호를 get 또는 set을 호출하는 것으로 인식한다.
 */
class PoliteString(var content : String) {
    operator fun getValue(thisRef : Any?, property : KProperty<*>) : String {
        return content.replace("stupid", "s*****")
    }
    operator fun setValue(thisRef : Any?, property : KProperty<*>, value : String) {
        content = value
    }
}

var comment : String by PoliteString("Some nice message")
println(comment)

comment = "This is stupid"
println(comment)

/**
 * 다음과 같이 PoliteString을 사용할 수도 있다.
 */

fun beingpolite(content : String) = PoliteString(content)
var comment2 : String by beingpolite("hello")
println(comment2)