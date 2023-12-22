// 이런식으로 when 안에 변수를 넣어서 스코프를 제한하고 return문을 제거할 수 있다.

fun systemInfo() : String
    = when (val numberOfCores = Runtime.getRuntime().availableProcessors()){
        1 -> "1 core, packing peanuts"
        in 2..16 -> "$numberOfCores cores, that's nice"
        else -> "$numberOfCores cores, that's a lot"
    }


println(systemInfo())