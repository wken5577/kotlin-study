/*
 * 현재 람다에서 즉시 나가고 싶다면 라벨 리턴을 사용하면 된다.
 * 논로컬 리턴은 람다와 함께 구현된 현재 함수에서 나갈 때 유용하다 (비지역성)
 */

fun invokeWith(n : Int, action : (Int) -> Unit){
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

/*
 * if (i == 2) { return } -> 람다에서는 원래 return을 혀용하지 않지만 컴파일러가 에러를 내지 않는다.
 * 라벨 리턴과는 달리 다음과 같은 논로컬 리턴은 현재 실행중인 함수를 빠져나간다.
 * 예제 코드에서는 caller를 빠저나간다
 *
 * 왜 invokeWith에서의 return은 허용되지 않고 forEach에서의 return은 논로컬 리턴으로 동작할까?
 * 우리는 invokeWith 함수를 다음과 같이 정의했다. fun invokeWith(n : Int, action : (Int) -> Unit)
 * 하지만 forEach 코틀린 스탠다드 라이브러리는 다음과 같이 정의되어 있다 inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit
 * 답은 inline이라는 키워드에 있다.
 */
fun caller(){
    (1..3).forEach{ i ->
        println("in forEach for $i")
        if (i == 2) { return } // 여기서 caller()메서드를 빠져나간다.
        invokeWith(i){
            println("enter for $it")
            if (it == 2) return@invokeWith
            println("exit for $it")
        }
    }
    println("end of caller")
}

caller()
println("end of script")