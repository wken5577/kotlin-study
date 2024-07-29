/*
 * 지역변수뿐만 아니라 객체의 속성에도 델리게이션 접근을 할 수 있다.
 * 우리가 이전에 만든 PoliteString 델리게이션의 변형을 사용할 예정이다.
 */

import kotlin.reflect.KProperty

class PoliteString(val dataSource : MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : String {
//        println("ref $thisRef")
        println("property ${property.name} is being read")
        return (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("ref $thisRef")
        println("property ${property.name} is being assigned to $value")
        dataSource[property.name] = value
    }
}

/*
 * title, likes는 dataSource에 저장이 위임된다. (MutableMap은 setValue, getValue 메소드를 가지고 있기 때문에 자동으로 delegation적용이 가능하다)
 * title을 읽을 때 코틀린은 dataSource에 속성 이름인 title을 전달하여 dataSource의 getValue("title")을 호출한다. (key가 title인 value를 반환)
 * comment 속성의 읽기와 쓰기는 PoliteString의 getValue와 setValue 메소드를 호출한다.
 */
class PostComment(dataSource : MutableMap<String, Any>) {
    val title : String by dataSource
    var likes : Int by dataSource
    var comment : String by PoliteString(dataSource)
    override fun toString(): String {
        return "PostComment(title='$title', likes=$likes, comment='$comment')"
    }
}

val data = mutableMapOf<String, Any>(
    "title" to "My Great Post",
    "likes" to 42,
    "comment" to "This post is awesome"
)
val post = PostComment(data)
post.likes = post.likes + 1
post.comment = "This post is stupid"
println(post)
