// <*> 스타 프로젝션은 지네릭 읽기전용 타입과 raw타입을 위한 코틀린의 기능이다.
// 스타 프로젝션은 읽는 것만 허용하고 쓰는 것은 허용하지 않는다.
// 타입에 대해 정확히 알 수는 없지만 타입 안정성을 유지하면서 파라미터를 전달할 때 사용된다.

fun printValues(values : Array<*>){
    for (value in values)
        println(value)
//    values[0] = values[1] error
}

printValues(arrayOf(1, 2))