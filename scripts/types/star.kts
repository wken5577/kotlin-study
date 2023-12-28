// <*> 스타 프로젝션은 지네릭 읽기전용 타입과 raw타입을 위한 코틀린의 기능이다.
// 스타 프로젝션은 읽는 것만 허용하고 쓰는 것은 허용하지 않는다.

fun printValues(values : Array<*>){
    for (value in values)
        println(value)
//    values[0] = values[1] error
}

printValues(arrayOf(1, 2))