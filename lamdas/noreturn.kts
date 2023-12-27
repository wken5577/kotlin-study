/*
 * 람다에서는 return값이 있더라도 return 키워드를 가질 수 없다
 */

fun invokeWith(n : Int, action : (Int) -> Unit){
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

fun caller(){
    (1..3).forEach{ i ->
        invokeWith(i){
            println("enter for $it")
//            if (it > 1) return // 람다에서 return 키워드를 사용할 수 없다
            println("exit for $it")
        }
    }
    println("end of caller")
}

caller()
println("end of script")