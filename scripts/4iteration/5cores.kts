// when안에 변수를 넣으면은 해당 변수를 사용하는 곳을 when {} 블록 안으로 제한할 수 있다.
// 또한 변수의 선언이 함수 블록 안에서 빠졌기 때문에 when을 표현식으로써 그냥 리턴할 수 있다.

fun systemInfo() : String
    = when (val numberOfCores = Runtime.getRuntime().availableProcessors()){
        1 -> "1 core, packing peanuts"
        in 2..16 -> "$numberOfCores cores, that's nice"
        else -> "$numberOfCores cores, that's a lot"
    }


println(systemInfo())