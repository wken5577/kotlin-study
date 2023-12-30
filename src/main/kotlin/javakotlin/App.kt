package javakotlin

object App {
    @JvmStatic
    fun main(@Suppress("UNUSED_PARAMETER") args : Array<String>){
        println("running app....")
        println(Util().f2c(50.0))
    }
}