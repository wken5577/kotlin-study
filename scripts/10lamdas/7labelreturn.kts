/*
 * 현재 람다에서 즉시 나가고 싶다면 라벨 리턴을 사용하면 된다.
 * 라벨 리턴은 return@label 형태로 사용한다.
 * 라벨 리턴을 사용하면 현재의 람다에서 탈출이 가능하다
 */

fun invokeWith(n : Int, action : (Int) -> Unit){
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/*
 * here 라는 라벨을 사용하여 람다에서 라벨 리턴을 사용할 수 있게 한다.
 * 힘수 이름을 적어주어도 리턴이 가능하다 return@invokeWith 하지만 의도를 명확히 하기 위해 명시적 라벨을 사용하자
 */
fun caller(){
    (1..3).forEach{ i ->
        invokeWith(i) here@ {
            println("enter for $it")
            if (it > 1) return@here // here@ 마킹이 달려있는 함수를 탈출한다.
            println("exit for $it")
        }
    }
    println("end of caller")
}

caller()
println("end of script")