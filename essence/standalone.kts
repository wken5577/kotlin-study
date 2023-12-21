// kotlin은 class의 선언을 강제하지 않는다
// 해당 코드를 자동으로 class로 감싸준다. error stack을 보면 Standalone이라는 동기화된 클래스의 메소드 안으로 들어가있다.

fun nofluff(){
    println("Hello World")
    throw Exception("This is an exception")
}

println("Start")
try{
    nofluff()
} catch (e: Exception){
    val stackTrace = e.stackTrace
    println(stackTrace[0])
    println(stackTrace[1])
} finally {
    println("End")
}