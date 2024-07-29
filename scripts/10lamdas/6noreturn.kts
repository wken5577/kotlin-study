/*
 * 람다에서는 return값이 있더라도 return 키워드를 가질 수 없다
 * 익명 함수는 리턴할 값이 있는 경우 return을 반드시 사용해야 한다.
 */

// 이 함수는 Int와 람다 2개의 파라미터를 받고 Unit을 리턴하는 함수이다
fun invokeWith(n : Int, action : (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}


fun caller(){
    (1..3).forEach{ i ->
        invokeWith(i){
            println("enter for $it")

            /**
             * if (it > 1) return 이를 호출하면 코틀린은 이게 어떤 의미인지 모른다.
             * 1. 즉시 action람다 함수에서 빠져나오고 invokeWith 함수의 action(n) 이후의 나머지를 실행
             * 2. for loop를 빠져나와라
             * 3. caller함수에서 빠져나와라
             */
//            if (it > 1) return // 람다에서 return 키워드를 사용할 수 없다
            println("exit for $it")
        }
    }
    println("end of caller")
}

caller()
println("end of script")