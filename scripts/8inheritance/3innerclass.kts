

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

/**
 * this@TV.toString() -> 여기서 this는 TVRemote를 나타내지만 this@TV는 외부 클래스인 TV의 인스턴스를 나타낸다. (이런식으로 외부 클래스에 접근)
 * super@TV.toString() -> super을 사용하면 TV의 베이스 클래스인 Any의 toString()에 접근한다.
 */
class TV {
    private var volume = 0
    val remote : Remote
        get() = TVRemote()

    override fun toString(): String {
        return "Volume : $volume"
    }
    inner class TVRemote : Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--
        }

        override fun toString(): String {
            return "Remote : ${this@TV.toString()}"
        }
    }
}

val tv = TV()
val remote = tv.remote
println(tv)
remote.up()
println(tv)
remote.doubleUp()
println(tv)
println(remote)