
open class MeetingTime(var time : String = ""){
    protected fun convertToString(time : Double) = String.format("%.02f", time)
}

class StartTime : MeetingTime() {
    infix fun at(time : Double) {
        this.time = convertToString(time)
    }
}
class EndTime : MeetingTime() {
    infix fun by(time : Double) {
        this.time = convertToString(time)
    }
}

class Meeting (val title : String) {
    val start = StartTime()
    val end = EndTime()
    override fun toString(): String {
        return "title : $title, start : ${start.time}, end : ${end.time}"
    }
}

infix fun String.meeting(block : Meeting.() -> Unit) {
    val meeting = Meeting(this)
    meeting.block()
    println(meeting)
}

/*
 * this.at(9.00)
 * this.by(12.00)
 *
 * 이게 원래의 호출이지만 at, by함수를 infix로 선언해서
 * this at 9.00
 * this by 12.00
 * 이렇게 호출할 수 있게 만들었다.
 *
 * 또한 meeting에 start, end라는 프로퍼티를 만들어서
 * this에 바인딩하였다.
 * 하지만 이랗게 하면 start at 대신 start by로 호출하거나 end by 대신 end at으로 호출할 수 있게 된다.
 * at, by 메소드는 모두 this(Meeting) 클래스의 메소드기 때문이다.
 * 이를 방지하기 위해 start, end를 각각 StartTime, EndTime 클래스로 분리하고
 * 이 두 클래스에 at, by 메소드를 정의하였다.
 *
 */

"Release Planning" meeting {
    start at 9.00
    end by 12.00
}
