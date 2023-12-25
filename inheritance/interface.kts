/**
 * Java8에서 default메소드가 처음 나왔지만 코틀린의 인터페이스에서 구현된 메소드 (doubleUp)는 Java1.6이상에서 사용 가능하다.
 * TVRemote class는 Remote 인터페이스를 구현한다는 것을 명시하기 위해서 주 생성자 뒤에 콜론 (:)을 사용하고 Remote를 적었다.
 * Java에서 인터페이스는 static 메소드를 가질 수 있다. 하지만 kotlin에서는 static 메소드를 직접 만들 수 없기 때문에 companion객체를 사용한다
 */

interface Remote{
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }
    companion object{
        fun combine(first : Remote, second : Remote) : Remote = object : Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }
        }
    }
}


class TV {
    private var volume = 0
    val remote : Remote
        get() = object :Remote{
            override fun down() {
                volume--
            }
            override fun up() {
                volume++
            }
        }

    override fun toString(): String {
        return "Volume : $volume"
    }
}

val tv = TV()
val remote : Remote = tv.remote
println(tv)
remote.up()
println(tv)
remote.doubleUp()
println(tv)

println("=== use companion ===")
val anotherTV = TV()
val combinedRemote = Remote.combine(remote, anotherTV.remote)
combinedRemote.up()
println(tv)
println(anotherTV)